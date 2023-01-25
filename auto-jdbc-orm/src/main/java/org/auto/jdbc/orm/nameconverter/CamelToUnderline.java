package org.auto.jdbc.orm.nameconverter;

/**
 * 驼峰命名转下划线命名
 * <p/>
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-10
 * Time: 下午6:45
 * To change this template use File | Settings | File Templates.
 */
public class CamelToUnderline implements NameConverter {

    private static String splitCamelCase(String s, String separator) {
        return s.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"), separator);
    }

    @Override
    public String convert(String name) {
        if (null == name)
            return null;
        name = splitCamelCase(name, "_");
        return name.toLowerCase();
    }
}
