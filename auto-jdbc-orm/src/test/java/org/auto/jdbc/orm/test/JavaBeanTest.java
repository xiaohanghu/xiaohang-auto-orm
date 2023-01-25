package org.auto.jdbc.orm.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ÉÏÎç11:36
 * To change this template use File | Settings | File Templates.
 */
public class JavaBeanTest {
    private static PropertyDescriptor[] getPropertyDescriptors(Class beanClass) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(beanClass);
        } catch (IntrospectionException e) {
            return (new PropertyDescriptor[0]);
        }
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        return propertyDescriptors;
    }

    public static void main(String[] args) {
        Class beanClass = Rate.class;
        PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(beanClass);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
//            System.out.println(propertyDescriptor.getPropertyEditorClass());
            Class type = propertyDescriptor.getPropertyType();
            type = int.class;
            System.out.println(type.getName());
        }
    }
}
