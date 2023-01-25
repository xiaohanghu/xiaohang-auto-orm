package org.auto.jdbc.orm.meta;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-10
 * Time: ÏÂÎç7:14
 * To change this template use File | Settings | File Templates.
 */
public class PropertyMeta {

    private String name;
    private String columnName;
    private Method readMethod;
    private Method wirteMethod;
    private Class type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Method getWirteMethod() {
        return wirteMethod;
    }

    public void setWirteMethod(Method wirteMethod) {
        this.wirteMethod = wirteMethod;
    }

    public Method getReadMethod() {
        return readMethod;
    }

    public void setReadMethod(Method readMethod) {
        this.readMethod = readMethod;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
