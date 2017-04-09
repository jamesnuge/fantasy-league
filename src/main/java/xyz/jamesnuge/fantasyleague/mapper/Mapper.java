package xyz.jamesnuge.fantasyleague.mapper;

import xyz.jamesnuge.fantasyleague.model.Model;
import xyz.jamesnuge.fantasyleague.model.id.Id;

/**
 * Created by james on 9/04/17.
 */
public interface Mapper<K, T extends Id<K>, M extends Model<K, T>> {
    M getById(T id);
}
