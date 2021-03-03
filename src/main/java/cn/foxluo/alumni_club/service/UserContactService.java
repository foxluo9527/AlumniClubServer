package cn.foxluo.alumni_club.service;
import cn.foxluo.alumni_club.model.UserContact;
import cn.foxluo.alumni_club.core.Service;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
public interface UserContactService extends Service<UserContact> {
    int checkContact(UserContact userContact);
}
