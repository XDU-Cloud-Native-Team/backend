package xdu.cloudnative.service.group.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xdu.cloudnative.service.group.service.GroupManagementService;
import xdu.cloudnative.exception.*;

/**
 * @author 邓乐丰@xduTD
 */
@CrossOrigin
@RestController
public class GroupManagementController {
    /** 用户ID的长度 */
    static final int USER_ID_LEN = 11;
    /** 组邀请码的长度 */
    static final int INVITE_CODE_LEN = 15;

    @Autowired
    GroupManagementService groupService;

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject joinGroup(@RequestParam(value = "invite_code") String inviteCode, @RequestParam(value = "user_id") String userId) {
        JSONObject json = new JSONObject();

        // 验证参数是否合法
        userId = userId.trim();
        if (userId.length() != USER_ID_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid user id, check the length of your id");
            return json;
        }
        inviteCode = inviteCode.trim();
        if (inviteCode.length() != INVITE_CODE_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid invite code");
            return json;
        }

        try {
            String groupName = groupService.joinGroup(userId, inviteCode);
            json.put("result", "success");
            json.put("msg", "You've joined in group: " + groupName);
        } catch (InviteCodeErrorException | UserNotExistsException | UserInvalidStateException e) {
            json.put("result", "failed");
            json.put("errMsg", e.getMessage());
        }

        return json;
    }

    @RequestMapping(value = "/resign")
    @ResponseBody
    public JSONObject resign(@RequestParam(value = "userId") String userId, @RequestParam(value = "group_id") String groupId) {
        JSONObject json = new JSONObject();

        // 验证参数是否合法
        userId = userId.trim();
        if (userId.length() != USER_ID_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid user id, check the length of your id");
            return json;
        }

        // todo: coding

        return json;
    }

    @RequestMapping(value = "/invite_code", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getInviteCode(@RequestParam(value = "user_id") String userId) {
        JSONObject json = new JSONObject();

        // 验证参数是否合法
        userId = userId.trim();
        if (userId.length() != USER_ID_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid user id, check the length of your id");
            return json;
        }

        try {
            json.put("inviteCode", groupService.getInviteCode(userId));
            json.put("result", "success");
        } catch (UserInvalidStateException | UserNotExistsException e) {
            json.put("result", "failed");
            json.put("errMsg", e.getMessage());
        }

        return json;
    }

}
