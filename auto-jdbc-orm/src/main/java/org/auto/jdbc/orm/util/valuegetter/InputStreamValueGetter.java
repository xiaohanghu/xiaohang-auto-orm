package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.io.InputStream;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: обнГ8:50
 * To change this template use File | Settings | File Templates.
 */
public class InputStreamValueGetter implements ResultSetValueGetter<InputStream> {

    @Override
    public InputStream getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getBinaryStream(columnIndex);
    }

}