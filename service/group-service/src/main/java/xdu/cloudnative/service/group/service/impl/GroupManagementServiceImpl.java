package xdu.cloudnative.service.group.service.impl;

import org.springframework.stereotype.Service;
import xdu.cloudnative.exception.*;
import xdu.cloudnative.service.group.service.GroupManagementService;

/**
 * @author 邓乐丰@xduTD
 */
@Service
public class GroupManagementServiceImpl implements GroupManagementService {

    @Override
    public String joinGroup(String userId, String inviteCode) throws UserNotExistsException, InviteCodeErrorException, UserInvalidStateException {
        return null;
    }

    @Override
    public void resignFromGroup(String userId, String groupId) throws UserNotExistsException, GroupNotExistsException {

    }

    @Override
    public String createGroup(String userId, String groupName) throws UserNotExistsException, GroupNameConflictException {
        return null;
    }

    @Override
    public String getInviteCode(String userId) throws UserNotExistsException, UserInvalidStateException {
        return null;
    }

    @Override
    public void disableInviteCode(String userId) throws UserNotExistsException, UserInvalidStateException {

    }
}
