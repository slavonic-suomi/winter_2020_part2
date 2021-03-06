package by.gsu.winter20.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements IEntity {
    @JsonIgnore
    private Integer id;

    @JsonProperty("name")
    private String login;
    private List<Role> role;
}
