package com.example.st.demo.social.qq.connection;

import com.example.st.demo.social.qq.api.QQ;
import com.example.st.demo.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author mqx
 * @date 2020-8-25 14:58:38
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {
    // 声明一个appId
    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId,String appSecret) {
        // 使用OAuth2Template 创建 OAuth2Operations。
        // 第一个参数是客户Id [appId] ,第二个参数是客户密钥[pwd]，第三个参数认证的url，第四个参数获取token url
        super(new OAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }
}
