package org.auto.jdbc.orm.meta;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-8
 * Time: 下午7:26
 * To change this template use File | Settings | File Templates.
 */
public class BeanMeta {
    private String tableName;
    private Class beanClass;

    private PropertyMeta id;

    private List<PropertyMeta> propertyMetas = new LinkedList<PropertyMeta>();
    /**
     * 冗余数据结构，提搞查找效率
     */
    private Map<String, PropertyMeta> propertyMetaMap = new HashMap<String, PropertyMeta>();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyMeta getId() {
        return id;
    }

    public void setId(PropertyMeta id) {
        this.id = id;
        this.propertyMetaMap.put(id.getName(), id);
    }

    public void addPropertyMeta(PropertyMeta property) {
        this.propertyMetas.add(property);
        this.propertyMetaMap.put(property.getName(), property);
    }

    public List<PropertyMeta> getPropertyMetas() {
        return propertyMetas;
    }

    public PropertyMeta getPropertyMeta(String propertyName) {
        return this.propertyMetaMap.get(propertyName);
    }

}
