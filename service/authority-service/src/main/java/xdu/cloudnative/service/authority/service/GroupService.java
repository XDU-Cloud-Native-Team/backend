package xdu.cloudnative.service.authority.service;

import org.springframework.stereotype.Service;
import xdu.cloudnative.service.authority.exception.InviteCodeErrorException;
import xdu.cloudnative.service.authority.exception.UserNotExistsException;


/**
 * @author 邓乐丰@xduTD
 */
public interface GroupService {

    /**
     * 用户加入组
     *
     * @param userId 用户ID
     * @param inviteCode 要加入的组的邀请码
     * @return 加入的组的组名
     * @throws UserNotExistsException 不存在该ID的用户
     * @throws InviteCodeErrorException 不存在该邀请码（邀请码错误）
     */
    String joinGroup(String userId, String inviteCode) throws UserNotExistsException, InviteCodeErrorException;



}
