package com.example.st.demo.social.qq.connection;

import com.example.st.demo.bean.QQUser;
import com.example.st.demo.social.qq.api.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author mqx
 * @date 2020-8-25 15:29:37
 */
public class QQAdapter implements ApiAdapter<QQ> {
    // 测试api 是否可以使用
    @Override
    public boolean test(QQ qq) {
        return false;
    }

    // 适配api
    @Override
    public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {
        QQUser qqUser = qq.getQQUser();
        connectionValues.setDisplayName(qqUser.getNickname());
        connectionValues.setImageUrl(qqUser.getFigureurl_1());
        // 设置微博主页的url
        connectionValues.setProfileUrl(null);
        // 唯一标识
        connectionValues.setProviderUserId(qqUser.getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
