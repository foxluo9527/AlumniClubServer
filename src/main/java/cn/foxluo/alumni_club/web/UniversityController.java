package cn.foxluo.alumni_club.web;

import cn.foxluo.alumni_club.bean.ResultUniversityBean;
import cn.foxluo.alumni_club.bean.UniversityData;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.University;
import cn.foxluo.alumni_club.model.Zone;
import cn.foxluo.alumni_club.service.UniversityService;
import cn.foxluo.alumni_club.service.impl.ZoneServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by foxluo.cn on 2020/12/04.
 */
@RestController
@RequestMapping(value = "/university",produces = "application/json;charset=utf-8")
@Api(description = "学校相关文档")
public class UniversityController {

    final
    ZoneServiceImpl zoneService;

    public UniversityController(ZoneServiceImpl zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping(value = "/getData")
    @ApiOperation(value = "获取所有地区学校信息", httpMethod = "GET")
    @ApiResponse(code = 200, message = "请求成功", response = ResultUniversityBean.class)
    public Result getAllUniversityMessage() {
        UniversityData universityData = new UniversityData();
        universityData.setUniversity(universityService.findAll());
        universityData.setZone(zoneService.findAll());

        ResultUniversityBean resultUniversityData = new ResultUniversityBean();
        resultUniversityData.setZoneBeans(new ArrayList<>());
        if (universityData != null) {
            ArrayList<Zone> zones = (ArrayList<Zone>) universityData.getZone();
            ArrayList<University> universities = (ArrayList<University>) universityData.getUniversity();
            for (int i = 0; i < zones.size(); i++) {
                ResultUniversityBean.ZoneBean zoneBean = new ResultUniversityBean.ZoneBean();
                zoneBean.setId(zones.get(i).getId());
                zoneBean.setName(zones.get(i).getName());
                ArrayList<ResultUniversityBean.UniversityBean> resultUniversityBeans = new ArrayList<>();
                for (int j = 0; j < universities.size(); j++) {
                    if (universities.get(j).getZone().equals(zones.get(i).getId())) {
                        ResultUniversityBean.UniversityBean universityBean = new ResultUniversityBean.UniversityBean();
                        universityBean.setId(universities.get(j).getId());
                        universityBean.setName(universities.get(j).getName());
                        resultUniversityBeans.add(universityBean);
                        universities.remove(universities.get(j));
                        j--;
                    }
                }
                zoneBean.setUniversityBean(resultUniversityBeans);
                resultUniversityData.getZoneBeans().add(zoneBean);
            }
        }
        if (resultUniversityData!=null){
            return ResultGenerator.genSuccessResult(resultUniversityData);
        }else {
            return ResultGenerator.genFailResult("获取学校信息失败!");
        }
    }

    @Resource
    private UniversityService universityService;

    @PostMapping("/add")
    public Result add(University university) {
        universityService.save(university);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        universityService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(University university) {
        universityService.update(university);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        University university = universityService.findById(id);
        return ResultGenerator.genSuccessResult(university);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<University> list = universityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
