package xdu.cloudnative.model.file.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xdu.cloudnative.model.file.entity.File;
import xdu.cloudnative.model.file.mapper.FileMapper;
import xdu.cloudnative.model.file.service.FileService;

/**
 * @author 邓乐丰@xduTD
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
}
