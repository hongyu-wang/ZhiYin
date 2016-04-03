package tools.serverTools.generators;

import server.model.media.*;
import server.model.serverKey.MServerKey;
import server.model.social.*;
import server.model.soundCloud.MBand;
import server.model.soundCloud.MMusicAlbum;
import server.model.soundCloud.MMusicPost;
import server.model.soundCloud.MPlaylist;
import server.model.user.*;

import java.util.HashMap;
import java.util.Map;

/**Enum created to store identification tags for various models.
 *
 * Created by Kevin Zheng on 2016-03-11.
 */
public enum Tags {

    /**
     * Creates the id_tags map for all classes.
     */
    ID_TAGS();

    /**
     * The map of all tags.
     */
    private Map<String, Integer> ids;
    private Map<Integer, String> tags;
    private String[] classes;

    /**
     * Sets up the map with all tags.
     */
    Tags(){
        classes = new String[]{
                User.class.getName(),
                UserActivityLog.class.getName(),
                UserDiaryContent.class.getName(),
                UserConversations.class.getName(),
                UserProfile.class.getName(),
                UserUploadedContent.class.getName(),
                MBand.class.getName(),
                MMusicAlbum.class.getName(),
                MMusicPost.class.getName(),
                MPlaylist.class.getName(),
                MAudio.class.getName(),
                MHashtag.class.getName(),
                MImage.class.getName(),
                MMusic.class.getName(),
                MText.class.getName(),
                MComment.class.getName(),
                MConversation.class.getName(),
                MDiaryPost.class.getName(),
                MGenericPost.class.getName(),
                MGroup.class.getName(),
                MMessage.class.getName(),
                MPost.class.getName(),
                MServerKey.class.getName()
        };

        Map<Integer, String> tag = new HashMap<>();
        Map<String, Integer> id = new HashMap<>();
        for(int i = 0; i < classes.length; i++){
            id.put(classes[i], i);
            tag.put(i, classes[i]);
        }

        ids = id;
        tags = tag;
    }

    public String parseTag(String className){
        String tag = ids.get(className).toString();

        while(tag.length() < 4){
            tag = "0" + tag;
        }
        return tag;
    }

    /**Gets the related tag from the related classname.
     *
     * @param className
     * @return
     */
    public int getTag(String className){
        return ids.get(className);
    }

    public String getName(int tag){
        return tags.get(tag);
    }

}
