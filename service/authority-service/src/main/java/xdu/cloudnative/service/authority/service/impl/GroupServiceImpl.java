package xdu.cloudnative.service.authority.service.impl;

import org.springframework.stereotype.Service;
import xdu.cloudnative.service.authority.exception.InviteCodeErrorException;
import xdu.cloudnative.service.authority.exception.UserNotExistsException;
import xdu.cloudnative.service.authority.service.GroupService;

/**
 * @author Lenovo
 */
@Service("GroupServiceImpl")
public class GroupServiceImpl implements GroupService {

    /**
     * 用户加入组
     *
     * @param userId     用户ID
     * @param inviteCode 该组的邀请码
     * @return 组名
     */
    @Override
    public String joinGroup(String userId, String inviteCode) throws UserNotExistsException, InviteCodeErrorException {
        return null;
    }
}
