package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ����9:07
 * To change this template use File | Settings | File Templates.
 */
public class PrimitiveIntValueGetter implements ResultSetValueGetter<Integer> {

    @Override
    public Integer getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getInt(columnIndex);
    }

}
