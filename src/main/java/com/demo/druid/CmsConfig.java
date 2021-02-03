package com.demo.druid;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
//import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @Author guijun
 * @Date 2021/2/3 20:54
 * MapperScan（如果要使用表名映射实体使用tk）注解用于绑定扫描的包和指定的数据源,且指定目录下的mapper无需加注解处理
 **/
@Component
@MapperScan(basePackages = "com.demo.mapper.Cms", sqlSessionFactoryRef = "CmsSqlSessionFactory")
public class CmsConfig extends BaseProperty {

    @Bean(name = "CmsDataSource")
    public DataSource createDataSource() {
        return createDataSource(urlCms);
    }

    @Bean(name = "CmsTransactionManager")
    public DataSourceTransactionManager CmsTransactionManager() {
        return new DataSourceTransactionManager(createDataSource());
    }

    @Bean(name = "CmsSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("CmsDataSource") DataSource CmsDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(CmsDataSource);
        String mapperLocation = "classpath:mapper/cms/**/*.xml";
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocation));
        return sessionFactory.getObject();
    }
}
