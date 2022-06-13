package xdu.cloudnative.model.authority.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.model.authority.mapper.UserMapper;
import xdu.cloudnative.model.authority.service.UserService;

/**
 * @author 张晓瑞
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
