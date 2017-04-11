package xyz.jamesnuge.fantasyleague.guice.mybatis;

import java.net.URI;


/**
 * Created by james on 11/04/17.
 */
public class JdbcUtil {

    public static final String JDBC_POSTGRESQL_URL_PREFIX = "jdbc:postgresql://";
    public static final char JDBC_URL_SEPARATOR_CHAR = ':';
    public static final String JDBC_URL_SEPARATOR_STRING = ":";
    
    public static final String JDBC_DRIVER_INJECTION_NAME = "JDBC.driver";
    public static final String JDBC_URL_INJECTION_NAME = "JDBC.url";
    public static final String JDBC_USERNAME_INJECTION_NAME = "JDBC.username";
    public static final String JDBC_PASSWORD_INJECTION_NAME = "JDBC.password";
    public static final String JDBC_AUTO_COMMIT_INJECTION_NAME = "JDBC.autoCommit";

    private JdbcUtil(){}

    public static final String getRawJDBCUrlFromUri(URI uri) {
        return JDBC_POSTGRESQL_URL_PREFIX + uri.getHost() + JDBC_URL_SEPARATOR_CHAR + uri.getPort() + uri.getPath() ;
    }
}
