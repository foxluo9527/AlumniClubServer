package cn.foxluo.alumni_club.service;
import cn.foxluo.alumni_club.model.User;
import cn.foxluo.alumni_club.core.Service;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
public interface UserService extends Service<User> {
    User selectByUsername(String userName);
    Integer checkPhone(String phone);
}
