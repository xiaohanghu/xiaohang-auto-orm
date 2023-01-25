package org.auto.jdbc.orm;

import org.auto.jdbc.orm.meta.BeanMeta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-19
 * Time: ионГ10:54
 * To change this template use File | Settings | File Templates.
 */
public interface ResultDeserializer {

    <T> List<T> toBean(ResultSet resultSet, Class<T> beanClass);

}
