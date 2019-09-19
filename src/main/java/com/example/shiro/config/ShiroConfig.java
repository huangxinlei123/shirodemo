package com.example.shiro.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: V1.0
 * @author: xinlei
 * @className: ShiroConfig
 * @packageName: com.example.shiro.config
 * @description: Shiro 配置
 * @data: 2019-09-19 14:45
 **/
@Configuration
public class ShiroConfig {
    /**
     * 可以是自定义的Realm 也可以是Shiro提供的
     * @return
     */
    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        // 配置两个用户
        realm.setUserDefinitions("sang=123,user\n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return  realm;
    }
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/doLogin","anon");
        chainDefinition.addPathDefinition("/logout","logout");
        chainDefinition.addPathDefinition("/**","authc");
        return  chainDefinition;
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }

}
