
只要你的bean符合：类名=表名，属性名=列名。auto-orm 就能帮你自动生成sql: 
``` 
public interface BeanSqlGenerator {

/**
* 获取插入sql
*
* @param bean
  */
  public SqlCommand getInsertSql(Object bean);

/**
* 获取更新sql
*
* @param bean bean的id值不容许为空
  */
  public SqlCommand getUpdateSql(Object bean);

/**
* 获取删除sql
*
* @param beanClass
* @param idValue
  */
  public SqlCommand getDeleteSql(Class beanClass, Object idValue);

/**
* 获取查询所有sql
*
* @param beanClass
  */
  public String getGetAllSql(Class beanClass);
  }
```

auto-orm也可以将"驼峰命"名映射到"下划线"命名.