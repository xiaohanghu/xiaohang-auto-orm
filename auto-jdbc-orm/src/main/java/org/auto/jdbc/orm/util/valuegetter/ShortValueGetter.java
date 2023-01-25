package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ����8:38
 * To change this template use File | Settings | File Templates.
 */
public class ShortValueGetter implements ResultSetValueGetter<Short> {

    @Override
    public Short getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        Object value = resultSet.getObject(columnIndex);
        if (null == value) {
            return null;
        }
        return Short.valueOf(resultSet.getShort(columnIndex));
    }

}
