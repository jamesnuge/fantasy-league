package xyz.jamesnuge.fantasyleague.model.player;

import xyz.jamesnuge.fantasyleague.model.id.BaseId;

import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class PlayerId extends BaseId<UUID> {
    public PlayerId(UUID id) {
        super(id);
    }
}
