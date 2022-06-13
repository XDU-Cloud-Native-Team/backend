package xdu.cloudnative.service.file.service;


/**
 * @author 邓乐丰@xduTD
 */
public interface FileTransportService {

    /**
     * @param bytes 文件内容（二进制）
     * @param fileName 文件名（带拓展名后缀）
     * @Param localStoreDirectory 本地存储文件的目录
     * @param userId 上传该文件的用户ID
     */
    void storeFile(byte[] bytes, String fileName, String localStoreDirectory, String userId);


}
