package org.auto.jdbc.orm.test;

import org.auto.jdbc.orm.AutoOrmFactory;
import org.auto.jdbc.orm.BeanSqlGenerator;
import org.auto.jdbc.orm.SqlCommand;
import org.auto.jdbc.orm.nameconverter.CamelToUnderline;

import java.util.Arrays;


public class JdbcTest {

    public static void main(String[] args) {

        AutoOrmFactory factory = new AutoOrmFactory(new CamelToUnderline());
        BeanSqlGenerator beanSqlGenerator = factory.getBeanSqlGenerator();
        Rate rate = new Rate();
        rate.setServiceId("4");
        rate.setId(2l);
        rate.setCount(1);
        rate.setLevel(3);
        SqlCommand insertSql = beanSqlGenerator.getInsertSql(rate);
        SqlCommand updateSql = beanSqlGenerator.getUpdateSql(rate);
        System.out.println(insertSql.getSql());
        System.out.println(updateSql.getSql());
        System.out.println(Arrays.asList(updateSql.getValues()));

    }

}

