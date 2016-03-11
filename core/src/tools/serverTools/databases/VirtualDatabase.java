package tools.serverTools.databases;

/**
 * A database of server models, and model attributes.
 *
 * Each table maps a key Long to either a ServerModel, or a basic data type.
 * Models in turn have keys. These new keys should be plugged into other tables
 * to fully construct a complex server model's total information network.
 *
 * Created by Kevin Zheng on 2016-03-10.
 */
public interface VirtualDatabase {
    /**
     * Initializes the database and all its required data.
     */
    void init();

    /**
     *
     */

}
