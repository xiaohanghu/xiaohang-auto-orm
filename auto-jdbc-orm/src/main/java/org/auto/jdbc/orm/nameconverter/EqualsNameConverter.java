package org.auto.jdbc.orm.nameconverter;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-10
 * Time: обнГ9:41
 * To change this template use File | Settings | File Templates.
 */
public class EqualsNameConverter implements NameConverter {
    @Override
    public String convert(String name) {
        return name;
    }
}
