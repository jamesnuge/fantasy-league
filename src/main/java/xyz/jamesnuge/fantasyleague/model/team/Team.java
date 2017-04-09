package xyz.jamesnuge.fantasyleague.model.team;

import xyz.jamesnuge.fantasyleague.model.player.PlayerId;
import xyz.jamesnuge.fantasyleague.model.user.UserId;
import xyz.jamesnuge.fantasyleague.model.user.UserModel;

import java.util.List;

/**
 * Created by james on 9/04/17.
 */
public class Team implements UserModel {

    private List<PlayerId> players;
    private UserId userId;

    public Team(List<PlayerId> players, UserId userId) {
        this.players = players;
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }

    public List<PlayerId> getPlayers() {
        return players;
    }
}
