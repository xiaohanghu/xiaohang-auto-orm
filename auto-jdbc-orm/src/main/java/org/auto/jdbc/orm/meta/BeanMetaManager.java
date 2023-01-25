package org.auto.jdbc.orm.meta;

import org.auto.jdbc.orm.nameconverter.CamelToUnderline;
import org.auto.jdbc.orm.nameconverter.NameConverter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-10
 * Time: ÏÂÎç7:20
 * To change this template use File | Settings | File Templates.
 */
public class BeanMetaManager {

    private MetaReader metaReader = new MetaReader();

    private Map<Class, BeanMeta> beanMetaCache = new ConcurrentHashMap<Class, BeanMeta>();


    public void setNameConverter(NameConverter nameConverter) {
        metaReader.setNameConverter(nameConverter);
    }

    public BeanMeta getMeta(Class clazz) {
        BeanMeta beanMeta = beanMetaCache.get(clazz);
        if (null == beanMeta) {
            synchronized (beanMetaCache) {
                beanMeta = beanMetaCache.get(clazz);
                if (null == beanMeta) {
                    beanMeta = metaReader.read(clazz);
                    beanMetaCache.put(beanMeta.getClass(), beanMeta);
                }
            }
        }
        return beanMeta;
    }
}
