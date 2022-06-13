package xdu.cloudnative.model.authority.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xdu.cloudnative.model.authority.entity.User;

/**
 * @author 张晓瑞
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
