package org.djh.mall;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author alex1024duan
 */
@Configuration
public class ApplicationConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.dev")
    public DataSource devDataSource(){
        return new DruidDataSource();
    }

}
