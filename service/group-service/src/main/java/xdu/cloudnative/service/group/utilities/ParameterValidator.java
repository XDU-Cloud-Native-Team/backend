package xdu.cloudnative.service.group.utilities;

/**
 * @author 邓乐丰@xduTD
 */
public class ParameterValidator {

    /**
     * 验证邮箱地址是否正确
     * @param emailAddress 用户邮箱地址
     * @return true/false
     */
    public static boolean isValidEmailAddress(String emailAddress) {
        // 用于验证邮箱的正则表达式
        String emailRegex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

        emailAddress = emailAddress.trim();
        return emailAddress.matches(emailRegex);
    }

    /**
     * 验证用户输入的userId是否符合用户ID的格式
     * @param userId 用户ID
     * @return true/false
     */
    public static boolean isValidUserId(String userId) {
        return false;
    }

    /**
     * 验证用户输入的inviteCode是否符合邀请码格式
     * @return
     */
    public static boolean isValidInviteCode() {
        return false;
    }


}
