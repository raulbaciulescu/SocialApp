package com.example.socialapp.utils;

public class Constants {
    public final static class Db {
        public static final String DB_USER = "postgres";
        public static final String DB_PASSWORD = "266259";
        public static final String DB_URL = "jdbc:postgresql://localhost:5432/meta";
    }

    public enum Tables {
        USERS,
        FRIENDSHIPS,
        LOGIN,
        REQUESTS
    }

    public final static class Scene {
        public final static String LOG_IN = "login-view.fxml";
        public final static String REGISTER = "register-view.fxml";
        public final static String MAIN_FEED = "main-feed-view.fxml";
        public final static String REQUESTS = "requests-view.fxml";
        public final static String SEARCH = "search-view.fxml";
    }
}
