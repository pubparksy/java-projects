package com.jojoldu.springboot.config.auth;

import com.jojoldu.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // build.gradle에서 추가함으로서, Spring Security 라이브러리 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 접근 못하게 막기
                .and().authorizeRequests() // URL별 권한 관리 설정 옵션 시작점. 이게 있어야 antMatchers 메소드 체이닝 가능.
                // .antMatchers = 권한 관리 대상 지정 옵션.
                // perimitAll = 전체 열람 권한, hasRole = 특정 권한 부여
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                .antMatchers("/api/vi/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() // 그 외 나머지 요청URL 이라면 전부 인증된 사용자만 허용=로그인한 사용자.
                .and().logout().logoutSuccessUrl("/") // 로그아웃 시 이동할 주소
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}