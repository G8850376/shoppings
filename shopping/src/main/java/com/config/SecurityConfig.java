package com.config;


import com.mapper.UserMapper;
import com.pojo.Users;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserMapper userMapper;


    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()//请求不控制
                .antMatchers("/level1/**").hasRole("VIP1") //level1只能VIP1权限访问
                .antMatchers("/level2/**").hasRole("VIP2") //level2只能VIP2权限访问
                .antMatchers("/level3/**").hasRole("VIP3"); //level3只能VIP3权限访问
        //默认登陆页
//        http.formLogin();
        //自定义的登录页
        http.formLogin().usernameParameter("user")//user和pwd对应页面表单的name
                .passwordParameter("pwd")
                .loginPage("/userlogin");

        //注销
        http.logout().logoutSuccessUrl("/");

        //记住我
        http.rememberMe().rememberMeParameter("remeber");
    }

    //定义认证规则  用户是写死的，实际开发中，用户数据是从数据库获取的。。
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        List<Users> name = userMapper.getUser();

        //遍历集合下标 取数据库后注册的姓名和密码 校验显示页面


        IntStream.range(2,name.size()).forEach(i->{
            try {
                auth.inMemoryAuthentication()
                        .passwordEncoder(new BCryptPasswordEncoder())
                        .withUser(name.get(0).getName()).password(new BCryptPasswordEncoder().encode(name.get(0).getPassword().toString())).roles("VIP1","VIP2")
                        .and()
                        .withUser(name.get(1).getName()).password(new BCryptPasswordEncoder().encode(name.get(1).getPassword().toString())).roles("VIP2","VIP3")
                        .and()
                        .withUser(name.get(i).getName()).password(new BCryptPasswordEncoder().encode(name.get(i).getPassword().toString())).roles("VIP1","VIP3");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //从数据库获取集合2到最后的下标 ？？？
            System.out.println(name.get(i));


        });
    }



}
