package xdu.cloudnative.service.authority.service;

import com.alibaba.fastjson.JSONObject;
import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.service.authority.vo.LoginInfo;

public interface LoginService {
    JSONObject login(User use);
}
