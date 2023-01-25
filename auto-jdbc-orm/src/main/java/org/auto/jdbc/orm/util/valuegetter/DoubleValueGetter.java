package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ÏÂÎç8:44
 * To change this template use File | Settings | File Templates.
 */
public class DoubleValueGetter implements ResultSetValueGetter<Double> {

    @Override
    public Double getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        Object value = resultSet.getObject(columnIndex);
        if (null == value) {
            return null;
        }
        return Double.valueOf(resultSet.getDouble(columnIndex));
    }

}
