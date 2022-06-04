package xdu.cloudnative.service.file.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class FileTransportController {

    @Value("/mnt/myjfs/")
    private String uploadedFileDirectory;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestPart("file") MultipartFile multipartFile) {
        String result = "failed";
        String errorMsg = "";

        // 上传的文件判空
        if (StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            JSONObject json = new JSONObject();
            errorMsg = "File is empty, maybe upload failed.";
            json.put("result", result);
            json.put("errMsg", errorMsg);
            return json;
        }

        // 获取上传的用户token+文件名，作为新文件名保存在服务器文件系统上
        // TODO: 用户token
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(uploadedFileDirectory + fileName);

        // 保存文件
        OutputStream out = null;
        try{
            //获取文件流，以文件流的方式输出到新文件
            out = new FileOutputStream(file);
            byte[] ss = multipartFile.getBytes();
            for(int i = 0; i < ss.length; i++){
                out.write(ss[i]);
            }
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        JSONObject json = new JSONObject();

        // 删除临时文件
        File f = new File(file.toURI());
        if (f.delete()){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        return json;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public String downloadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("hashtag") String hashtag) {


        return "failed";
    }
}
