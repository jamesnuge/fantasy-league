package xyz.jamesnuge.fantasyleague.model.id;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class BaseId<K> implements Id<K> {

    @NotNull
    private K id;

    public BaseId(K id) {
        this.id = id;
    }

    public K getRawId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseId)) return false;

        BaseId baseId = (BaseId) o;

        return id != null ? id.equals(baseId.id) : baseId.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
