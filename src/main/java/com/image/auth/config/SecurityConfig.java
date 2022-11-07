/*
 * package com.image.auth.config; //package com.image.config;
 * 
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * //@Configuration //@EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.cors(); http.csrf().disable();
 * http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and
 * ().httpBasic(); }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * auth.inMemoryAuthentication().withUser("admin").password("admin").roles(
 * "USER"); }
 * 
 * @Bean public BCryptPasswordEncoder encodePWD() { return new
 * BCryptPasswordEncoder(); }
 * 
 * }
 */
