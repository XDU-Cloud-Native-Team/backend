package xdu.cloudnative.model.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author 邓乐丰@xduTD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    /** PRIMARY KEY */
    String hashtag;

    String filename;

    Integer user_id;

    Integer group_id;

    Integer size;

    Timestamp create_time;

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
