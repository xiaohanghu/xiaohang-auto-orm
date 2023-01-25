package org.auto.jdbc.orm;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-8
 * Time: 下午7:26
 * To change this template use File | Settings | File Templates.
 */
public interface BeanSqlGenerator {

    /**
     * 获取插入sql
     *
     * @param bean
     */
    public SqlCommand getInsertSql(Object bean);

    /**
     * 获取更新sql
     *
     * @param bean bean的id值不容许为空
     */
    public SqlCommand getUpdateSql(Object bean);

    /**
     * 获取删除sql
     *
     * @param beanClass
     * @param idValue
     */
    public SqlCommand getDeleteSql(Class beanClass, Object idValue);

    /**
     * 获取查询所有sql
     *
     * @param beanClass
     */
    public String getGetAllSql(Class beanClass);

}
