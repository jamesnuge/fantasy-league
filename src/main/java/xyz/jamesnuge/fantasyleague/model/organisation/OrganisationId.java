package xyz.jamesnuge.fantasyleague.model.organisation;

import xyz.jamesnuge.fantasyleague.model.id.BaseId;

import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class OrganisationId extends BaseId<UUID> {

    public OrganisationId(UUID id) {
        super(id);
    }

}
