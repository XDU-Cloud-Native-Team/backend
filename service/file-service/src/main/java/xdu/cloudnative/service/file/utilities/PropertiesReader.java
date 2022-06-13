package xdu.cloudnative.service.file.utilities;

import java.io.IOException;
import java.util.Properties;

/**
 * @author 邓乐丰@xduTD
 */
public class PropertiesReader {
    /** Content-Type字段的默认值 */
    static String DEFAULT_CONTENT_TYPE = "application/force-download";
    /** 配置类 */
    static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream("file-ext2content-type.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件的content-type
     *
     * @param fileName 文件名
     * @return 文件对应的响应中的content-type字段值
     */
    public static String getContentType(String fileName) {
        // 如果输入的字符串为空，直接返回默认值
        if (fileName == null || fileName.isEmpty()) {
            return DEFAULT_CONTENT_TYPE;
        }

        // 获取文件的拓展名，然后根据拓展名在配置文件中找到匹配的content-type
        String ext = fileName.substring(fileName.lastIndexOf('.'));
        return properties.getProperty(ext, DEFAULT_CONTENT_TYPE);
    }

}
