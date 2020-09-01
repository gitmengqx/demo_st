package com.example.st.demo.social.qq.api;

import com.alibaba.fastjson.JSON;
import com.example.st.demo.bean.QQUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @author mqx
 * @date 2020-8-25 11:28:24
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ  {

    // 获取openId
    private static final String URL_GET_OPENID="https://graph.qq.com/oauth2.0/me?access_token=%S";

    // 第一个参数在父类会获取，所以删掉，后面%s
    private static final String URL_GET_USERINFO="https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    // 无参构造
    public QQImpl(){

    }
    // 有参构造
    public QQImpl(String accessToken,String appId){
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        // 拼接url
        String url = String.format(URL_GET_OPENID,accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result+"获取结果");
        // callback( {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} );
        // 获取openId
        this.openId = StringUtils.substringBetween(result, "\"openid\":", "}");
    }
    @Override
    public QQUser getQQUser() {
        // 拼接url
        String url = String.format(URL_GET_USERINFO,appId,openId);
        // 发送请求
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result+"结果QQUser");

        // 将字符串转化位对象
        QQUser qqUser = JSON.parseObject(result, QQUser.class);
        System.out.println("获取到的数据:\t"+qqUser);
        return qqUser;
    }
}
