package org.auto.jdbc.orm.sql;

import org.auto.jdbc.orm.meta.BeanMeta;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ионГ10:21
 * To change this template use File | Settings | File Templates.
 */
public class GetAllSqlGenerator implements SqlGenerator {

    public String generate(BeanMeta beanMeta) {
        StringBuilder sql = new StringBuilder("SELECT ");
        sql.append(SqlGeneratorHelper.getAllInsertColumn(beanMeta));
        sql.append(" FROM ");
        sql.append(beanMeta.getTableName());
        return sql.toString();
    }
}