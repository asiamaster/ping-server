# ping-server
Ping服务

##ping服务应用技术说明

### 1. 项目启动类
`com.dili.Application`
### 2. 静态资源目录
js,css, image等静态状态放`resources/static`目录下，建议再建一级根目录
### 3. 模板文件目录
建议使用beetl
需要在`application.properties`中配置beetl.enable=true
模板文件存放在`resources/templates`目录下
### 4. beetl用法示例
参照:<br/>
`http://localhost:8081/beetl`<br/>
`PingController.beetl()`
### 5. 代码生成器
####5.1使用:
打开idea右边的maven projects 
双击`ping-server-web -> Plugins -> mybatis-generator -> mybatis-generator:generate`
####5.2配置
代码生成器从(mysql)数据库中读取信息，生成实体，mapper和*Mapper.xml文件
在`resources/generator-config.properties`配置数据库信息
在`resources/generator/generatorConfig.xml`配置要生成的数据库表和生成实体，mapper和*Mapper.xml文件等信息
- javaModelGenerator配置实体生成，如果有原文件则覆盖;
- sqlMapGenerator配置*Mapper.xml生成，如果有原文件则在后面append;
- javaClientGenerator配置mapper文件生成，如果有原文件则覆盖;
###6.beetl说明
beetl总配置文件:`resources/beetl.properties`
beetl全局变量:`resources/beetlSharedVars.properties`
###7.mysql使用说明
mysql支持三种查询方法
1. 所有Mapper接口(即DAO)均须继承MyMapper接口
2. MyMapper接口提供基于JPA方式的CRUD方法，无须提供***SqlMapper.xml的配置
3. Example方式查询，参考mybatis的Query by Example
4. MyBatis的Mapper接口原生查询方式，即方法名等同***SqlMapper.xml标签的id
###8.mongodb使用说明
mongo支持四种查询方法
1. 继承MongoRepository<T, ID extends Serializable>接口,该接口支持基本CRUD方法，并支持接口方法名约定查询，具体参见:http://blog.csdn.net/codeiswhat/article/details/52129782
2. 继承springboot-base项目中的BaseMongoRepository<E>类，该类提供基本CRUD方法，并提供mongoTemplate。
3. ExampleMatcher方式查询，类似于mybatis的Query by Example
4. @Query注解方式查询，在接口方法上的直接注解查询
四种查询方式参见:http://docs.spring.io/spring-data/data-mongo/docs/2.0.0.M1/reference/html/#mongodb.repositories.queries






