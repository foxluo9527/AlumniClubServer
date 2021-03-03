package cn.foxluo.alumni_club.web;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.CommunitySector;
import cn.foxluo.alumni_club.service.CommunitySectorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by foxluo.cn on 2020/12/02.
*/
@RestController
@RequestMapping("/community/sector")
public class CommunitySectorController {
    @Resource
    private CommunitySectorService communitySectorService;

    @PostMapping("/add")
    public Result add(CommunitySector communitySector) {
        communitySectorService.save(communitySector);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        communitySectorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(CommunitySector communitySector) {
        communitySectorService.update(communitySector);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        CommunitySector communitySector = communitySectorService.findById(id);
        return ResultGenerator.genSuccessResult(communitySector);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CommunitySector> list = communitySectorService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @GetMapping("/getById/{id}")
    public Result getCommunitySectors(@PathVariable("id") String id,String token){
        CommunitySector list =communitySectorService.findBy("communityId",id);
        if (list!=null){
            return ResultGenerator.genSuccessResult(list);
        }
        return ResultGenerator.genFailResult("获取数据失败");
    }
}
