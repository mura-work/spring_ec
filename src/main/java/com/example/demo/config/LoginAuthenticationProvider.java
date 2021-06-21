package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.form.LoginForm;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	LoginLogic loginLogic;
	
	 @Autowired
   PasswordEncoder passwordEncoder;

//	
//	/**
//  *
//  * @param rawPassword 平文のパスワード
//  * @return 暗号化されたパスワード
//  */
// private String passwordEncode(String rawPassword) {
//   return passwordEncoder.encode(rawPassword);
// }

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String empId = auth.getName();
		String password = auth.getCredentials().toString();
		
		if(empId.equals("") && password.equals("")) {
			throw new UsernameNotFoundException("");
		}
		
		LoginForm emp = (LoginForm) loginLogic.loadUserByUsername(empId);
		
		// ユーザを見つけられなかったら弾く
		if(emp == null) {
			throw new UsernameNotFoundException("ユーザが見つかりませんでした");
		}
		
		// パスワードが正しいかチェック
//		String encodepassword = passwordEncoder.passwordEncode(password);
		if (!passwordEncoder.matches(password, emp.getPassword())) {
			throw new UsernameNotFoundException("パスワードが違います");
		}
		
		return new UsernamePasswordAuthenticationToken(emp, password, auth.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> token) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
	}

}
