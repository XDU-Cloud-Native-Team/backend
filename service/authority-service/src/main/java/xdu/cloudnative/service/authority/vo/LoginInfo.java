package xdu.cloudnative.service.authority.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author 邓乐丰@xduTD
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {

    @NotBlank(message = "username cannot be empty")
    String username;

    @NotBlank(message = "password cannot be empty")
    String password;

}
