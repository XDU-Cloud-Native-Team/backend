package xdu.cloudnative.service.authority.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邓乐丰@xduTD
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInfo {

    String username;

    String password;

    String email;

    String phone;

}
