package org.auto.jdbc.orm;

import org.auto.jdbc.orm.meta.BeanMeta;
import org.auto.jdbc.orm.meta.BeanMetaManager;
import org.auto.jdbc.orm.meta.PropertyMeta;
import org.auto.jdbc.orm.util.*;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ÉÏÎç10:33
 * To change this template use File | Settings | File Templates.
 */
class DefaultResultDeserializer implements ResultDeserializer {

    private BeanMetaManager beanMetaManager;
    private ResultSetValueGetterManager valueGetterManager;

    public DefaultResultDeserializer(BeanMetaManager beanMetaManager, ResultSetValueGetterManager valueGetterManager) {
        this.beanMetaManager = beanMetaManager;
        this.valueGetterManager = valueGetterManager;
    }

    <T> List<T> toBean(ResultSet resultSet, BeanMeta beanMeta) throws SQLException {
        ResultSetMetaData resultSetMeta = resultSet.getMetaData();
        int count = resultSetMeta.getColumnCount();
        Method[] writeMethods = new Method[count];
        ResultSetValueGetter[] getters = new ResultSetValueGetter[count];

        for (int i = 1; i <= count; i++) {
            String columnLabel = resultSetMeta.getColumnLabel(i);
            PropertyMeta propertyMeta = beanMeta.getPropertyMeta(columnLabel);
            writeMethods[i] = propertyMeta.getWirteMethod();
            Class type = propertyMeta.getType();
            ResultSetValueGetter getter = valueGetterManager.getValueGetter(type);
            if (null == getter) {
                getters[i] = valueGetterManager.getDefaultValueGetterValueGetter();
            }
            getters[i] = getter;
        }
        Class beanClass = beanMeta.getBeanClass();
        List result = new ArrayList();
        while (resultSet.next()) {
            Object bean = newInstance(beanClass);
            for (int i = 1; i <= count; i++) {
                Method writeMethod = writeMethods[i];
                ResultSetValueGetter getter = getters[i];
                Object value = getter.getValue(resultSet, i);
                write(writeMethod, bean, value);
            }
            result.add(bean);
        }
        return result;
    }

    public <T> List<T> toBean(ResultSet resultSet, Class<T> beanClass) {
        BeanMeta beanMeta = beanMetaManager.getMeta(beanClass);
        try {
            return toBean(resultSet, beanMeta);
        } catch (SQLException e) {
            throw new IllegalStateException("SQLException", e);
        }
    }

    private static Object newInstance(Class beanClass) {
        try {
            return beanClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Cannot newInstance " + beanClass.getName() + ".",
                    e);
        }
    }

    private static void write(Method method, Object bean, Object value) {
        try {
            method.invoke(bean, value);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Cannot invoke " + method.getDeclaringClass().getName() + "."
                            + method.getName() + ".", e);
        }
    }

}
