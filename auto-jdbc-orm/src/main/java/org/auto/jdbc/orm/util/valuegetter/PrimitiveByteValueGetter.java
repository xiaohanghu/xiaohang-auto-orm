package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ????8:35
 * To change this template use File | Settings | File Templates.
 */
public class PrimitiveByteValueGetter implements ResultSetValueGetter<Byte> {

    @Override
    public Byte getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getByte(columnIndex);
    }

}