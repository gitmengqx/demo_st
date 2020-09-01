package com.example.st.demo.social;

import com.example.st.demo.properties.SggSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author mqx
 * @date 2020-8-25 15:42:25
 */
@Configuration
@EnableSocial
public class SocialCofig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SggSecurityProperties securityProperties;

    @Value("${sgg.security.social.filterProcessesUrl}")
    private String filterProcessesUrl;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        // 第一个参数数据源，第二个参数获取到当前的连接工厂，第三个参数 对数据进行加密，解密
        return new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator, Encryptors.noOpText());
    }

    @Bean
    public SpringSocialConfigurer socialConfigurer(){
        // 获取url
        // String filterProcessesUrl = securityProperties.getSggSocialProperties().getFilterProcessesUrl();
        // String filterProcessesUrl = filterProcessesUrl;
        SggSpringSocialConfigurer sggSpringSocialConfigurer = new SggSpringSocialConfigurer(filterProcessesUrl);
        return sggSpringSocialConfigurer;
//        return new SpringSocialConfigurer();
    }
}
