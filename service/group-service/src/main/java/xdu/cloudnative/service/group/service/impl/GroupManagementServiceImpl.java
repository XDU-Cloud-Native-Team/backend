package xdu.cloudnative.service.group.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xdu.cloudnative.exception.*;
import xdu.cloudnative.model.authority.entity.User;
import xdu.cloudnative.model.authority.mapper.UserMapper;
import xdu.cloudnative.model.authority.service.UserService;
import xdu.cloudnative.model.group.entity.CoGroup;
import xdu.cloudnative.model.group.mapper.CoGroupMapper;
import xdu.cloudnative.model.group.service.CoGroupService;
import xdu.cloudnative.service.group.service.GroupManagementService;

/**
 * @author 邓乐丰@xduTD
 */
@Service
public class GroupManagementServiceImpl implements GroupManagementService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    CoGroupMapper coGroupMapper;
    @Autowired
    UserService userService;
    @Autowired
    CoGroupService coGroupService;

    @Override
    public String joinGroup(String userId, String inviteCode) throws UserNotExistsException, InviteCodeErrorException, UserInvalidStateException {
        User user = userMapper.selectById(Integer.parseInt(userId));
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
