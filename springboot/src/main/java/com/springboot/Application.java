package com.springboot;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by mengtian on 2017/11/17
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.springboot.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Realm realm() {
        JdbcRealm realm = new JdbcRealm();
        realm.setAuthenticationQuery("select user_pwd from user where user_name = ?");
        realm.setUserRolesQuery("select role_name from user_roles A left join user_role_rel B ON A.id = B.role_id" +
                " where B.user_id = ? and A.role_status = 0");
        realm.setCachingEnabled(true);
        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

        chainDefinition.addPathDefinition("/logout", "logout");
        chainDefinition.addPathDefinition("/user/*", "authc");
        return chainDefinition;
    }

    //ModelAttribute 注解在方法上，在执行所有的controller的mappering前会先执行被ModelAttribute 注解的方法。
    //带返回值的方法，返回值会被自动添加到Model中
    @ModelAttribute(name = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }
}
