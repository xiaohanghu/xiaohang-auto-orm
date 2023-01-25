package org.auto.jdbc.orm;

import org.auto.jdbc.orm.meta.BeanMeta;
import org.auto.jdbc.orm.meta.BeanMetaManager;
import org.auto.jdbc.orm.nameconverter.CamelToUnderline;
import org.auto.jdbc.orm.sql.*;
import org.auto.jdbc.orm.util.BeanValueUtils;
import org.auto.jdbc.orm.util.ResultSetValueGetterManager;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-8
 * Time: ÏÂÎç7:26
 * To change this template use File | Settings | File Templates.
 */
class DefaultBeanSqlGenerator implements BeanSqlGenerator {
    private Map<BeanMeta, Map<SqlGenerator, String>> sqlCaches = new ConcurrentHashMap<BeanMeta, Map<SqlGenerator, String>>();
    private BeanMetaManager beanMetaManager;

    public DefaultBeanSqlGenerator(BeanMetaManager beanMetaManager) {
        this.beanMetaManager = beanMetaManager;
    }


    private String DELETE_SQL_NAME = "delete";
    private String UPDATE_SQL_NAME = "update";
    private String INSERT_SQL_NAME = "insert";
    private String INSERT_WITHOUT_ID_SQL_NAME = "insert_without_id";
    private String GET_ALL_SQL_NAME = "get_all";
    private Map<String, SqlGenerator> sqlGeneratorMap = new HashMap<String, SqlGenerator>();

    {
        sqlGeneratorMap.put(INSERT_SQL_NAME, new InsertSqlGenerator());
        sqlGeneratorMap.put(INSERT_WITHOUT_ID_SQL_NAME, new InsertSqlGenerator(false));
        sqlGeneratorMap.put(DELETE_SQL_NAME, new DeleteSqlGenerator());
        sqlGeneratorMap.put(UPDATE_SQL_NAME, new UpdateSqlGenerator());
        sqlGeneratorMap.put(GET_ALL_SQL_NAME, new GetAllSqlGenerator());
    }

    public SqlCommand getInsertSql(Object bean) {
        BeanMeta beanMeta = beanMetaManager.getMeta(bean.getClass());
        Object idValue = BeanValueUtils.getIdValue(beanMeta, bean);
        String sql;
        List<Object> values;
        if (null != idValue) {
            sql = getSql(beanMeta, INSERT_SQL_NAME);
            values = new LinkedList<Object>();
            values.add(idValue);
            values.addAll(BeanValueUtils.getValues(beanMeta, bean));
        } else {
            sql = getSql(beanMeta, INSERT_WITHOUT_ID_SQL_NAME);
            values = BeanValueUtils.getValues(beanMeta, bean);
        }
        SqlCommand command = new SqlCommand();
        command.setSql(sql);
        command.setValues(values);

        return command;
    }

    public SqlCommand getUpdateSql(Object bean) {
        BeanMeta beanMeta = beanMetaManager.getMeta(bean.getClass());

        Object idValue = BeanValueUtils.getIdValue(beanMeta, bean);
        if (idValue == null) {
            throw new IllegalArgumentException("bean id must not be null!");
        }
        List<Object> values = BeanValueUtils.getValues(beanMeta, bean);
        values.add(idValue);

        SqlCommand command = new SqlCommand();
        String sql = getSql(beanMeta, UPDATE_SQL_NAME);
        command.setSql(sql);
        command.setValues(values);

        return command;
    }

    public SqlCommand getDeleteSql(Object bean) {
        BeanMeta beanMeta = beanMetaManager.getMeta(bean.getClass());
        Object idValue = BeanValueUtils.getIdValue(beanMeta, bean);
        return getDeleteSql(bean.getClass(), idValue);
    }

    public SqlCommand getDeleteSql(Class beanClass, Object idValue) {
        if (idValue == null) {
            throw new IllegalArgumentException("bean id must not be null!");
        }
        BeanMeta beanMeta = beanMetaManager.getMeta(beanClass);
        SqlCommand command = new SqlCommand();
        String sql = getSql(beanMeta, DELETE_SQL_NAME);
        command.setSql(sql);
        List value = new ArrayList(1);
        value.add(idValue);
        command.setValues(value);
        return command;
    }

    public String getGetAllSql(Class beanClass) {
        BeanMeta beanMeta = this.beanMetaManager.getMeta(beanClass);
        return getSql(beanMeta, GET_ALL_SQL_NAME);
    }

    private String getSql(BeanMeta beanMeta, String sqlType) {
        Map<SqlGenerator, String> sqlCache = getSqlCache(beanMeta);
        String sql = sqlCache.get(sqlType);
        if (null == sql) {
            synchronized (sqlCache) {
                sql = sqlCache.get(sqlType);
                if (null == sql) {
                    SqlGenerator sqlGenerator = sqlGeneratorMap.get(sqlType);
                    sql = sqlGenerator.generate(beanMeta);
                    sqlCache.put(sqlGenerator, sql);
                }
            }
        }
        return sql;
    }

    private Map<SqlGenerator, String> getSqlCache(BeanMeta beanMeta) {
        Map<SqlGenerator, String> sqlCache = this.sqlCaches.get(beanMeta);
        if (null == sqlCache) {
            synchronized (sqlCaches) {
                sqlCache = this.sqlCaches.get(beanMeta);
                if (null == sqlCache) {
                    sqlCache = createSqlCache();
                    this.sqlCaches.put(beanMeta, sqlCache);
                }
            }
        }
        return sqlCache;
    }

    private Map<SqlGenerator, String> createSqlCache() {
        return new ConcurrentHashMap<SqlGenerator, String>();
    }
}
