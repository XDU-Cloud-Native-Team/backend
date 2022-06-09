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
public class User {

    Integer userId;

    String username;

    String password;

    String email;

    Integer groupId;

}