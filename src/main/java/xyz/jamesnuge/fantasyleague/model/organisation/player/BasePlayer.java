package xyz.jamesnuge.fantasyleague.model.organisation.player;

import xyz.jamesnuge.fantasyleague.model.BaseModel;
import xyz.jamesnuge.fantasyleague.model.sport.position.Position;
import xyz.jamesnuge.fantasyleague.model.organisation.team.TeamId;
import xyz.jamesnuge.fantasyleague.model.organisation.team.TeamModel;

import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class BasePlayer<T extends Position> extends BaseModel<UUID, PlayerId> implements Player<T>, TeamModel {

    private final T position;
    private final TeamId teamId;

    public BasePlayer(PlayerId id, T position, TeamId teamId) {
        super(id);
        this.position = position;
        this.teamId = teamId;
    }

    public T getPosition() {
        return this.position;
    }

    public TeamId getTeamId() {
        return null;
    }
}
