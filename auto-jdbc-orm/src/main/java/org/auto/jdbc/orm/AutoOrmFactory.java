package org.auto.jdbc.orm;

import org.auto.jdbc.orm.meta.BeanMetaManager;
import org.auto.jdbc.orm.nameconverter.NameConverter;
import org.auto.jdbc.orm.util.ResultSetValueGetterManager;

/**
 * Created by IntelliJ IDEA.
 * User: xiaohanghu
 * Date: 11-7-19
 * Time: ÉÏÎç10:23
 * To change this template use File | Settings | File Templates.
 */
public class AutoOrmFactory {

    private BeanMetaManager beanMetaManager;
    private ResultSetValueGetterManager valueGetterManager;
    private NameConverter nameConverter;
    private BeanSqlGenerator beanSqlGenerator;
    private ResultDeserializer resultDeserializer;

    public AutoOrmFactory() {
        super();
        init();
    }

    public AutoOrmFactory(NameConverter nameConverter) {
        super();
        this.nameConverter = nameConverter;
        init();
    }

    private void init() {
        beanMetaManager = new BeanMetaManager();
        if (null != nameConverter) {
            beanMetaManager.setNameConverter(nameConverter);
        }
        valueGetterManager = new ResultSetValueGetterManager();
        beanSqlGenerator = new DefaultBeanSqlGenerator(beanMetaManager);
        resultDeserializer = new DefaultResultDeserializer(beanMetaManager, valueGetterManager);
    }

    public BeanSqlGenerator getBeanSqlGenerator() {
        return beanSqlGenerator;
    }

    public ResultDeserializer getResultDeserializer() {
        return resultDeserializer;
    }
}
