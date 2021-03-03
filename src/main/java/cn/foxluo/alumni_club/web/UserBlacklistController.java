package cn.foxluo.alumni_club.web;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.UserBlacklist;
import cn.foxluo.alumni_club.service.UserBlacklistService;
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
@RequestMapping("/user/blacklist")
public class UserBlacklistController {
    @Resource
    private UserBlacklistService userBlacklistService;

    @PostMapping("/add")
    public Result add(UserBlacklist userBlacklist) {
        userBlacklistService.save(userBlacklist);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userBlacklistService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserBlacklist userBlacklist) {
        userBlacklistService.update(userBlacklist);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserBlacklist userBlacklist = userBlacklistService.findById(id);
        return ResultGenerator.genSuccessResult(userBlacklist);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserBlacklist> list = userBlacklistService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
