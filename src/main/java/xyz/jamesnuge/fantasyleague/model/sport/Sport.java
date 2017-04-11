package xyz.jamesnuge.fantasyleague.model.sport;

import xyz.jamesnuge.fantasyleague.model.BaseModel;

import java.util.UUID;

/**
 * Created by james on 11/04/17.
 */
public class Sport extends BaseModel<UUID, SportId> {

    private final String name;

    public Sport(SportId id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
