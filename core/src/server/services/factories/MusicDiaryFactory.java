package server.services.factories;

import server.services.implementations.diaryService.MusicDiaryImplementation;
import server.services.interfaces.models.MusicDiary;

/**
 * @author rsang
 */
public class MusicDiaryFactory {

    private static MusicDiary MusicDiary;

    public static MusicDiary createMusicDiary() {
        if (MusicDiary == null) {
            MusicDiary  = new MusicDiaryImplementation();
        }
        return MusicDiary;
    }

    private MusicDiaryFactory(){}

}
