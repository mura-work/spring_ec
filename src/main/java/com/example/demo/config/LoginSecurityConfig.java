package com.example.demo.config;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	LoginLogic userLogin;
	
	@Autowired
	LoginAuthenticationProvider authenticationProvider;
	
//	@Bean
//  public PasswordEncoder passwordEncoder() {
//			PasswordEncoderFactories.createDelegatingPasswordEncoder();
//      return new BCryptPasswordEncoder();
//  }
	
//アカウント登録時のパスワードエンコードで利用するためDI管理する。
 @Bean
 PasswordEncoder passwordEncoder() {
   return PasswordEncoderFactories.createDelegatingPasswordEncoder();
 }
	
	@Override  // 静的ファイルを弾く
  public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers(
                          "/images/**",
                          "/css/**",
                          "/javascript/**"
                          );
  }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	 // 対象リクエストの指定
		    .antMatchers("/regist").permitAll()//ログインフォームは許可
		    .antMatchers("/api/v1/**").permitAll()//ログインフォームは許可
		    .antMatchers("/h2-console/**").permitAll()
		    .antMatchers("/login").permitAll()//test用(ユーザ登録)※終わったら消す
		    .anyRequest().authenticated();// それ以外は全て認証無しの場合アクセス不許可
		http.formLogin() // フォーム認証の設定を行う
		    .loginProcessingUrl("/sign_in")//ログイン処理をするURL（おそらくPOST）
		    .loginPage("/login").permitAll()//ログイン画面のURL
		    .failureUrl("/login?error")//認証失敗時のURL
		    .successForwardUrl("/genres")//認証成功時のURL
		    .usernameParameter("id")//ユーザのパラメータ名
		    .passwordParameter("password");//パスワードのパラメータ名
		http.logout()
		    .logoutUrl("/logout**")//ログアウト時のURL（今回は未実装）
		    .logoutSuccessUrl("/login");//ログアウト成功時のURL
		http.sessionManagement().invalidSessionUrl("/timeout");
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth, HttpSession session) throws Exception {
				auth
				    .authenticationProvider(authenticationProvider)
				    .userDetailsService(userLogin);
  }
}
