package xdu.cloudnative.model.file.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

/**
 * @author 邓乐丰@xduTD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "file")
public class File {

    /** PRIMARY KEY */
    @TableField(value = "hashtag")
    String hashtag;

    @TableField(value = "filename")
    @NotBlank(message = "file name cannot be empty")
    String filename;

    @TableField(value = "user_id")
    Integer user_id;

    @TableField(value = "group_id")
    Integer group_id;

    @TableField(value = "size")
    Integer size;

    @TableField(value = "create_time")
    Timestamp create_time;

    @TableField(value = "visibility")
    Integer visibility;

    public void setCreateTime(Timestamp createTime) {
        create_time = createTime;
    }

    public Timestamp getCreateTime() {
        return create_time;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setGroupId(int groupId) {
        this.group_id = groupId;
    }

    public Integer getGroupId() {
        return group_id;
    }
}
