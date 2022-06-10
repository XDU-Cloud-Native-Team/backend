package xdu.cloudnative.service.authority.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xdu.cloudnative.service.authority.exception.InviteCodeErrorException;
import xdu.cloudnative.service.authority.exception.UserNotExistsException;
import xdu.cloudnative.service.authority.service.GroupService;

/**
 * @author 邓乐丰@xduTD
 */
@RestController
public class GroupController {
    /** 用户ID的长度 */
    static final int USER_ID_LEN = 11;
    /** 组邀请码的长度 */
    static final int INVITE_CODE_LEN = 15;

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject joinGroup(@RequestParam(value = "invite_code") String inviteCode, @RequestParam(value = "user_id") String userId) {
        JSONObject json = new JSONObject();

        // 验证参数是否合法
        userId = userId.trim();
        if (userId.length() != USER_ID_LEN) {
            json.put("result", "failed");
            json.put("errMsg", "invalid user id, ckeck the length of your id");
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
        } catch (InviteCodeErrorException | UserNotExistsException e) {
            json.put("result", "failed");
            json.put("errMsg", e.getMessage());
        }

        return json;
    }


    public JSONObject generateInviteCode(@RequestParam(value = "user_id") String userId) {
        JSONObject json = new JSONObject();

        //if ()
        return null;
    }

}
