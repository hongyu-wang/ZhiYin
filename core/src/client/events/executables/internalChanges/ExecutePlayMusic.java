//package client.events.executables.internalChanges;
//
//import client.stateInterfaces.Executable;
//
///**
// * This class will check if
// * the current music is playing.
// *
// * Created by Hongyu Wang on 3/15/2016.
// */
//public class ExecutePlayMusic implements Executable{
//
//
//    @Override
//    public void execute() {
//        NowPlaying page = (NowPlaying) Pages.NOWPLAYING.getStateReference();
//        if (page.getMusic().isPlaying()){
//            page.getMusic().pause();
//            return;
//        }
//        page.getMusic().play();
//    }
//}
