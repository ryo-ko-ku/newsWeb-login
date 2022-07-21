package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//Enteｒの場合のみコントローラクラスに通す処理
		http
		.authorizeRequests()
		.antMatchers("/Enter").permitAll()
		.anyRequest().authenticated();
		
		//formでの認証を有効にする
		http
		.formLogin()
		//form画面から認証
		.loginProcessingUrl("/POST")
		//login画面のパス
		.loginPage("/Enter")
		//認証失敗時の画面のパス
		.failureUrl("/Enter?error")
		//ログイン成功時のパス
		.defaultSuccessUrl("https://ryo-ko-ku.github.io/newsWeb.ver1.00/")
		//ログイン画面でのIDとパスワードの値
		.usernameParameter("ID").passwordParameter("PASS")
		.and();
		
		//ログアウト時の設定
		http
		.logout().logoutSuccessUrl("/Enter");
	}
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/webjars/**","/css/**");
	}
	
	@Autowired
	protected void configureGrobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user").password("{noop}9213").roles("USER").and()
		.withUser("admin").password("{noop}9213").roles("USER","ADMIN").and();
	}
}


