package xdu.cloudnative.service.file.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.model.authority.service.UserService;
import xdu.cloudnative.model.file.entity.File;
import xdu.cloudnative.model.file.mapper.FileMapper;

import xdu.cloudnative.service.file.service.FileTransportService;
import xdu.cloudnative.service.file.utilities.FileNameUtilities;
import xdu.cloudnative.service.file.utilities.IOUtilities;

import java.sql.Timestamp;

/**
 * @author 邓乐丰@xduTD
 */
@Service
public class FileTransportServiceImpl implements FileTransportService {

    /** 挂载的文件系统 */
    private String localStoreDirectory = "/mnt/myjfs/";
    /** 用于文件下载的缓冲区大小 */
    private int bufferSize = 1024;

    @Autowired
    UserService userService;
    @Autowired
    FileMapper fileMapper;

    @Override
    public void storeFile(byte[] bytes, String filename, String localStoreDirectory, String userId) {
        User user = userService.getById(Integer.parseInt(userId));
        long timeMillis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(timeMillis);

        // 计算文件的hashtag：真正存储在服务器目录上的文件名
        String hashtag = FileNameUtilities.generateHashTag(filename, user, timeMillis);
        IOUtilities.storeFile(bytes, localStoreDirectory + hashtag);

        // 写数据库：文件信息
        File file = new File(hashtag, filename, Integer.parseInt(userId), user.getGroupId(), bytes.length, timestamp, 0);
        fileMapper.insert(file);
    }


}
