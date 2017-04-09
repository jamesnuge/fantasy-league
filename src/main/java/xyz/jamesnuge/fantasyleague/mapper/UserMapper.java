package xyz.jamesnuge.fantasyleague.mapper;

import xyz.jamesnuge.fantasyleague.model.user.User;
import xyz.jamesnuge.fantasyleague.model.user.UserId;

import java.util.UUID;

/**
 * Created by james on 10/04/17.
 */
public interface UserMapper extends Mapper<UUID, UserId, User>{
    User getByEmail(String email);
}
