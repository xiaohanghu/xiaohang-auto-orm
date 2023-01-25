package org.auto.jdbc.orm.util.valuegetter;

import org.auto.jdbc.orm.util.ResultSetValueGetter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ÏÂÎç8:53
 * To change this template use File | Settings | File Templates.
 */
public class CalendarValueGetter implements ResultSetValueGetter<Calendar> {

    @Override
    public Calendar getValue(ResultSet resultSet, int columnIndex) throws SQLException {
        Date date = resultSet.getDate(columnIndex);
        if (null == date) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

}