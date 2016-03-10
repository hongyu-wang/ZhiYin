//package server.services.soundcloudService;
//
//
//import server.model.social.MPost;
//import server.model.soundCloud.MMusicPost;
//import server.services.socialService.PostManager;
//import server.services.socialService.PostManagerImplementation;
//import tools.Utils;
//
//import java.util.List;
//
///**
// * Created by Hairuo on 2016-03-09.
// */
//public class MusicPostManagerImplementation extends PostManagerImplementation implements MusicPostManager {
//
//
//    /**
//     * Retrieves a music post from the server
//     *
//     * @param key the key of the music post
//     * @return the corresponding music post
//     */
//    @Override
//    public MMusicPost getMusicPost(Long key) {
//        //Make this work
//        return null;
//    }
//
//    /**
//     * Create a new Music Post
//     *
//     * @param music     music piece that the post contains
//     * @param images    images that the post contains
//     * @param timestamp when the post was created
//     * @param text      description of the piece of music
//     * @param band      band of the musicians
//     * @param genre     genre of the music
//     * @param creator   creator of the post
//     * @return
//     */
//    @Override
//    public MMusicPost createPost(List<Long> music, List<Long> images, long timestamp, long text, long band, long genre, long creator) {
//        MMusicPost post = new MMusicPost();
//        post.setMusic(music);
//        post.setImages(images);
//        post.setComments(Utils.newList());
//        post.setTimeStamp(timestamp);
//        post.setText(text);
//        post.setCreator(creator);
//        post.setBand(band);
//        post.setGenre(genre);
//        return post;
//
//    }
//
//
//    /**
//     * Changes the genre of the post
//     *
//     * @param genre new genre
//     * @param post  post to be changed
//     * @return the edited post
//     */
//    @Override
//    public MMusicPost changeGenre(long genre, MMusicPost post) {
//        post.setGenre(genre);
//        return post;
//    }
//
//    /**
//     * Changes the genre of the post
//     *
//     * @param band new band
//     * @param post post to be changed
//     * @return the edited post
//     */
//    @Override
//    public MMusicPost changeBand(long band, MMusicPost post) {
//        post.setBand(band);
//        return post;
//    }
//}
