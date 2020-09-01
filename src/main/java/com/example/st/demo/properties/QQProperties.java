package com.example.st.demo.properties;

import com.example.st.demo.social.configutils.SocialProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mqx
 * @date 2020-8-25 16:08:42
 */
@Data
public class QQProperties extends SocialProperties {

      // 默认qq 方式
    private String providerId = "qq";

}
