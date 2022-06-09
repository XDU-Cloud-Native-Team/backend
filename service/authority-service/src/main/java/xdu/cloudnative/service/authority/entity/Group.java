package xdu.cloudnative.service.authority.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邓乐丰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    Integer groupId;

    String groupName;

    String inviteCode;

}
