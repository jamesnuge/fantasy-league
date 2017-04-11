package xyz.jamesnuge.fantasyleague.model.organisation;

import xyz.jamesnuge.fantasyleague.model.BaseModel;

import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class Organisation extends BaseModel<UUID, OrganisationId> {

    private final String name;

    public Organisation(OrganisationId id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
