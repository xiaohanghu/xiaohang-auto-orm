package org.auto.jdbc.orm.util;

import org.auto.jdbc.orm.util.valuegetter.*;

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.NClob;
import java.sql.SQLXML;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-12
 * Time: ÏÂÎç9:34
 * To change this template use File | Settings | File Templates.
 */
public class ResultSetValueGetterManager {

    private Map<Class, ResultSetValueGetter> valurGetters = new HashMap<Class, ResultSetValueGetter>();
    private ResultSetValueGetter defaultValueGetter = new DefalutValueGetter();

    {
        valurGetters.put(byte.class, new PrimitiveByteValueGetter());
        valurGetters.put(Byte.class, new ByteValueGetter());
        valurGetters.put(byte[].class, new BytesValueGetter());
        valurGetters.put(short.class, new PrimitiveShortValueGetter());
        valurGetters.put(Short.class, new ShortValueGetter());
        valurGetters.put(int.class, new PrimitiveIntValueGetter());
        valurGetters.put(Integer.class, new IntegerValueGetter());
        valurGetters.put(long.class, new PrimitiveLongValueGetter());
        valurGetters.put(Long.class, new LongValueGetter());
        valurGetters.put(float.class, new PrimitiveFloatValueGetter());
        valurGetters.put(Float.class, new FloatValueGetter());
        valurGetters.put(double.class, new PrimitiveDoubleValueGetter());
        valurGetters.put(Double.class, new DoubleValueGetter());
        //valurGetters .put(char.class, null);
        //valurGetters .put(Character.class, null);
        valurGetters.put(boolean.class, new PrimitiveBooleanValueGetter());
        valurGetters.put(Boolean.class, new BooleanValueGetter());
        valurGetters.put(String.class, new StringValueGetter());
        valurGetters.put(BigDecimal.class, new BigDecimalValueGetter());
        valurGetters.put(java.util.Date.class, new UtilDateValueGetter());
        valurGetters.put(java.sql.Date.class, new SqlDateValueGetter());
        valurGetters.put(java.util.Calendar.class, new CalendarValueGetter());
        //valurGetters .put(Serializable.class, null);
        valurGetters.put(java.sql.Clob.class, new ClobValueGetter());
        valurGetters.put(java.sql.Blob.class, new BlobValueGetter());
        //valurGetters .put(java.lang.Class.class, null);
        //valurGetters .put(java.util.Locale.class, null);
        //valurGetters .put(java.util.TimeZone.class, null);
        valurGetters.put(java.sql.Time.class, new TimeValueGetter());
        valurGetters.put(java.sql.Timestamp.class, new TimestampValueGetter());
        //valurGetters.put(java.util.Currency.class,new CurrencyValueGetter());

        valurGetters.put(java.sql.Array.class, new ArrayValueGetter());
        valurGetters.put(InputStream.class, new InputStreamValueGetter());
        valurGetters.put(SQLXML.class, new SQLXMLValueGetter());
        valurGetters.put(URL.class, new URLValueGetter());
        valurGetters.put(NClob.class, new NClobValueGetter());
    }

    public void addValueGetter(Class type, ResultSetValueGetter getter) {
        this.valurGetters.put(type, getter);
    }

    public ResultSetValueGetter getValueGetter(Class type) {
        return valurGetters.get(type);
    }

    public ResultSetValueGetter getDefaultValueGetterValueGetter() {
        return defaultValueGetter;
    }
}
