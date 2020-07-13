package by.gsu.winter20.model.domain;

import lombok.*;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FacebookUser extends User {

    public FacebookUser(Integer id, String login, String facebookProfile, List<Role> role) {
        super(id, login, role);
        this.facebookProfile = facebookProfile;
    }

    private String facebookProfile;
}
