//package com.demo.druid;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Component;
////import tk.mybatis.spring.annotation.MapperScan;
//
//import javax.sql.DataSource;
//
//
///**
// * @Author guijun
// * @Date 2021/2/3 21:09
// * MapperScan注解用于绑定扫描的包和指定的数据源,且指定目录下的mapper无需加注解处理
// **/
//@Component
//@MapperScan(basePackages = "com.gj.demo.mapper.myApp", sqlSessionFactoryRef = "myAppSqlSessionFactory")
//public class MyAppConfig extends BaseProperty {
//
//
//    @Bean(name = "myAppDataSource")
//    @Primary
//    public DataSource createDataSource() {
//        return createDataSource(urlMyApp);
//    }
//
//    @Bean(name = "myAppTransactionManager")
//    @Primary
//    public DataSourceTransactionManager myAppTransactionManager() {
//        return new DataSourceTransactionManager(createDataSource());
//    }
//
//    @Bean(name = "myAppSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("myAppDataSource") DataSource myAppDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(myAppDataSource);
//        String mapperLocation = "classpath:mapper/myApp/*.xml";
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(mapperLocation));
//        return sessionFactory.getObject();
//    }
//}
