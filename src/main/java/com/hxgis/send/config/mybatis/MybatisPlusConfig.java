package com.hxgis.send.config.mybatis;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hxgis.send.mapper*")
public class MybatisPlusConfig {

    /**
     * 分页
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        // 开启 PageHelper 的支持
        page.setLocalPage(true);
        return page;
    }

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
//    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
//        performanceInterceptor.setMaxTime(1000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * SQL执行效率插件
     */
//    @Bean
//    @Profile({"dev","qa"})// 设置 dev test 环境开启
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        performanceInterceptor.setMaxTime(3000);
//        performanceInterceptor.setFormat(true);
//        return performanceInterceptor;
//    }

//    @Bean(name = "yth")
//    @ConfigurationProperties(prefix = "spring.datasource.druid.yth" )
//    public DataSource yth () {
//        return DruidDataSourceBuilder.create().build();
//    }

//    @Bean(name = "product")
//    @ConfigurationProperties(prefix = "spring.datasource.druid.product" )
//    public DataSource product () {
//        return DruidDataSourceBuilder.create().build();
//    }

//    /**
//     * 动态数据源配置
//     * @return
//     */
//    @Bean
//    @Primary
//    public DataSource multipleDataSource(@Qualifier("yth") DataSource yth) {
//        MultipleDataSource multipleDataSource = new MultipleDataSource();
//        Map< Object, Object > targetDataSources = new HashMap<>();
//
//
//        targetDataSources.put(DataSourceEnum.YTH.getValue(), yth);
//
////        targetDataSources.put(DataSourceEnum.PRODUCT.getValue(), product);
//        //添加数据源
//        multipleDataSource.setTargetDataSources(targetDataSources);
//        //设置默认数据源
//        multipleDataSource.setDefaultTargetDataSource(yth);
//        return multipleDataSource;
//    }
//
//
//    @Bean("sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(multipleDataSource(yth()));
//        //sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*/*Mapper.xml"));
//
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        //configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setCacheEnabled(false);
//        sqlSessionFactory.setConfiguration(configuration);
//        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
//                paginationInterceptor() //添加分页功能
//        });
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
//                getResources("classpath*:mapper/*.xml"));
//        //sqlSessionFactory.setGlobalConfig(globalConfiguration());
//        return sqlSessionFactory.getObject();
//    }


}
