package org.auto.jdbc.orm.sql;

import org.auto.jdbc.orm.meta.BeanMeta;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-11
 * Time: ÏÂÎç12:24
 * To change this template use File | Settings | File Templates.
 */
public class InsertSqlGenerator implements SqlGenerator {

    private boolean haveId = true;

    public InsertSqlGenerator() {
        super();
    }

    public InsertSqlGenerator(boolean haveId) {
        super();
        this.haveId = haveId;
    }

    public String generate(BeanMeta beanMeta) {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        String insertColumn;
        String placeholder;
        if (haveId) {
            insertColumn = SqlGeneratorHelper.getAllInsertColumn(beanMeta);
            placeholder = SqlGeneratorHelper.getAllColumnPlaceholder(beanMeta);
        } else {
            insertColumn = SqlGeneratorHelper.getInsertColumn(beanMeta);
            placeholder = SqlGeneratorHelper.getColumnPlaceholder(beanMeta);
        }
        sql.append(beanMeta.getTableName());
        sql.append(" (");
        sql.append(insertColumn);
        sql.append(") VALUES (");
        sql.append(placeholder);
        sql.append(")");
        return sql.toString();
    }
}
