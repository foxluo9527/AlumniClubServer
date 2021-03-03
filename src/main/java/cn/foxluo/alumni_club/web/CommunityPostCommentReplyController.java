package cn.foxluo.alumni_club.web;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.CommunityPostCommentReply;
import cn.foxluo.alumni_club.service.CommunityPostCommentReplyService;
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
@RequestMapping("/community/post/comment/reply")
public class CommunityPostCommentReplyController {
    @Resource
    private CommunityPostCommentReplyService communityPostCommentReplyService;

    @PostMapping("/add")
    public Result add(CommunityPostCommentReply communityPostCommentReply) {
        communityPostCommentReplyService.save(communityPostCommentReply);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        communityPostCommentReplyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(CommunityPostCommentReply communityPostCommentReply) {
        communityPostCommentReplyService.update(communityPostCommentReply);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        CommunityPostCommentReply communityPostCommentReply = communityPostCommentReplyService.findById(id);
        return ResultGenerator.genSuccessResult(communityPostCommentReply);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CommunityPostCommentReply> list = communityPostCommentReplyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
