package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Jdbc配置
 * @author RanJi
 *
 */

@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
	@Value("${jdbc.driverClass}")
    private String driver;
 
    @Value("${jdbc.url}")
    private String url;
 
    @Value("${jdbc.username}")
    private String user;
 
    @Value("${jdbc.password}")
    private String password;
    
    /**
     * Bean注解：该注解只能写在方法上，表明使用此方法创建一个对象，并且放入spring容器。
     * name属性：给当前@Bean注解方法创建的对象指定一个名称(即bean的id）。
     * @return
     */
    @Bean(name="dataSource")
    public DataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(3000);
        return dataSource;
    }
    
    @Bean(name="jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
    
    
}
