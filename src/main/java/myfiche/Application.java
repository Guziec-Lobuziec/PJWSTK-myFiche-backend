package myfiche;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@EnableHypermediaSupport(type = HypermediaType.HAL)
@SpringBootApplication
@ComponentScan("myfiche.*")
public class Application 
{
    public static void main( String[] args )throws IOException 
    {
    	
    	SpringApplication.run(Application.class, args);
    	
    }
    
    @Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
	    return DataSourceBuilder.create().build();
	}
    
    @Bean
    public RelProvider fileRelProvider() {
    	return new FileRelProvider();
    }
    
  //do testów
    @Bean(initMethod="start",destroyMethod="stop")
    public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
      return org.h2.tools.Server.createWebServer("-webPort", "8082");
    }
    
}