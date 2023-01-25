package org.auto.jdbc.orm.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: обнГ12:26
 * To change this template use File | Settings | File Templates.
 */
public interface ResultSetValueGetter<T> {

    T getValue(ResultSet resultSet, int columnIndex) throws SQLException;

}
