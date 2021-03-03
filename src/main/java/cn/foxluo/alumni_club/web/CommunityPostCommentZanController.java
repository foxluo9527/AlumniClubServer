package cn.foxluo.alumni_club.web;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.CommunityPostCommentZan;
import cn.foxluo.alumni_club.service.CommunityPostCommentZanService;
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
@RequestMapping("/community/post/comment/zan")
public class CommunityPostCommentZanController {
    @Resource
    private CommunityPostCommentZanService communityPostCommentZanService;

    @PostMapping("/add")
    public Result add(CommunityPostCommentZan communityPostCommentZan) {
        communityPostCommentZanService.save(communityPostCommentZan);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        communityPostCommentZanService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(CommunityPostCommentZan communityPostCommentZan) {
        communityPostCommentZanService.update(communityPostCommentZan);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        CommunityPostCommentZan communityPostCommentZan = communityPostCommentZanService.findById(id);
        return ResultGenerator.genSuccessResult(communityPostCommentZan);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CommunityPostCommentZan> list = communityPostCommentZanService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
