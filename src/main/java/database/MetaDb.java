package database;

import com.example.socialapp.domain.Friendship;
import database.table.FriendshipTable;
import database.table.Table;
import database.table.UserTable;
import utils.Constants;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MetaDb {
    private static MetaDb instance = null;
    private PostgresConnector connector;
    private Map<Constants.Tables, Table> tables;
    Connection connection;

    private MetaDb() throws SQLException {
        tables = new HashMap<>();
        connector = new PostgresConnector(Constants.Db.DB_URL);
        connection = connector.connect(Constants.Db.DB_USER, Constants.Db.DB_PASSWORD);
        initTables();
    }

    private void initTables() throws SQLException {
        tables.put(Constants.Tables.USERS, new UserTable(connection));
        tables.put(Constants.Tables.FRIENDSHIPS, new FriendshipTable(connection));
    }


    public static MetaDb getInstance() throws SQLException {
        if (instance == null)
            instance = new MetaDb();
        return instance;
    }

    public Table<?, ?> table(final Constants.Tables tableName) {
        return tables.get(tableName);
    }
}
