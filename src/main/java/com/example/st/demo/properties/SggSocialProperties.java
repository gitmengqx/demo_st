package com.example.st.demo.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author mqx
 * @date 2020-8-25 20:14:12
 */
@Data
public class SggSocialProperties {
    // 配置rul
    private String filterProcessesUrl = "/auth";
    private QQProperties qq=new QQProperties();
}
