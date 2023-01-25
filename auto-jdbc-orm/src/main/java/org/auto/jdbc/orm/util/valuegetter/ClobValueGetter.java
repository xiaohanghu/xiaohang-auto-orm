package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: обнГ8:57
 * To change this template use File | Settings | File Templates.
 */
public class ClobValueGetter implements ResultSetValueGetter<Clob> {

    @Override
    public Clob getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getClob(columnIndex);
    }

}