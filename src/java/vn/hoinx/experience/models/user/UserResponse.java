package vn.hoinx.experience.models.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String name;
    private String avatarUrl;
    private String phoneNumber;
    private String jidBare;
    private String jidResource;
    private String jid;
}
