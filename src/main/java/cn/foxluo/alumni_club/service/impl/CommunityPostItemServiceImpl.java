package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.CommunityPostItemMapper;
import cn.foxluo.alumni_club.model.CommunityPostItem;
import cn.foxluo.alumni_club.service.CommunityPostItemService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class CommunityPostItemServiceImpl extends AbstractService<CommunityPostItem> implements CommunityPostItemService {
    @Resource
    private CommunityPostItemMapper communityPostItemMapper;

}
