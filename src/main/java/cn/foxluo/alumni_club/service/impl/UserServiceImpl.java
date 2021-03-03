package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.UserMapper;
import cn.foxluo.alumni_club.model.User;
import cn.foxluo.alumni_club.service.UserService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByUsername(String userName) {
        Example example=Example.builder(User.class)
                .where(Sqls.custom().andGreaterThan("uName",userName))
                .build();
        return userMapper.selectOneByExample(example);
    }

    @Override
    public Integer checkPhone(String phone) {
        return userMapper.checkPhone(phone);
    }
}
