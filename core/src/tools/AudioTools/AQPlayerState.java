//package tools.AudioTools;
//
//
//
///*<imports>*/
//
//import java.util.Hashtable;
//import server.model.media.MAudio;
//import org.robovm.rt.bro.*;
//import org.robovm.rt.bro.annotation.*;
//import org.robovm.rt.bro.ptr.*;
///*</imports>*/
//
///*<javadoc>*/
//
///*</javadoc>*/
///*<annotations>*//*</annotations>*/
///*<visibility>*/public/*</visibility>*/ class /*<name>*/AQPlayerState/*</name>*/
//        extends /*<extends>*/Struct<AQPlayerState>/*</extends>*/
//    /*<implements>*//*</implements>*/ {
//
//  protected static Hashtable<Integer, MAudio> mAudioTracks = new Hashtable<>();
//  protected static int mLastID = 0;
//
//  /*<ptr>*/public static class AQPlayerStatePtr extends Ptr<AQPlayerState, AQPlayerStatePtr> {}/*</ptr>*/
//  /*<bind>*/
//    /*</bind>*/
//    /*<constants>*//*</constants>*/
//    /*<constructors>*/
//  public AQPlayerState() {}
//  public AQPlayerState(MAudio ar)
//  {
//    this.mID(++mLastID);
//    this.mID2(mLastID);
//    mAudioTracks.put(mID(), ar);
//  }
//  /*</constructors>*/
//    /*<properties>*//*</properties>*/
//    /*<members>*/
//  @StructMember(0) public native int mID();
//  @StructMember(0) public native AQPlayerState mID(int mID);
//  @StructMember(1) public native int mID2();
//  @StructMember(1) public native AQPlayerState mID2(int mID2);
//    /*</members>*/
//    /*<methods>*//*</methods>*/
//
//  public MAudio getTrack()
//  {
//    return mAudioTracks.get(mID());
//  }
//
//  public static void drop(int mStateID)
//  {
//    mAudioTracks.remove(mStateID);
//  }
//}