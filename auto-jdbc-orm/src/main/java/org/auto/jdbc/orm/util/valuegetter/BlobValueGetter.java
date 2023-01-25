package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: обнГ8:58
 * To change this template use File | Settings | File Templates.
 */
public class BlobValueGetter implements ResultSetValueGetter<Blob> {

    @Override
    public Blob getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        return resultSet.getBlob(columnIndex);
    }

}