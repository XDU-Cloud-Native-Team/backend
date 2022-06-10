package xdu.cloudnative.service.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xdu.cloudnative.service.authority.entity.User;
import xdu.cloudnative.service.authority.mapper.UserMapper;
import xdu.cloudnative.service.authority.service.UserService;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping("/register")
    public JSONObject register(@RequestParam(value = "username") String username,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "phone") String phone){
        // fix : chang param into object
        JSONObject json = new JSONObject();

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = userMapper.selectOne(wrapper);
        if(user != null){
            json.put("result","failed");
            json.put("errMsg","该名称用户已存在");
            return json;
        }
        userService.save(new User(username,password,email));
        json.put("result","success");
        return json;
    }
}
