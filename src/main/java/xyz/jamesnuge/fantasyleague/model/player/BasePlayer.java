package xyz.jamesnuge.fantasyleague.model.player;

import xyz.jamesnuge.fantasyleague.model.BaseModel;
import xyz.jamesnuge.fantasyleague.model.player.position.Position;

import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class BasePlayer<T extends Position> extends BaseModel<UUID, PlayerId> implements Player<T> {

    private T position;

    public BasePlayer(PlayerId id, T position) {
        super(id);
        this.position = position;
    }

    public T getPosition() {
        return this.position;
    }
}
