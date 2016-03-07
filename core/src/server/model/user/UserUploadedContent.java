package server.model.user;

import server.model.structureModels.ServerModel;

import java.util.List;

/**A model of all user uploaded content.
 *
 *      - MPost
 *      - MMusic
 *      - Annotation
 *      - MComment
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserUploadedContent extends ServerModel {
    List<Long> postKeys;

    /**Returns the service list of all keys to posts the user has uploaded.
     *
     * @return  The list of post keys.
     */
    public List<Long> getPostKeys(){
        return postKeys;
    }

    public void setPostKeys(List<Long> postKeys){
        this.postKeys = postKeys;
    }
}
