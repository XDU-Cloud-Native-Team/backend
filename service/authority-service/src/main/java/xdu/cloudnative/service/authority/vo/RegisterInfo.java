package xdu.cloudnative.service.authority.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author 邓乐丰@xduTD
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInfo {

    @NotBlank(message = "username cannot be empty")
    String username;

    @NotNull(message = "password cannot be empty")
    String password;

    @Email(message = "invalid email address")
    String email;

    @NotBlank(message = "phone number cannot be empty")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "invalid telephone number")
    String phone;

}
