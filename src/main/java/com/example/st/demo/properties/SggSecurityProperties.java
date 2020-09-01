package com.example.st.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mqx
 * @date 2020-8-25 20:16:19
 */
@Component
@Data
@ConfigurationProperties(prefix = "sgg.security")
public class SggSecurityProperties {
    // 创建对象
    private SggSocialProperties sggSocialProperties = new SggSocialProperties();
}
