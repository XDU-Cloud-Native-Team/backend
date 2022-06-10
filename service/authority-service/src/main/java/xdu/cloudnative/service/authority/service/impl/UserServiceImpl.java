package xdu.cloudnative.service.authority.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xdu.cloudnative.service.authority.entity.User;
import xdu.cloudnative.service.authority.mapper.UserMapper;
import xdu.cloudnative.service.authority.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
