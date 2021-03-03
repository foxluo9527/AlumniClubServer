package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.CommunityPostCommentReplyMapper;
import cn.foxluo.alumni_club.model.CommunityPostCommentReply;
import cn.foxluo.alumni_club.service.CommunityPostCommentReplyService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class CommunityPostCommentReplyServiceImpl extends AbstractService<CommunityPostCommentReply> implements CommunityPostCommentReplyService {
    @Resource
    private CommunityPostCommentReplyMapper communityPostCommentReplyMapper;

}
