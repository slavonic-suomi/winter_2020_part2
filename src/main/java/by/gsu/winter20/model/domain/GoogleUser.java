package by.gsu.winter20.model.domain;

import lombok.*;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GoogleUser extends User {

    public GoogleUser(Integer id, String login, String googleUid, List<Role> role) {
        super(id, login, role);
        this.googleUid = googleUid;
    }

    private String googleUid;
}
