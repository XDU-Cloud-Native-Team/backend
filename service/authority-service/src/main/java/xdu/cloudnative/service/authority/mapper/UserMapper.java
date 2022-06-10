package xdu.cloudnative.service.authority.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xdu.cloudnative.service.authority.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
