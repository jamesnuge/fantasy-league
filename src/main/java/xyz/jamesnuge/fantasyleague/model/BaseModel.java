package xyz.jamesnuge.fantasyleague.model;

import xyz.jamesnuge.fantasyleague.model.id.BaseId;

import java.util.UUID;

/**
 * Created by james on 9/04/17.d
 */
public class BaseModel<T, K extends BaseId<T>> implements Model<T, K> {

    private K id;

    public BaseModel(K id) {
        this.id = id;
    }

    public K getId() {
        return this.id;
    }
}
