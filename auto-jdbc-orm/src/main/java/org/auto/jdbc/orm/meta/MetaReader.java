package org.auto.jdbc.orm.meta;

import org.auto.jdbc.orm.nameconverter.EqualsNameConverter;
import org.auto.jdbc.orm.nameconverter.NameConverter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-8
 * Time: ÏÂÎç7:26
 * To change this template use File | Settings | File Templates.
 */
public class MetaReader {

    private NameConverter nameConverter = new EqualsNameConverter();

    public static String ID_NAME_DEFAULT = "id";

    private String idPropertyName = ID_NAME_DEFAULT;

    public BeanMeta read(Class beanClass) {
        BeanMeta beanMeta = new BeanMeta();
        beanMeta.setBeanClass(beanClass);
        beanMeta.setTableName(getTableName(beanClass));
        readPropertys(beanMeta, beanClass);
        return beanMeta;
    }

    private String getMappedName(String name) {
        return nameConverter.convert(name);
    }

    private String getTableName(Class beanClass) {
        return getMappedName(beanClass.getSimpleName());
    }

    public String getIdName() {
        return idPropertyName;
    }

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

    private void readPropertys(BeanMeta beanMeta, Class beanClass) {

        PropertyDescriptor[] propertyDescriptors = getPropertyDescriptors(beanClass);

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

            String name = propertyDescriptor.getName();
            if ("class".equals(name)) {
                continue;
            }

            String columnName = getMappedName(name);

            Method writeMethod = propertyDescriptor.getWriteMethod();
            Method readMethod = propertyDescriptor.getReadMethod();
            Class type = propertyDescriptor.getPropertyType();

            PropertyMeta propertyMeta = new PropertyMeta();
            propertyMeta.setName(name);
            propertyMeta.setColumnName(columnName);
            propertyMeta.setReadMethod(readMethod);
            propertyMeta.setWirteMethod(writeMethod);
            propertyMeta.setType(type);

            if (getIdName().equals(name)) {
                beanMeta.setId(propertyMeta);
            } else {
                beanMeta.addPropertyMeta(propertyMeta);
            }

        }
    }

    public NameConverter getNameConverter() {
        return nameConverter;
    }

    public void setNameConverter(NameConverter nameConverter) {
        this.nameConverter = nameConverter;
    }
}
