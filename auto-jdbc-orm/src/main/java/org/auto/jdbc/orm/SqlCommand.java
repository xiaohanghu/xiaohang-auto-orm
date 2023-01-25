package org.auto.jdbc.orm;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-11
 * Time: ионГ10:19
 * To change this template use File | Settings | File Templates.
 */
public class SqlCommand {

    private String sql;
    private List<?> values;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<?> getValues() {
        return values;
    }

    public void setValues(List<?> values) {
        this.values = values;
    }
}
