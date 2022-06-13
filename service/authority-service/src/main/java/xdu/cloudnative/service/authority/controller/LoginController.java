package xdu.cloudnative.service.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.model.authority.mapper.UserMapper;
import xdu.cloudnative.model.authority.service.UserService;

import xdu.cloudnative.service.authority.vo.LoginInfo;

/**
 * @author 张晓瑞
 */
@CrossOrigin
@RestController
@RequestMapping
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/login")
    public JSONObject login(@RequestBody LoginInfo loginInfo) {

        JSONObject json = new JSONObject();

        // 前置验证
        if (loginInfo == null) {
            json.put("result", "failed");
            json.put("errMsg", "参数错误");
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", loginInfo.getUsername());
        User user = userMapper.selectOne(wrapper);
        if(user == null) {
            json.put("result", "failed");
            json.put("errMsg", "用户不存在");
            return json;
        }

        if(!user.getPassword().equals(loginInfo.getPassword())){
            json.put("result", "failed");
            json.put("errMsg", "密码错误");
            return json;
        }
        json.put("result", "success");
        json.put("userId", String.valueOf(user.getId()));
        return json;
    }
}
