package xyz.jamesnuge.fantasyleague.model.organisation;

import xyz.jamesnuge.fantasyleague.model.BaseModel;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class Organisation extends BaseModel<UUID, OrganisationId> {

    private final String name;

    public Organisation(@NotNull OrganisationId id, @NotNull String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
