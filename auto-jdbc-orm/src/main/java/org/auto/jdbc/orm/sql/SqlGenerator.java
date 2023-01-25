package org.auto.jdbc.orm.sql;

import org.auto.jdbc.orm.meta.BeanMeta;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-11
 * Time: обнГ12:07
 * To change this template use File | Settings | File Templates.
 */
public interface SqlGenerator {

    String generate(BeanMeta beanMeta);

}
