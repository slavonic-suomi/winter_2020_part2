package by.gsu.winter20.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class User {
    @JsonIgnore
    private Integer id;

    @JsonProperty("name")
    private String login;
    private Role role;
}
