package xdu.cloudnative.service.file.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xdu.cloudnative.exception.FileNotExistsException;
import xdu.cloudnative.exception.UserNotExistsException;
import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.model.authority.service.UserService;
import xdu.cloudnative.model.file.entity.File;
import xdu.cloudnative.model.group.service.CoGroupService;
import xdu.cloudnative.service.file.service.FileManagementService;

import java.util.List;

/**
 * @author 邓乐丰@xduTD
 */
@CrossOrigin
@RestController
public class FileManageController {
    /** 用户ID的长度 */
    static final int USER_ID_LEN = 11;

    @Autowired
    UserService userService;
    @Autowired
    CoGroupService coGroupService;
    @Autowired
    FileManagementService fileManageService;

    @RequestMapping(value = "/visibleFiles", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getVisibleFileList(@RequestBody String userId) {
        JSONObject json = new JSONObject();
        JSONObject data = new JSONObject();

        // 验证参数是否合法
        userId = userId.trim();
        if (userId.length() != USER_ID_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid user id, check the length of your id");
            return json;
        }

        User user = userService.getById(Integer.parseInt(userId));
        // 如果用户在一个组内，则组内成员上传的文件都可见
        if (user.getGroupId() != null && coGroupService.getById(user.getGroupId()) != null) {
            // TODO: 目前没有组，先不做这个东西
            System.out.println("not finish yet");
        } else {
            // 用户不属于任何组，仅可见自己上传的文件
            // TODO: 还有文件的可见性等级，需要进行判断
            List<File> fileList = fileManageService.getPrivateFileList(userId);
            data.put("files", fileList);
            data.put("username", user.getUsername());
            json.put("result", "success");
            json.put("data", data);
        }

        return json;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteFile(@RequestParam("userId") String userId, @RequestParam("hashtag") String hashtag) {
        JSONObject json = new JSONObject();

        // 验证参数是否合法
        userId = userId.trim();
        if (userId.length() != USER_ID_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid user id, check the length of your id");
            return json;
        }
        if (hashtag == null) {
            json.put("result", "failed");
            json.put("errMsg", "no file selected");
            return json;
        }

        try {
            fileManageService.deleteFile(userId, hashtag);
            json.put("result", "success");
        } catch (UserNotExistsException | FileNotExistsException e) {
            json.put("result", "failed");
            json.put("errMsg", e.getMessage());
        }

        return json;
    }

}
