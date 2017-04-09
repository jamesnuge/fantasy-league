package xyz.jamesnuge.fantasyleague.mapper;

import xyz.jamesnuge.fantasyleague.model.user.UserId;
import xyz.jamesnuge.fantasyleague.model.user.UserModel;

import java.util.Collection;

/**
 * Created by james on 9/04/17.
 */
public interface UserModelMapper<M extends UserModel> {
    Collection<M> getByUserId(UserId userId);
}
