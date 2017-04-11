package xyz.jamesnuge.fantasyleague.model.sport;

import xyz.jamesnuge.fantasyleague.model.id.BaseId;

import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class SportId extends BaseId<UUID> {

    public SportId(UUID id) {
        super(id);
    }

}
