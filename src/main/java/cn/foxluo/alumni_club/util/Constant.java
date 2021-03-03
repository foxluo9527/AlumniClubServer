package cn.foxluo.alumni_club.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "constant")
@Data
public
class Constant {
    public String SEND_URL;
    public String API_KEY;
    public int MODEL_REGISTER;
    public int MODEL_LOGIN;
    public int MODEL_CHANGE_PASS;
    public String TEXT_IDENTIFY;
    public String TEXT_LOGIN;
    public String TEXT_CHANGE_PASS;
    public String ip;
}