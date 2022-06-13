package xdu.cloudnative.service.file.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xdu.cloudnative.service.file.service.FileTransportService;
import xdu.cloudnative.service.file.utilities.PropertiesReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author 邓乐丰
 */
@CrossOrigin
@RestController
public class FileTransportController {

    /** 用户ID的长度 */
    static final int USER_ID_LEN = 11;
    /** 挂载的文件系统 */
    private String localStoreDirectory = "/mnt/myjfs/";
    /** 用于文件下载的缓冲区大小 */
    private int bufferSize = 1024;

    @Autowired
    FileTransportService fileTransportService;


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadFile(HttpServletRequest request, HttpServletResponse response,
                                 @RequestPart("file") MultipartFile multipartFile,
                                 @RequestPart("userId") String userId) {

        JSONObject json = new JSONObject();

        // 上传的文件判空 && 用户ID是否有效
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            json.put("result", "failed");
            json.put("errMsg", "File is empty, maybe upload failed.");
            return json;
        }
        if (userId == null || userId.trim().length() != USER_ID_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid user id, check the length of your id");
            return json;
        }
        // 获取上传的用户token+文件名，作为新文件名保存在服务器文件系统上
        // TODO: 用户token
        String filename = multipartFile.getOriginalFilename();
        // TODO: 文件的HashTag：Hash(原始文件名+上传人id) + 时间戳，作为储存在服务器的文件名

        // 保存文件
        try {
            fileTransportService.storeFile(multipartFile.getBytes(), filename, localStoreDirectory, userId.trim());
            json.put("result", "success");
        } catch (IOException e) {
            json.put("result", "failed");
            json.put("errMsg", e.getMessage());
        }

        return json;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject downloadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("hashtag") String hashtag) {
        JSONObject json = new JSONObject();

        // 参数合法性检查
        if (hashtag == null) {
            json.put("result", "failed");
            json.put("errMsg", "invalid input of file hashtag");
            return json;
        }

        // FIXME: firePath这里还需要商榷，暂时先这么写
        String filePath = localStoreDirectory + hashtag;
        File file = new File(filePath);
        // 判断文件是否存在，并且该文件不是目录，才能进行数据传输
        if (file.exists() && file.isFile()) {
            // 判断无误，开始传输文件
            String fileName = file.getName();
            try {
                // 重置response
                response.reset();

                // 设置ContentType（即告诉客户端所发送的数据属于什么类型），设置文件长度、编码格式
                String contentType = PropertiesReader.getContentType(fileName);
                response.setContentType(contentType + "; charset=UTF-8");
                response.setHeader("Content-Length", String.valueOf(file.length()));
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

                // 向response中写数据
                OutputStream outputStream = response.getOutputStream();
                byte[] buff = new byte[bufferSize];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                int i = bis.read(buff);
                while (i != -1) {
                    // 将文件写出
                    outputStream.write(buff, 0, buff.length);
                    // 刷出
                    outputStream.flush();
                    i = bis.read(buff);
                }
                json.put("result", "success");
            } catch (IOException e) {
                json.put("result", "failed");
                json.put("errMsg", e.getMessage());
            }
        } else {
            json.put("result", "failed");
            json.put("errMsg", "cannot find the file, check your hashtag");
        }

        return json;
    }

}
