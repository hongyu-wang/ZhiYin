package client.events.executables.internalChanges.serverInteractions;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import server.model.soundCloud.MBand;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecuteUnFollowArtist implements ExecuteServer {
    private long mBand;
    private List<Long> currentArtists;
    private Table table;

    public ExecuteUnFollowArtist(Table table, MBand mBand, List<Long> currentArtists) {
        this.currentArtists = currentArtists;
        this.mBand = mBand.getKey();
        this.table = table;
    }

    @Override
    public void execute() {
        User user = this.localDatabase.getMainUser();

        user.getBandKeys().remove(mBand);

        currentArtists.clear();
        table.reset();

        List<ServerModel> pushList = Utils.newList();
        pushList.add(user);
        localDatabase.pushModel(pushList);
    }
}
