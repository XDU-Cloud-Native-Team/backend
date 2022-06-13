package xdu.cloudnative.model.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xdu.cloudnative.model.file.entity.File;

/**
 * @author 邓乐丰@xduTD
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {
}
