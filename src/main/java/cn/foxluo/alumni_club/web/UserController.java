package cn.foxluo.alumni_club.web;
import cn.foxluo.alumni_club.bean.ChangePassParam;
import cn.foxluo.alumni_club.bean.LoginNoPassParam;
import cn.foxluo.alumni_club.bean.LoginParam;
import cn.foxluo.alumni_club.bean.RegisterBean;
import cn.foxluo.alumni_club.core.Result;
import cn.foxluo.alumni_club.core.ResultGenerator;
import cn.foxluo.alumni_club.model.User;
import cn.foxluo.alumni_club.service.impl.UserServiceImpl;
import cn.foxluo.alumni_club.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* Created by foxluo.cn on 2020/12/02.
*/
@RestController
@Api(description = "用户相关文档")
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;
    private final Constant Constant;

    public UserController(Constant Constant) {
        this.Constant = Constant;
    }


    @PostMapping("/account/register")
    @ApiOperation(value="用户注册",httpMethod = "POST",notes="接收验证码后注册调用", produces="application/json")
    public Result register(RegisterBean registerBean){
        if (userService.checkPhone(registerBean.getPhone())==0){
            if (registerBean.getCode().equals(SMSUtil.getCode(registerBean.getPhone()))&&SMSUtil.getModel(registerBean.getPhone())==Constant.MODEL_REGISTER) {
                if (new Date().getTime()<SMSUtil.getUsefulTime(registerBean.getPhone())) {
                    SMSUtil.removeSMS(registerBean.getPhone());                             //验证成功移除验证码队列
                    registerBean.setPassword(MD5Util.getMD5Str(registerBean.getPassword()));//密码加密储存
                    User user=new User();
                    user.setuCreateTime(new Date());
                    user.setuLocalId(registerBean.getLocalId());
                    user.setuLocalName(registerBean.getLocalName());
                    user.setuNickName(registerBean.getNickName());
                    user.setuUniversityId(registerBean.getSchoolId());
                    user.setuUniversityName(registerBean.getSchoolName());
                    user.setuPassword(registerBean.getPassword());
                    user.setuPhone(registerBean.getPhone());
                    user.setuSex(registerBean.getSex());
                    user.setuName(GetRandom.getStringRandom(8));
                    userService.save(user);
                    return ResultGenerator.genSuccessResult();
                }else {
                    return ResultGenerator.genFailResult("注册失败:验证码超时");
                }
            }else {
                return ResultGenerator.genFailResult("注册失败:验证码错误");
            }
        }else {
            return ResultGenerator.genFailResult("注册失败:该手机号已注册");
        }
    }
    @GetMapping("/account/registerRequest/{phone}")
    @ApiOperation(value="用户注册请求短信",httpMethod = "GET",notes="发送用户注册请求短信:Restful风格(url/{param} param->替换{param})")
    public Result registerRequest(@PathVariable("phone") String phone){
        if (userService.checkPhone(phone)==0){
            if (SMSUtil.getCount(phone)<3) {
                if (SMSUtil.getTimeout(phone)) {
                    if (SMSUtil.sendSMS(phone, Constant.MODEL_REGISTER,Constant)) {
                        //发送成功
                        return ResultGenerator.genSuccessResult();
                    }else {
                        //发送失败
                        return ResultGenerator.genFailResult("验证码发送失败,请检查号码后重试");
                    }
                }else {
                    return ResultGenerator.genFailResult("验证码发送失败:一分钟内不能重复发送");
                }
            }else {
                //一小时内发送短信次数超过三次
                return ResultGenerator.genFailResult("验证码发送失败:一小时内发送不能超过三次");
            }
        }else {
            return ResultGenerator.genFailResult("验证码发送失败:该手机号已注册");
        }
    }

    @PostMapping("/account/login")
    @ApiOperation(value="用户登录",httpMethod = "POST",notes="用户使用用户名&密码登录,成功返回data:{token:登录令牌,loginUser:{登录用户信息,具体数据自己请求}}", produces="application/json")
    public Result login(LoginParam loginParam){
        JSONObject result=new JSONObject();
        User user=userService.findBy("uName",loginParam.getUsername());
        if (user==null){
            user=userService.findBy("uPhone",loginParam.getUsername());
        }
        if (user!=null&&user.getuPassword().equals(MD5Util.getMD5Str(loginParam.getPassword()))){
            String token= UUID.randomUUID().toString();
            result.put("token",token);
            result.put("loginUser", user);
            TokenUtil.addToken(token,user,24*60);
            return ResultGenerator.genSuccessResult(result);
        }else {
            return ResultGenerator.genFailResult("登录失败:账号或密码错误");
        }
    }
    @PostMapping("/account/loginNoPass")
    @ApiOperation(value="用户免密登录",httpMethod = "POST",notes="用户免密登录，接收验证码后免密登录调用,成功返回data:{token:登录令牌,loginUser:{登录用户信息,具体数据自己请求}}", produces="application/json")
    public Result loginNoPass(LoginNoPassParam loginParam){
        if (userService.checkPhone(loginParam.getPhone())>0){
            if (loginParam.getCode().equals(SMSUtil.getCode(loginParam.getPhone()))&&SMSUtil.getModel(loginParam.getPhone())==Constant.MODEL_LOGIN) {
                User user=userService.findBy("uPhone",loginParam.getPhone());
                if (user!=null){
                    JSONObject result=new JSONObject();
                    String token= UUID.randomUUID().toString();
                    result.put("token",token);
                    result.put("loginUser", user);
                    TokenUtil.addToken(token,user,24*60);
                    return ResultGenerator.genSuccessResult(result);
                }else {
                    return ResultGenerator.genFailResult("登录失败:未找到账户信息");
                }
            }else {
                return ResultGenerator.genFailResult("登录失败:验证码错误");
            }
        }else {
            return ResultGenerator.genFailResult("登录失败:该手机号未注册");
        }
    }
    @GetMapping("/account/loginNoPassRequest/{phone}")
    @ApiOperation(value="用户免密登录请求短信",httpMethod = "GET",notes="发送用户免密登录请求短信")
    public Result loginNoPassRequest(@PathVariable("phone") String phone){
        if (userService.checkPhone(phone)>0){
            if (SMSUtil.getCount(phone)<3) {
                if (SMSUtil.getTimeout(phone)) {
                    if (SMSUtil.sendSMS(phone, Constant.MODEL_LOGIN,Constant)) {
                        //发送成功
                        return ResultGenerator.genSuccessResult();
                    }else {
                        //发送失败
                        return ResultGenerator.genFailResult("验证码发送失败,请检查号码后重试");
                    }
                }else {
                    return ResultGenerator.genFailResult("验证码发送失败:一分钟内不能重复发送");
                }
            }else {
                //一小时内发送短信次数超过三次
                return ResultGenerator.genFailResult("验证码发送失败:一小时内发送不能超过三次");
            }
        }else {
            return ResultGenerator.genFailResult("验证码发送失败:该手机号未注册");
        }
    }
    @PostMapping("/account/changePass")
    @ApiOperation(value="用户修改密码",httpMethod = "POST", produces="application/json")
    public Result changePass(ChangePassParam changePassParam){
        if (userService.checkPhone(changePassParam.getPhone())>0){
            if (changePassParam.getCode().equals(SMSUtil.getCode(changePassParam.getPhone()))&&SMSUtil.getModel(changePassParam.getPhone())==Constant.MODEL_CHANGE_PASS) {
                User user=userService.findBy("uPhone",changePassParam.getPhone());
                if (user!=null){
                    user.setuPassword(MD5Util.getMD5Str(changePassParam.getPass()));
                    userService.update(user);
                    return ResultGenerator.genSuccessResult();
                }else {
                    return ResultGenerator.genFailResult("修改密码失败:未找到账户信息");
                }
            }else {
                return ResultGenerator.genFailResult("修改密码失败:验证码错误");
            }
        }else {
            return ResultGenerator.genFailResult("修改密码失败:该手机号未注册");
        }
    }
    @GetMapping("/account/changePassRequest/{phone}")
    @ApiOperation(value="用户修改密码请求短信",httpMethod = "GET",notes="发送用户修改密码请求短信")
    public Result changePassRequest(@PathVariable("phone") String phone){
        if (userService.checkPhone(phone)>0){
            if (SMSUtil.getCount(phone)<3) {
                if (SMSUtil.getTimeout(phone)) {
                    if (SMSUtil.sendSMS(phone, Constant.MODEL_CHANGE_PASS,Constant)) {
                        //发送成功
                        return ResultGenerator.genSuccessResult();
                    }else {
                        //发送失败
                        return ResultGenerator.genFailResult("验证码发送失败,请检查号码后重试");
                    }
                }else {
                    return ResultGenerator.genFailResult("验证码发送失败:一分钟内不能重复发送");
                }
            }else {
                //一小时内发送短信次数超过三次
                return ResultGenerator.genFailResult("验证码发送失败:一小时内发送不能超过三次");
            }
        }else {
            return ResultGenerator.genFailResult("验证码发送失败:该手机号未注册");
        }
    }
    @PostMapping("/update")
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
