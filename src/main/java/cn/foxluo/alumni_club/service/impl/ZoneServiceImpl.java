package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.ZoneMapper;
import cn.foxluo.alumni_club.model.Zone;
import cn.foxluo.alumni_club.service.ZoneService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/04.
 */
@Service
@Transactional
public class ZoneServiceImpl extends AbstractService<Zone> implements ZoneService {
    @Resource
    private ZoneMapper zoneMapper;

}
