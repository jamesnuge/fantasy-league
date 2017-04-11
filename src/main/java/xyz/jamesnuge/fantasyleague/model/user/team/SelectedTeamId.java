package xyz.jamesnuge.fantasyleague.model.user.team;

import xyz.jamesnuge.fantasyleague.model.id.BaseId;

import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class SelectedTeamId extends BaseId<UUID> {
    public SelectedTeamId(UUID id) {
        super(id);
    }
}
