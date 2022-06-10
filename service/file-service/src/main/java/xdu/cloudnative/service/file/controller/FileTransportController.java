package xdu.cloudnative.service.file.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import xdu.cloudnative.service.file.utilities.IOUtilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author 邓乐丰
 */
@RestController
public class FileTransportController {

    //@Value("${fileDirectory}:/mnt/myjfs/")
    private String localStoreDirectory = "/Users/zhangxiaorui/Desktop/";

    //@Value("${bufferSize}:1024")
    private int bufferSize = 1024;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestPart("file") MultipartFile multipartFile) {

        // 上传的文件判空
        if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            JSONObject json = new JSONObject();
            json.put("result", "failed");
            json.put("errMsg", "File is empty, maybe upload failed.");
            return json;
        }

        // 获取上传的用户token+文件名，作为新文件名保存在服务器文件系统上
        // TODO: 用户token
        String fileName = multipartFile.getOriginalFilename();
        // TODO: 文件的HashTag：Hash(原始文件名+上传人id) + 时间戳，作为储存在服务器的文件名
        String filePath = localStoreDirectory + fileName;

        JSONObject json = new JSONObject();
        // 保存文件
        try {
            IOUtilities.storeFile(multipartFile.getBytes(), filePath);
            json.put("result", "success");
        } catch (IOException e) {
            json.put("result", "failed");
            json.put("errMsg", e.getMessage());
        }

        // 删除临时文件
//        File f = new File(new File(filePath).toURI());
//        if (!f.delete()) {
//            json.put("result", "failed");
//            json.put("errMsg", "delete temporary file failed");
//        }

        return json;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject downloadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("hashtag") String hashtag) {
        JSONObject json = new JSONObject();
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
                // ContentType，即告诉客户端所发送的数据属于什么类型
                response.setContentType("image/jpeg; charset=UTF-8");
                // 获得文件的长度
                response.setHeader("Content-Length", String.valueOf(file.length()));
                // 设置编码格式
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
                // 发送给客户端的数据
                OutputStream outputStream = response.getOutputStream();
                byte[] buff = new byte[bufferSize];
                BufferedInputStream bis = null;
                // 读取文件
                bis = new BufferedInputStream(new FileInputStream(file));
                int i = bis.read(buff);
                // 只要能读到，则一直读取
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
