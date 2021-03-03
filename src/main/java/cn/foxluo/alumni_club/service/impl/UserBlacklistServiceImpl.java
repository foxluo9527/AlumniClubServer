package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.UserBlacklistMapper;
import cn.foxluo.alumni_club.model.UserBlacklist;
import cn.foxluo.alumni_club.service.UserBlacklistService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class UserBlacklistServiceImpl extends AbstractService<UserBlacklist> implements UserBlacklistService {
    @Resource
    private UserBlacklistMapper userBlacklistMapper;

}
