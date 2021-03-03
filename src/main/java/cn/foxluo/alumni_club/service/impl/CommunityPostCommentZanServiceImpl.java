package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.CommunityPostCommentZanMapper;
import cn.foxluo.alumni_club.model.CommunityPostCommentZan;
import cn.foxluo.alumni_club.service.CommunityPostCommentZanService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class CommunityPostCommentZanServiceImpl extends AbstractService<CommunityPostCommentZan> implements CommunityPostCommentZanService {
    @Resource
    private CommunityPostCommentZanMapper communityPostCommentZanMapper;

}
