package xyz.jamesnuge.fantasyleague.model.sport.position;

import xyz.jamesnuge.fantasyleague.model.BaseModel;

import javax.validation.constraints.NotNull;

/**
 * Created by james on 9/04/17.
 */
public class Position extends BaseModel<Integer, PositionId> {

    private String name;

    public Position(@NotNull Integer id, @NotNull String name) {
        super(new PositionId(id));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
