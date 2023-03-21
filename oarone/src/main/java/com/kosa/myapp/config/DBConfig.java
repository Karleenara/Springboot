package com.kosa.myapp.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


// Myapp2Application : Main 함수를 포함한 클래스 자동 생성
// configuration 이 있는 클래스들의 객체를 만들어서 필요한 위치에서 함수들 호출
@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfig {
	
	@Bean 	// 객체만들기
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();	// 객체 만들어서 던지기
	}
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}

}
