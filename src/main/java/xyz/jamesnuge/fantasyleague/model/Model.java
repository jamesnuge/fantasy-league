package xyz.jamesnuge.fantasyleague.model;

import xyz.jamesnuge.fantasyleague.model.id.Id;

import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public interface Model<K, T extends Id<K>> {
    T getId();
}
