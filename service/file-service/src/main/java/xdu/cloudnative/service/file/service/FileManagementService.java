package xdu.cloudnative.service.file.service;

import xdu.cloudnative.exception.UserNotExistsException;
import xdu.cloudnative.model.file.entity.File;
import xdu.cloudnative.exception.FileNotExistsException;

import java.util.List;

/**
 * @author 邓乐丰@xduTD
 */
public interface FileManagementService {

    /**
     * @param userId 用户ID
     * @return 所有文件信息的列表
     */
    List<File> getPrivateFileList(String userId);

    /**
     * 删除文件
     *
     * @param userId 用户ID
     * @param hashtag 文件的标识符
     * @throws UserNotExistsException
     * @throws FileNotExistsException
     */
    void deleteFile(String userId, String hashtag) throws UserNotExistsException, FileNotExistsException;


}
