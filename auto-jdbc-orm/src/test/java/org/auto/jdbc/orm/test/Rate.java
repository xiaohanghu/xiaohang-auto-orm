package org.auto.jdbc.orm.test;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-10
 * Time: ����9:27
 * To change this template use File | Settings | File Templates.
 */
public class Rate implements Serializable {

    private static final long serialVersionUID = -6927068795578429410L;
    /**
     * ����ID
     */
    private Long id;
    /**
     * ����id
     */
    private String serviceId;
    /**
     * ����
     */
    private Integer level;
    /**
     * ʱ�� ��λ:s Ϊ��������
     */
    private Integer time;
    /**
     * ���� Ϊ��������
     */
    private Integer count;

    private int intProperty;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTime() {

        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public int getIntProperty() {
        return intProperty;
    }

    public void setIntProperty(int intProperty) {
        this.intProperty = intProperty;
    }

    @Override
    public String toString() {
        return "Rate{" + "id=" + id + ", serviceId='" + serviceId + '\''
                + ", level=" + level + ", time=" + time + ", count=" + count
                + '}';
    }
}
