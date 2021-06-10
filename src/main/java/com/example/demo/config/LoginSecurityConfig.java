package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
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
//		http.authorizeRequests()	 // 対象リクエストの指定
//		    .antMatchers("/loginFrom").permitAll()//ログインフォームは許可
//		    .antMatchers("/h2-console/**").permitAll()
////		    .antMatchers("/emp/**").permitAll()
//		    .antMatchers("/login").permitAll()//test用(ユーザ登録)※終わったら消す
////		    .antMatchers("/employees").permitAll()//test用(ユーザ登録後の遷移画面）※終わったら消す
////		    .antMatchers("/user/create").permitAll()//test用機能※終わったら消す
//		    .anyRequest().authenticated();// それ以外は全て認証無しの場合アクセス不許可
//		http.formLogin() // フォーム認証の設定を行う
//		    .loginProcessingUrl("/login")//ログイン処理をするURL（おそらくPOST）
//		    .loginPage("/login").permitAll()//ログイン画面のURL
//		    .failureUrl("/login?error")//認証失敗時のURL
//		    .successForwardUrl("/genres")//認証成功時のURL
//		    .usernameParameter("id")//ユーザのパラメータ名
//		    .passwordParameter("password");//パスワードのパラメータ名
//		http.logout()
//		    .logoutUrl("/logout**")//ログアウト時のURL（今回は未実装）
//		    .logoutSuccessUrl("/login");//ログアウト成功時のURL
	}
}
