package xdu.cloudnative.model.group.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xdu.cloudnative.model.group.entity.CoGroup;
import xdu.cloudnative.model.group.mapper.CoGroupMapper;
import xdu.cloudnative.model.group.service.CoGroupService;

/**
 * @author 邓乐丰@xduTD
 */
@Service
public class CoGroupServiceImpl extends ServiceImpl<CoGroupMapper, CoGroup> implements CoGroupService {
}
