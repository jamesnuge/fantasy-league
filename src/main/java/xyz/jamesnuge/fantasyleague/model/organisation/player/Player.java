package xyz.jamesnuge.fantasyleague.model.organisation.player;

import xyz.jamesnuge.fantasyleague.model.sport.position.Position;

/**
 * Created by james on 9/04/17.
 */
public interface Player<T extends Position> {
    T getPosition();
}
