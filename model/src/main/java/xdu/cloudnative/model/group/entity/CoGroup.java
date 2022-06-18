package xdu.cloudnative.model.group.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 邓乐丰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "co_group")
public class CoGroup {

    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    Integer id;

    @TableField(value = "name")
    String name;

    @TableField(value = "invite_code")
    String inviteCode;

    @TableField(value = "founder")
    Integer founder;

}
