package by.gsu.winter20.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Role implements IEntity {

    private Integer id;
    private String name;
}
