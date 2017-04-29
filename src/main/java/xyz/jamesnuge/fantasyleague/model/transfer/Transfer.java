package xyz.jamesnuge.fantasyleague.model.transfer;

import xyz.jamesnuge.fantasyleague.model.organisation.player.PlayerId;
import xyz.jamesnuge.fantasyleague.model.user.team.SelectedTeamId;
import xyz.jamesnuge.fantasyleague.model.user.team.SelectedTeamModel;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

/**
 * Created by james on 11/04/17.
 */
public class Transfer implements SelectedTeamModel {
   private final SelectedTeamId selectedTeamId;
   private final List<PlayerId> added;
   private final List<PlayerId> removed;
   private final Instant time;

   public Transfer(@NotNull SelectedTeamId selectedTeamId, @NotNull List<PlayerId> added, @NotNull List<PlayerId> removed, @NotNull Instant time) {
      this.selectedTeamId = selectedTeamId;
      this.added = added;
      this.removed = removed;
      this.time = time;
   }

   public SelectedTeamId getSelectedTeamId() {
      return null;
   }
}
