package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ????8:37
 * To change this template use File | Settings | File Templates.
 */
public class BooleanValueGetter implements ResultSetValueGetter<Boolean> {

    @Override
    public Boolean getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        Object value = resultSet.getObject(columnIndex);
        if (null == value) {
            return null;
        }
        return Boolean.valueOf(resultSet.getBoolean(columnIndex));
    }

}