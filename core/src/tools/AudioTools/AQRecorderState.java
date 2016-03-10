package tools.AudioTools;

/*<imports>*/
import java.util.Hashtable;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AQRecorderState/*</name>*/
        extends /*<extends>*/Struct<AQRecorderState>/*</extends>*/
    /*<implements>*//*</implements>*/ {

  protected static Hashtable<Integer, AudioRecorder> mAudioRecords = new Hashtable<>();
  protected static int mLastID = 0;

  /*<ptr>*/public static class AQRecorderStatePtr extends Ptr<AQRecorderState, AQRecorderStatePtr> {}/*</ptr>*/
  /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
  public AQRecorderState() {}
  public AQRecorderState(AudioRecorder ar)
  {
    this.mID(++mLastID);
    mAudioRecords.put(mID(), ar);
  }
  /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
  @StructMember(0) public native int mID();
  @StructMember(0) public native AQRecorderState mID(int mID);
    /*</members>*/
    /*<methods>*//*</methods>*/

  public AudioRecorder getRecord()
  {
    return mAudioRecords.get(mID());
  }

  public static void drop(int mStateID)
  {
    mAudioRecords.remove(mStateID);
  }
}