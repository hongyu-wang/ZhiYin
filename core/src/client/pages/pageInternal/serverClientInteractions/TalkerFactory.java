package client.pages.pageInternal.serverClientInteractions;

/**
 * Created by Hongyu Wang on 3/22/2016.
 */
public class TalkerFactory {
    private static final int numberOfTalkers = 8;
    private static Talkers [] talkers = new Talkers[numberOfTalkers];
//    public static DiaryTalker getDiaryTalker(){
//        if (talkers[0] == null)
//            talkers[0] = new DiaryTalker();
//
//
//        return (DiaryTalker) talkers[0];
//    }

    public static FriendTalker getFriendTalker(){
        if (talkers[1] == null)
            talkers[1] = new FriendTalker();

        return (FriendTalker) talkers[1];
    }

    public static ConversationTalker getMessagesTalker(){
        if (talkers[2] == null)
            talkers[2] = new ConversationTalker();

        return (ConversationTalker) talkers[2];
    }

//    public static MusicTalker getMusicTalker(){
//        if (talkers[3] == null)
//            talkers[3] = new MusicTalker();
//
//        return (MusicTalker) talkers[3];
//    }

    public static ProfileTalker getProfileTalker(){
        if (talkers[4] == null)
            talkers[4] = new ProfileTalker();

        return (ProfileTalker) talkers[4];
    }
    public static SocialContentTalker getSocialContentTalker(){
        if (talkers[5] == null)
            talkers[5] = new SocialContentTalker();

        return (SocialContentTalker) talkers[5];
    }
    public static VeryBeginningInitializer VeryBeginningInitializer(){
        if (talkers[6] == null)
            talkers[6] = new VeryBeginningInitializer();

        return (VeryBeginningInitializer) talkers[6];
    }
    public static ServerTalker getServerTalker(){
        if (talkers[7] == null)
            talkers[7] = new ServerTalker();

        return (ServerTalker) talkers[7];
    }
}
