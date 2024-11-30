package top.soft.classoa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private long UserId;
    private String username;
    private String password;
    private long employeeId;
    private Integer salt;
}
