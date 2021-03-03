package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.CommunitySectorMapper;
import cn.foxluo.alumni_club.model.CommunitySector;
import cn.foxluo.alumni_club.service.CommunitySectorService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/02.
 */
@Service
@Transactional
public class CommunitySectorServiceImpl extends AbstractService<CommunitySector> implements CommunitySectorService {
    @Resource
    private CommunitySectorMapper communitySectorMapper;

}
