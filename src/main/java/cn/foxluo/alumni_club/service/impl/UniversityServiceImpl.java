package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.UniversityMapper;
import cn.foxluo.alumni_club.model.University;
import cn.foxluo.alumni_club.service.UniversityService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/04.
 */
@Service
@Transactional
public class UniversityServiceImpl extends AbstractService<University> implements UniversityService {
    @Resource
    private UniversityMapper universityMapper;

}
