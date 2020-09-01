package com.example.st.demo.social.qq.config;

import com.example.st.demo.properties.QQProperties;
import com.example.st.demo.properties.SggSecurityProperties;
import com.example.st.demo.social.configutils.SocialAutoConfigurerAdapter;
import com.example.st.demo.social.qq.connection.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * @author mqx
 * @date 2020-8-25 20:26:03
 */
@Configuration
//@ConditionalOnProperty(prefix = "sgg.security.social.qq",name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Value("${sgg.security.social.qq.app-id}")
    private String appId;

    @Value("${sgg.security.social.qq.app-secret}")
    private String appSecret;

    @Value("${sgg.security.social.qq.providerId}")
    private String providerId;

    @Autowired
    private SggSecurityProperties sggSecurityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqProperties = sggSecurityProperties.getSggSocialProperties().getQq();
        qqProperties.setAppId(appId);
        qqProperties.setAppSecret(appSecret);
        qqProperties.setProviderId(providerId);
        return new QQConnectionFactory(qqProperties.getProviderId(),qqProperties.getAppId(),qqProperties.getAppSecret());
    }
}
