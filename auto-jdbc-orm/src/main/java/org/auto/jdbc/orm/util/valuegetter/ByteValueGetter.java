package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ÏÂÎç8:37
 * To change this template use File | Settings | File Templates.
 */
public class ByteValueGetter implements ResultSetValueGetter<Byte> {

    @Override
    public Byte getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        Object value = resultSet.getObject(columnIndex);
        if (null == value) {
            return null;
        }
        return Byte.valueOf(resultSet.getByte(columnIndex));
    }

}