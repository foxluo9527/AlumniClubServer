package cn.foxluo.alumni_club.dao;

import cn.foxluo.alumni_club.core.Mapper;
import cn.foxluo.alumni_club.model.User;

public interface UserMapper extends Mapper<User> {
    User selectByUsername(String userName);
    Integer checkPhone(String phone);
}