package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.CommunityPostCommentMapper;
import cn.foxluo.alumni_club.model.CommunityPostComment;
import cn.foxluo.alumni_club.service.CommunityPostCommentService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class CommunityPostCommentServiceImpl extends AbstractService<CommunityPostComment> implements CommunityPostCommentService {
    @Resource
    private CommunityPostCommentMapper communityPostCommentMapper;

}
