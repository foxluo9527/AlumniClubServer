package cn.foxluo.alumni_club.dao;

import cn.foxluo.alumni_club.core.Mapper;
import cn.foxluo.alumni_club.model.UserContact;

public interface UserContactMapper extends Mapper<UserContact> {
    Integer checkContact(UserContact userContact);
}