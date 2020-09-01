package com.example.st.demo.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author mqx
 *  继承springsocialSocial为我们提供的SocialAuthenticationFilter的配置类SpringSocialConfigurer
 *  并重写其后置处理方法，让其默认拦截包含我们配置字符串的请求
 * @date 2020-8-26 11:11:03
 */
public class SggSpringSocialConfigurer extends SpringSocialConfigurer {

    // 配置url
    private String filterProcessesUrl;

    // 构造函数传入url
    public SggSpringSocialConfigurer(String filterProcessesUrl){
        this.filterProcessesUrl = filterProcessesUrl;
    }
    @Override
    protected <T> T postProcess(T object) {
        // 获取到过滤对象
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        // 设置url
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }
}
