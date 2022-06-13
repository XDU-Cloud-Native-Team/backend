package xdu.cloudnative.service.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xdu.cloudnative.exception.UserNotExistsException;
import xdu.cloudnative.model.file.entity.File;
import xdu.cloudnative.exception.FileNotExistsException;
import xdu.cloudnative.model.file.mapper.FileMapper;
import xdu.cloudnative.service.file.service.FileManagementService;

import java.util.List;

/**
 * @author 邓乐丰@xduTD
 */
@Service
public class FileManagementServiceImpl implements FileManagementService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public List<File> getPrivateFileList(String userId) {
        QueryWrapper<File> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", Integer.parseInt(userId));
        return fileMapper.selectList(wrapper);
    }

    @Override
    public void deleteFile(String userId, String hashtag) throws UserNotExistsException, FileNotExistsException {

    }
}
