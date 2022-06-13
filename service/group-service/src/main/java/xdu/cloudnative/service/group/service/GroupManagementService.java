package xdu.cloudnative.service.group.service;

import xdu.cloudnative.exception.*;

/**
 * @author 邓乐丰@xduTD
 */
public interface GroupManagementService {

    /**
     * 用户加入组
     *
     * @param userId 用户ID
     * @param inviteCode 要加入的组的邀请码
     * @return 加入的组的组名
     * @throws UserNotExistsException 不存在该ID的用户
     * @throws InviteCodeErrorException 不存在该邀请码（邀请码错误）
     * @throws UserInvalidStateException 用户已经在一个组里
     */
    String joinGroup(String userId, String inviteCode) throws UserNotExistsException, InviteCodeErrorException, UserInvalidStateException;

    /**
     * 退出组
     *
     * @param userId 用户ID
     * @param groupId 组ID
     * @throws UserNotExistsException 不存在该ID的用户
     * @throws GroupNotExistsException 不存在该ID的组
     */
    void resignFromGroup(String userId, String groupId) throws UserNotExistsException, GroupNotExistsException;


    /**
     * 用户创建组
     *
     * @param userId
     * @param groupName
     * @return 组的邀请码（创建成功） / 建议可以使用的组名（创建失败）
     * @throws UserNotExistsException
     * @throws GroupNameConflictException
     */
    String createGroup(String userId, String groupName) throws UserNotExistsException, GroupNameConflictException;

    /**
     * 获得该用户所在组的邀请码，如果组没有邀请码
     * 就创建邀请码，如果组有邀请码就直接返回组的
     * 邀请码
     *-----------------------------------
     * update: 目前决定直接在创建组的时候为组生
     * 成邀请码，调用此方法的时候不需要申请新的邀
     * 请码，直接返回组邀请码即可
     *
     * @param userId
     * @return 邀请码
     * @throws UserNotExistsException
     * @throws UserInvalidStateException
     */
    String getInviteCode(String userId) throws UserNotExistsException, UserInvalidStateException;


    /**
     *
     * @param userId
     * @throws UserNotExistsException
     * @throws UserInvalidStateException
     */
    void disableInviteCode(String userId) throws UserNotExistsException, UserInvalidStateException;


}
