package xdu.cloudnative.service.file.utilities;

import xdu.cloudnative.model.authority.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 邓乐丰@xduTD
 */
public class FileNameUtilities {

    /**
     * 根据当前时间戳、文件名和用户信息创建文件的HashTag
     * HashTag格式：yyyyMMdd + hashcode + fileExtension
     *
     * @param filename 原始文件名
     * @param user 上传文件的用户
     * @return hashTag 文件的哈希标识符
     */
    public static String generateHashTag(String filename, User user, long timeMillis) {
        // 获取文件拓展名
        int dot = filename.lastIndexOf('.');
        String fileExt = filename.substring(dot);

        // 获取文件名和用户名，哈希后做异或
        int hashCode = filename.hashCode() ^ user.getUsername().hashCode();

        // 获取上传文件的日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(timeMillis);
        String dateStr = formatter.format(date);

        String hashTag = dateStr + "-" + hashCode + fileExt;
        return hashTag;
    }


}
