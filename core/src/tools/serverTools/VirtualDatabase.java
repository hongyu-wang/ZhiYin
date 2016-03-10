package tools.serverTools;

import server.model.structureModels.ServerModel;

import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-03-09.
 */
public class VirtualDatabase {
    Map<Long, Map<String, Long>> username_key;

    Map<Long, Map<Character, Object>> users;
    Map<Long, Map<Character, Object>> userProfiles;
    Map<Long, Map<Character, Object>> userConversations;
    Map<Long, Map<Character, Object>> userActivityLog;
    Map<Long, Map<Character, Object>> userUploadedContent;
    Map<Long, Map<Character, Object>> userDiaryContent;
}
