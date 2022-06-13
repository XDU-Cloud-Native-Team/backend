package xdu.cloudnative.model.group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邓乐丰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoGroup {

    Integer id;

    String name;

    String inviteCode;

}
