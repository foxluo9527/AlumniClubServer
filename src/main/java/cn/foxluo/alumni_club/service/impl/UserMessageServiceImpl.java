package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.UserMessageMapper;
import cn.foxluo.alumni_club.model.UserMessage;
import cn.foxluo.alumni_club.service.UserMessageService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class UserMessageServiceImpl extends AbstractService<UserMessage> implements UserMessageService {
    @Resource
    private UserMessageMapper userMessageMapper;

    public List<UserMessage> getUserAllMessage(Integer id) {
        return userMessageMapper.getUserAllMessage(id);
    }

    public int receiveMessage(UserMessage messageInfo) {
        return userMessageMapper.receiveMessage(messageInfo);
    }
}
