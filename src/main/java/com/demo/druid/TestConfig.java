//package com.demo.druid;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Component;
//
//
//import javax.sql.DataSource;
//
///**
// * @Author guijun
// * @Date 2021/2/3 21:23
// * MapperScan注解用于绑定扫描的包和指定的数据源,且指定目录下的mapper无需加注解处理
// **/
//
//@Component
//@MapperScan(basePackages = "com.demo.mapper.test", sqlSessionFactoryRef = "testSqlSessionFactory")
//public class TestConfig extends BaseProperty {
//
//    @Bean(name = "testDataSource")
//    public DataSource createDataSource() {
//        return createDataSource(urlTest);
//    }
//
//    @Bean(name = "testTransactionManager")
//    public DataSourceTransactionManager testTransactionManager() {
//        return new DataSourceTransactionManager(createDataSource());
//    }
//
//    @Bean(name = "testSqlSessionFactory")
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("testDataSource") DataSource testDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(testDataSource);
//        String mapperLocation = "classpath:mapper/test/*.xml";
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(mapperLocation));
//        return sessionFactory.getObject();
//    }
//}
