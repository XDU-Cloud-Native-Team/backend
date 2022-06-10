package xdu.cloudnative.service.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xdu.cloudnative.service.authority.entity.User;
import xdu.cloudnative.service.authority.mapper.UserMapper;
import xdu.cloudnative.service.authority.service.UserService;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/login")
    public JSONObject login(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password){
        JSONObject json = new JSONObject();

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userMapper.selectOne(wrapper);
        if(user == null) {
            json.put("result", "failed");
            json.put("errMsg", "用户不存在");
            return json;
        }

        if(!user.getPassword().equals(password)){
            json.put("result", "failed");
            json.put("errMsg", "密码错误");
            return json;
        }
        json.put("result", "success");
        return json;
    }
}
