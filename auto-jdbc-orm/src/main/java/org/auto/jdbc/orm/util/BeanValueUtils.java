package org.auto.jdbc.orm.util;

import org.auto.jdbc.orm.meta.BeanMeta;
import org.auto.jdbc.orm.meta.PropertyMeta;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-11
 * Time: ÏÂÎç1:43
 * To change this template use File | Settings | File Templates.
 */
public class BeanValueUtils {
    /**
     * @return values not contains id value.
     */
    public static List<Object> getValues(BeanMeta beanMeta, Object bean) {
        List<PropertyMeta> propertieMetas = beanMeta.getPropertyMetas();
        List<Object> result = new LinkedList<Object>();

        for (PropertyMeta propertyMeta : propertieMetas) {
            Method method = propertyMeta.getReadMethod();
            Object value = read(method, bean);
            result.add(value);
        }
        return result;
    }

    public static Object getIdValue(BeanMeta beanMeta, Object bean) {
        PropertyMeta propertyMeta = beanMeta.getId();
        if (null == propertyMeta)
            return null;
        Method method = propertyMeta.getReadMethod();
        return read(method, bean);
    }

    private static Object read(Method method, Object bean) {
        try {
            Object value = method.invoke(bean, null);
            return value;
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Cannot invoke " + method.getDeclaringClass().getName() + "."
                            + method.getName() + ".", e);
        }
    }

}
