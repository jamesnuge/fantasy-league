package xyz.jamesnuge.fantasyleague.guice.mybatis;

import java.net.URI;


/**
 * Created by james on 11/04/17.
 */
public class JdbcUtil {

    public static final String JDBC_POSTGRESQL_URL_PREFIX = "jdbc:postgresql://";
    public static final char JDBC_URL_SEPARATOR = ':';

    

    private JdbcUtil(){}

    public static final String getRawJDBCUrlFromUri(URI uri) {
        return JDBC_POSTGRESQL_URL_PREFIX + uri.getHost() + JDBC_URL_SEPARATOR + uri.getPort() + uri.getPath() ;
    }
}
