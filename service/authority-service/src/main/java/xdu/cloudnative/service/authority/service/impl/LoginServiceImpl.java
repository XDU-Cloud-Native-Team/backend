package xdu.cloudnative.service.authority.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.service.authority.service.LoginService;
import xdu.cloudnative.service.authority.vo.LoginInfo;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public JSONObject login(User user) {
        return null;
    }
}
