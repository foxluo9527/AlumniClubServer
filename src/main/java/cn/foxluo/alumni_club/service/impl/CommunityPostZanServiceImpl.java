package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.CommunityPostZanMapper;
import cn.foxluo.alumni_club.model.CommunityPostZan;
import cn.foxluo.alumni_club.service.CommunityPostZanService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class CommunityPostZanServiceImpl extends AbstractService<CommunityPostZan> implements CommunityPostZanService {
    @Resource
    private CommunityPostZanMapper communityPostZanMapper;

}
