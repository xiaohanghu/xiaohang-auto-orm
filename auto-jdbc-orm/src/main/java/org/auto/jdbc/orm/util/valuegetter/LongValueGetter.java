package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ÏÂÎç8:35
 * To change this template use File | Settings | File Templates.
 */
public class LongValueGetter implements ResultSetValueGetter<Long> {

    @Override
    public Long getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        Object value = resultSet.getObject(columnIndex);
        if (null == value) {
            return null;
        }
        return Long.valueOf(resultSet.getLong(columnIndex));
    }

}