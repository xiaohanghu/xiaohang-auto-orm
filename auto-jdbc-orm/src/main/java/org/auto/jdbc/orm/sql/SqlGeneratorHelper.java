package org.auto.jdbc.orm.sql;

import org.auto.jdbc.orm.meta.BeanMeta;
import org.auto.jdbc.orm.meta.PropertyMeta;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-11
 * Time: 上午10:56
 * To change this template use File | Settings | File Templates.
 */
public class SqlGeneratorHelper {
    /**
     * 根据列数(包含id)，拼接占位符
     *
     * @return like: "?,?"
     */
    public static String getAllColumnPlaceholder(BeanMeta beanMeta) {
        List<PropertyMeta> propertyMetas = beanMeta.getPropertyMetas();
        int size = propertyMetas.size();
        size++;
        return getPlaceholder(size);
    }


    /**
     * 根据列数(不包含id)，拼接占位符
     *
     * @return like: "?,?"
     */
    public static String getColumnPlaceholder(BeanMeta beanMeta) {
        List<PropertyMeta> propertyMetas = beanMeta.getPropertyMetas();
        int size = propertyMetas.size();
        return getPlaceholder(size);
    }

    /**
     * 拼接占位符
     *
     * @param size
     * @return like: "?,?"
     */
    public static String getPlaceholder(int size) {
        StringBuilder result = new StringBuilder();
        if (size == 0) {
            return "";
        }
        result.append("?");
        for (int i = 1; i < size; i++) {
            result.append(",?");
        }
        return result.toString();
    }

    /**
     * @return like: "name,age"
     */
    public static String getInsertColumn(BeanMeta beanMeta) {
        StringBuilder result = new StringBuilder();
        List<PropertyMeta> propertyMetas = beanMeta.getPropertyMetas();
        Iterator<PropertyMeta> iterator = propertyMetas.iterator();
        if (iterator.hasNext()) {
            String columnName = iterator.next().getColumnName();
            result.append(columnName);
        }
        while (iterator.hasNext()) {
            String columnName = iterator.next().getColumnName();
            result.append(",");
            result.append(columnName);
        }
        return result.toString();
    }

    /**
     * contains id column
     *
     * @return like: "name,age"
     */
    public static String getAllInsertColumn(BeanMeta beanMeta) {
        StringBuilder result = new StringBuilder();
        List<PropertyMeta> propertyMetas = beanMeta.getPropertyMetas();

        PropertyMeta idProperty = beanMeta.getId();
        String idColumnName = idProperty.getColumnName();
        result.append(idColumnName);

        Iterator<PropertyMeta> iterator = propertyMetas.iterator();
        while (iterator.hasNext()) {
            String columnName = iterator.next().getColumnName();
            result.append(",");
            result.append(columnName);
        }
        return result.toString();
    }


    /**
     * @return like: "name=?,age=?"
     */
    public static String getUpdateColumn(BeanMeta beanMeta) {
        StringBuilder result = new StringBuilder();
        List<PropertyMeta> propertyMetas = beanMeta.getPropertyMetas();
        Iterator<PropertyMeta> iterator = propertyMetas.iterator();
        if (iterator.hasNext()) {
            String columnName = iterator.next().getColumnName();
            result.append(columnName);
            result.append("=?");
        }
        while (iterator.hasNext()) {
            String columnName = iterator.next().getColumnName();
            result.append(",");
            result.append(columnName);
            result.append("=?");
        }
        return result.toString();
    }
}
