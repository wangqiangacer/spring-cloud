package cn.itsource.springcloud;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import zipkin.storage.mysql.MySQLStorage;
import zipkin2.server.internal.EnableZipkinServer;
//import zipkin.storage.mysql.MySQLStorage;
//import zipkin2.server.internal.EnableZipkinServer;

import javax.sql.DataSource;

@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication

public class ZipkinServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceApplication.class);
    }
    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }
}
