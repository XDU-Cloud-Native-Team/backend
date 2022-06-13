package xdu.cloudnative.service.group.utilities;

import java.util.Random;

/**
 * @author 邓乐丰@xduTD
 */
public class RandomGenerator {

    /** 用于随机的字符源 */
    static final String CHAR_SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    /** 随机源 */
    static final Random random = new Random();
    /** 邀请码长度（限制：不超过20个字符） */
    static final int INVITE_CODE_LEN = 15;

    /**
     * 生成随机邀请码
     *
     * @return inviteCode 邀请码
     */
    public static String generateInviteCode() {
        StringBuffer sb = new StringBuffer();

        // 通过随机数来将字符源的某个字符（随机）添加到邀请码中
        for (int i = 0; i < INVITE_CODE_LEN; i++) {
            sb.append(CHAR_SOURCE.charAt(random.nextInt(CHAR_SOURCE.length())));
        }

        return sb.toString();
    }

}
