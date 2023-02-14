package com.example.demo.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.entity.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정 활성화 시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final CustomOAuth2UserService customOAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().headers().frameOptions().disable()
		.and()// authorizeRequests url별 권한 관리 설정 시작점, antMatchers 권한 관리 대상 지정
			.authorizeRequests().antMatchers("/**").permitAll()
			.antMatchers("/api/v1/**").hasRole(Role.USER.name())
			.anyRequest().authenticated()
			.and()
			.logout().logoutSuccessUrl("/") // 로그아웃 기능에 대한 여러 설정 진입점
			.and()
				.oauth2Login()
					.userInfoEndpoint()
						.userService(customOAuth2UserService);
	}

}
