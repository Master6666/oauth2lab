package io.spring2go.authcodeserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

//授权服务器配置
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends
        AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        //这里需要从服务器里配置
        clients.inMemory()
            .withClient("clientapp")
            .secret("112233")//授权服务器注册的
            .redirectUris("http://localhost:9001/callback")
            // 授权码模式
            .authorizedGrantTypes("authorization_code")
            .scopes("read_userinfo", "read_contacts");//权限
    }

}
