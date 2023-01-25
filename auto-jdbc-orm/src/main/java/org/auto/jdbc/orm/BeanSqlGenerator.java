package org.auto.jdbc.orm;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-8
 * Time: ����7:26
 * To change this template use File | Settings | File Templates.
 */
public interface BeanSqlGenerator {

    /**
     * ��ȡ����sql
     *
     * @param bean
     */
    public SqlCommand getInsertSql(Object bean);

    /**
     * ��ȡ����sql
     *
     * @param bean bean��idֵ������Ϊ��
     */
    public SqlCommand getUpdateSql(Object bean);

    /**
     * ��ȡɾ��sql
     *
     * @param beanClass
     * @param idValue
     */
    public SqlCommand getDeleteSql(Class beanClass, Object idValue);

    /**
     * ��ȡ��ѯ����sql
     *
     * @param beanClass
     */
    public String getGetAllSql(Class beanClass);

}
