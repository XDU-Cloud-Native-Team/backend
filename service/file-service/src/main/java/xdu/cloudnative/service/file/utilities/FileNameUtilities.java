package xdu.cloudnative.service.file.utilities;

import xdu.cloudnative.service.authority.entity.User;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameUtilities {

    /**
     * 根据当前时间戳、文件名和用户信息创建文件的HashTag
     *
     */
    public static String generateHashTag(String fileName, User user) {
        // 获取文件名和用户名，哈希后做异或
        int hashCode = fileName.hashCode() ^ user.getUsername().hashCode();

        // 获取
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());

        return null;
    }
}
