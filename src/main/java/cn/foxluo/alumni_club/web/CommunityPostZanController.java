package cn.foxluo.alumni_club.web;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.CommunityPostZan;
import cn.foxluo.alumni_club.service.CommunityPostZanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by foxluo.cn on 2020/12/02.
*/
@RestController
@RequestMapping("/community/post/zan")
public class CommunityPostZanController {
    @Resource
    private CommunityPostZanService communityPostZanService;

    @PostMapping("/add")
    public Result add(CommunityPostZan communityPostZan) {
        communityPostZanService.save(communityPostZan);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        communityPostZanService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(CommunityPostZan communityPostZan) {
        communityPostZanService.update(communityPostZan);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        CommunityPostZan communityPostZan = communityPostZanService.findById(id);
        return ResultGenerator.genSuccessResult(communityPostZan);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CommunityPostZan> list = communityPostZanService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
