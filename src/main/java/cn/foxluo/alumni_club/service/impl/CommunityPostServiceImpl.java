package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.CommunityPostMapper;
import cn.foxluo.alumni_club.model.CommunityPost;
import cn.foxluo.alumni_club.service.CommunityPostService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class CommunityPostServiceImpl extends AbstractService<CommunityPost> implements CommunityPostService {
    @Resource
    private CommunityPostMapper communityPostMapper;

}
