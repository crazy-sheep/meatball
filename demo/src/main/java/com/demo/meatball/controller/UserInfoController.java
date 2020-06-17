package com.demo.meatball.controller;

import com.demo.meatball.po.UserInfo;
import com.demo.meatball.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RequestMapping("/user")
@RestController
@Api
public class UserInfoController {
    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @ApiOperation(value = "根据用户名获取用户信息",notes = "用户信息")
    @RequestMapping(value = "/userName/{userName}",method = RequestMethod.GET)
    public UserInfo getUser(@PathVariable("userName")String userName){
        return userInfoService.findUserByName(userName);
    }

    @ApiOperation(value = "创建用户",notes = "用户信息")
    @RequestMapping(value = "/creatUser",method = RequestMethod.POST)
    public UserInfo creatUser(@RequestBody UserInfo user){
        return userInfoService.saveUser(user);
    }

    @ApiOperation(value = "更新用户信息",notes = "用户信息")
    @RequestMapping(value = "/UpdateUser",method = RequestMethod.PUT)
    public UserInfo UpdateUser(@RequestBody UserInfo user){
        return userInfoService.saveUser(user);
    }

    @ApiOperation(value = "删除用户",notes = "删除用户")
    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody long id){
        userInfoService.deleteUser(id);
        return "删除成功";
    }

    @ApiIgnore
    @RequestMapping(value = "/jsonTest",method = RequestMethod.GET)
    public String jsonTest(){
        return "测试成功";
    }
}
