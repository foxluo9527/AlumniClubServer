package cn.foxluo.alumni_club.service;
import cn.foxluo.alumni_club.model.UserMessage;
import cn.foxluo.alumni_club.core.Service;

import java.util.List;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
public interface UserMessageService extends Service<UserMessage> {
    List<UserMessage> getUserAllMessage(Integer id);
}
