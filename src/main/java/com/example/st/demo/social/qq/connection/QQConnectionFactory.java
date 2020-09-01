package com.example.st.demo.social.qq.connection;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author mqx
 * @date 2020-8-25 15:36:50
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory {
    // 获取连接工厂
    public QQConnectionFactory(String providerId, String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
    }
}
