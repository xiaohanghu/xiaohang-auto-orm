package org.auto.jdbc.orm.sql;

import org.auto.jdbc.orm.meta.BeanMeta;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-11
 * Time: ÏÂÎç12:22
 * To change this template use File | Settings | File Templates.
 */
public class UpdateSqlGenerator implements SqlGenerator {

    public String generate(BeanMeta beanMeta) {
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(beanMeta.getTableName());
        sql.append(" SET ");
        sql.append(SqlGeneratorHelper.getUpdateColumn(beanMeta));
        sql.append(" WHERE ");
        sql.append(beanMeta.getId().getColumnName());
        sql.append("=?");
        return sql.toString();
    }

}
