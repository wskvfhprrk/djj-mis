package com.guardlbt.wx;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "wx")
@Data
public class WxConfigurationProperties {

    private String appID;

    private String appSecret;
}
