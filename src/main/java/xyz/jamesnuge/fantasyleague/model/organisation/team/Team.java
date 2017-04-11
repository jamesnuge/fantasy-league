package xyz.jamesnuge.fantasyleague.model.organisation.team;

import xyz.jamesnuge.fantasyleague.model.BaseModel;
import xyz.jamesnuge.fantasyleague.model.organisation.OrganisationId;
import xyz.jamesnuge.fantasyleague.model.organisation.OrganisationModel;
import xyz.jamesnuge.fantasyleague.model.organisation.player.PlayerId;

import java.util.List;
import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class Team extends BaseModel<UUID, TeamId> implements OrganisationModel {

    private final List<PlayerId> players;
    private final OrganisationId organisationId;

    public Team(TeamId id, List<PlayerId> players, OrganisationId organisationId) {
        super(id);
        this.players = players;
        this.organisationId = organisationId;
    }

    public List<PlayerId> getPlayers() {
        return players;
    }

    public OrganisationId getOrganisationId() {
        return organisationId;
    }
}
