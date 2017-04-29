package xyz.jamesnuge.fantasyleague.model.organisation.player;

import xyz.jamesnuge.fantasyleague.model.BaseModel;
import xyz.jamesnuge.fantasyleague.model.sport.position.Position;
import xyz.jamesnuge.fantasyleague.model.organisation.team.TeamId;
import xyz.jamesnuge.fantasyleague.model.organisation.team.TeamModel;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class Player<T extends Position> extends BaseModel<UUID, PlayerId> implements TeamModel {

    private final T position;
    private final TeamId teamId;
    private final String firstName;
    private final String lastName;

    public Player(@NotNull PlayerId id, @NotNull T position, @NotNull TeamId teamId, @NotNull String firstName, @NotNull String lastName) {
        super(id);
        this.position = position;
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public T getPosition() {
        return this.position;
    }

    public TeamId getTeamId() {
        return teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
