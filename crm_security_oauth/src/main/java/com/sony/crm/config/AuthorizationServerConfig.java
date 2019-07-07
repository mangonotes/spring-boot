package com.sony.crm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.sony.crm.exception.CustomOAuth2Exception;
import com.sony.crm.ui.dto.ResponseStatus;
@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	private static final String CLIENT_ID = "client";
    static final String CLIENT_SECRET = "$2a$10$s7rR9qxaUnOJaE3J6ZSICupQxm.xTJhvScmXV.ylsI3AIY5OMXp.q";
    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String SCOPE_READ = "read";
    private static final String SCOPE_WRITE = "write";
    private static final String TRUST = "trust";
    private static final int SECONDS_180 = 180;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private UserDetailsService jdbcUserDetailsService;
    @Autowired 
    private DataSource dataSource;
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
   

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(CLIENT_ID)
                .secret(CLIENT_SECRET)
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN)
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .autoApprove(true)
                .accessTokenValiditySeconds(SECONDS_180)
                .refreshTokenValiditySeconds(SECONDS_180);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    	endpoints.authenticationManager(authManager);
    	endpoints.userDetailsService(jdbcUserDetailsService);
    	endpoints.tokenStore(tokenStore());
    	endpoints.exceptionTranslator(exception -> {
    		if (exception instanceof OAuth2Exception) {
                OAuth2Exception oAuth2Exception = (OAuth2Exception) exception;
                ResponseStatus status = new ResponseStatus(oAuth2Exception.getMessage(),oAuth2Exception.getHttpErrorCode());
                return ResponseEntity
                        .status(oAuth2Exception.getHttpErrorCode())
                        .body(new CustomOAuth2Exception("code not valid", status));
            } else {
                throw exception;
            }
    	});
    }
}
