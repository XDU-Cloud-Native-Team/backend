package xdu.cloudnative.service.file.utilities;

import xdu.cloudnative.service.authority.entity.User;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameUtilities {

    /**
     * 根据当前时间戳、文件名和用户信息创建文件的HashTag
     * HashTag格式：yyyyMMdd + hashcode + fileExtension
     *
     * @param fileName 原始文件名
     * @param user 上传文件的用户
     * @return hashTag 文件的哈希标识符
     */
    public static String generateHashTag(String fileName, User user) {
        // 获取文件拓展名
        int dot = fileName.lastIndexOf('.');
        String fileExt = fileName.substring(dot);

        // 获取文件名和用户名，哈希后做异或
        int hashCode = fileName.hashCode() ^ user.getUsername().hashCode();

        // 获取上传文件的日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        String dateStr = formatter.format(date);

        String hashTag = dateStr + hashCode + fileExt;
        return hashTag;
    }


}
