package cn.foxluo.alumni_club.service.impl;

import cn.foxluo.alumni_club.dao.SqlPhotoMapper;
import cn.foxluo.alumni_club.model.SqlPhoto;
import cn.foxluo.alumni_club.service.SqlPhotoService;
import cn.foxluo.alumni_club.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by foxluo.cn on 2020/12/21.
 */
@Service
@Transactional
public class SqlPhotoServiceImpl extends AbstractService<SqlPhoto> implements SqlPhotoService {
    @Resource
    private SqlPhotoMapper sqlPhotoMapper;

}
