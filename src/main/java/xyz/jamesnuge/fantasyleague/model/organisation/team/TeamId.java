package xyz.jamesnuge.fantasyleague.model.organisation.team;

import xyz.jamesnuge.fantasyleague.model.id.BaseId;

import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class TeamId extends BaseId<UUID> {
    public TeamId(UUID id) {
        super(id);
    }
}
