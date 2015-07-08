# HibernateRelationMapping

#第一步
将Jar包build path

#第二步
在测试某一种关联映射时，需要在hibernate.cfg.xml文件中，打开相应的mapping的注释。

比如我准备测试sing_n_1，那么我需要将下面代码的注释取消。
```xml
<mapping resource="com/lihui/hibernate/single_n_1/Order.hbm.xml"/>
<mapping resource="com/lihui/hibernate/single_n_1/Customer.hbm.xml"/>
```
然后就可以利用相应包中的Junittest类进行测试。
