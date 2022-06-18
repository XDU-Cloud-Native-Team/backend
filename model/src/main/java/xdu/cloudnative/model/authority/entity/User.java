package xdu.cloudnative.model.authority.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author 邓乐丰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User {
    @TableId(type = IdType.AUTO, value = "id")
    Integer id;

    @TableField(value = "username")
    @NotBlank(message = "username cannot be empty")
    String username;

    @TableField(value = "password")
    @NotNull(message = "password cannot be empty")
    String password;

    @TableField(value = "email")
    @Email(message = "invalid email address")
    String email;

    @TableField(value = "phone")
    @NotBlank(message = "phone number cannot be empty")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "invalid telephone number")
    String phone;

    @TableField(value = "group_id")
    @Range(min = 1L, max = 9999999L)
    Integer groupId;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

}