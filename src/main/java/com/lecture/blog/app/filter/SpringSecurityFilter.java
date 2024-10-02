package com.lecture.blog.app.filter;
import java.util.List;
import com.lecture.blog.app.utils.JwtTokenUtil;
import com.lecture.blog.biz.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SpringSecurityFilter {

    private final LoginFilter loginFilter;

    public SpringSecurityFilter(LoginFilter loginFilter) {
        this.loginFilter = loginFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);

        //경로별 권한 추가(인가)
        http
                .authorizeHttpRequests((auth) -> auth
                                //.requestMatchers("/", "/login").permitAll()
//                        .requestMatchers("/login").permitAll()
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .requestMatchers("my/**").hasAnyRole("ADMIN","USER")
//                        .anyRequest().authenticated()
                                .requestMatchers("/api/user/info").hasAnyAuthority("ADMIN","USER")
                                .requestMatchers("/api/user/delete").hasAnyAuthority("ADMIN","USER")
                                .anyRequest().permitAll()

                );

//        //로그인 페이지로 이동시키기
//        http
//                .formLogin((auth) -> auth.loginPage("/login") //리다이렉션할 경로 설정
//                        .loginProcessingUrl("/loginProc") //로그인데이터를 넘길 경로 (html에서 post하는 경로)
//                        .successHandler((request, response, authentication) -> {
//                            // 로그인 성공 시 처리할 로직
//                            response.sendRedirect("/"); // 성공 후 리다이렉트할 경로
//                        })
//                        .permitAll()
//                );


        //개발용 csrf 설정 해제
        http
                .csrf((auth) -> auth.disable());
        // cors and csrf set
        http.cors(c -> c.configurationSource(corsConfigurationSource()));

        return http.build();
    }

    /**
     * cors 설정
     * */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://192.168.0.174:3000", "http://localhost:3000")); // 허용할 출처
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 허용할 메서드
        configuration.setAllowedHeaders(List.of("*")); // 허용할 헤더
        configuration.setAllowCredentials(true); // 자격 증명 허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 경로에 CORS 설정
        return source;
    }
}
