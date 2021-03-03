package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.UserContactMapper;
import cn.foxluo.alumni_club.model.UserContact;
import cn.foxluo.alumni_club.service.UserContactService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class UserContactServiceImpl extends AbstractService<UserContact> implements UserContactService {
    @Resource
    private UserContactMapper userContactMapper;

    @Override
    public int checkContact(UserContact userContact) {
        return userContactMapper.checkContact(userContact);
    }
}
