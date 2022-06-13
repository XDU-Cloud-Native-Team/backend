package xdu.cloudnative.service.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.model.authority.mapper.UserMapper;
import xdu.cloudnative.model.authority.service.UserService;

import xdu.cloudnative.service.authority.vo.RegisterInfo;

/**
 * @author 张晓瑞
 */
@CrossOrigin
@RestController
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping("/register")
    public JSONObject register(@RequestBody RegisterInfo registerInfo){

        JSONObject json = new JSONObject();

        // 前置验证
        if (registerInfo == null) {
            json.put("result", "failed");
            json.put("errMsg", "参数错误");
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", registerInfo.getUsername());
        User user = userMapper.selectOne(wrapper);
        if(user != null){
            json.put("result","failed");
            json.put("errMsg","该名称用户已存在");
            return json;
        }
        userService.save(new User(registerInfo.getUsername(), registerInfo.getPassword(), registerInfo.getEmail()));
        json.put("result","success");
        return json;
    }
}
