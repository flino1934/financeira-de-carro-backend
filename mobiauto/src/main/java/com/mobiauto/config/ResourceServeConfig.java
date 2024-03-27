package com.mobiauto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServeConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private JwtTokenStore tokenStore;

    private static final String[] PUBLIC = {"/oauth/token","/h2-console/**"};

    @Autowired
    private Environment env;

    private static final String[] ADMIN = {"/usuarios/**"};
    private static final String[] PROPRIETARIO_GERENTE_ADMIN = {"/usuarios/**", "/revendas/**","/veiculos/**"};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        resources.tokenStore(tokenStore);

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //Configuração para liberar o H2
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, PROPRIETARIO_GERENTE_ADMIN).permitAll()
                .antMatchers(PROPRIETARIO_GERENTE_ADMIN).hasAnyRole("GERENTE", "PROPRIETARIO", "ADMIN")
                .anyRequest().authenticated();

    }
}
