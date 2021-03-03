package cn.foxluo.alumni_club.dao;

import cn.foxluo.alumni_club.core.Mapper;
import cn.foxluo.alumni_club.model.UserMessage;

import java.util.List;

public interface UserMessageMapper extends Mapper<UserMessage> {
    List<UserMessage> getUserAllMessage(Integer id);
    Integer receiveMessage(UserMessage userMessage);
}