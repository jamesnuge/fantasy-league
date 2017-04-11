package xyz.jamesnuge.fantasyleague.model.user.team;

import xyz.jamesnuge.fantasyleague.model.BaseModel;
import xyz.jamesnuge.fantasyleague.model.organisation.player.PlayerId;
import xyz.jamesnuge.fantasyleague.model.user.UserId;
import xyz.jamesnuge.fantasyleague.model.user.UserModel;

import java.util.List;
import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class SelectedTeam extends BaseModel<UUID, SelectedTeamId> implements UserModel{

    private final List<PlayerId> players;
    private final UserId owner;

    public SelectedTeam(SelectedTeamId id, List<PlayerId> players, UserId owner) {
        super(id);
        this.players = players;
        this.owner = owner;
    }

    public UserId getUserId() {
        return owner;
    }

    public List<PlayerId> getPlayers() {
        return players;
    }
}
