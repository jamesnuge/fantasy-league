package xyz.jamesnuge.fantasyleague.model.player.position;

import xyz.jamesnuge.fantasyleague.model.BaseModel;

import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class Position extends BaseModel<Integer, PositionId> {

    private String name;

    public Position(Integer id, String name) {
        super(new PositionId(id));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
