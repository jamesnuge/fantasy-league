package xyz.jamesnuge.fantasyleague.model.player;

import xyz.jamesnuge.fantasyleague.model.player.position.Position;

import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public interface Player<T extends Position> {
    T getPosition();
}
