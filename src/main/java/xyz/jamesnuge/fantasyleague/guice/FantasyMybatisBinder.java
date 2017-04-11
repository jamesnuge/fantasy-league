package xyz.jamesnuge.fantasyleague.guice;

import com.google.inject.name.Names;
import org.mybatis.guice.MyBatisModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.jamesnuge.fantasyleague.guice.mybatis.JdbcUtil;
import xyz.jamesnuge.fantasyleague.util.environment.EnvironmentVariableLoader;

import java.net.URI;
import java.net.URISyntaxException;

import static xyz.jamesnuge.fantasyleague.guice.mybatis.JdbcUtil.JDBC_POSTGRESQL_URL_PREFIX;
import static xyz.jamesnuge.fantasyleague.guice.mybatis.JdbcUtil.JDBC_URL_SEPARATOR;

/**
 * Created by james on 11/04/17.
 */
public class FantasyMybatisBinder extends MyBatisModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(FantasyMybatisBinder.class);

    private final EnvironmentVariableLoader environmentVariableLoader;
    private final URI databaseUri;
    private final String rawJdbcUrl;

    private final Boolean isProduction;

    public FantasyMybatisBinder(EnvironmentVariableLoader environmentVariableLoader) throws Exception {
        this.environmentVariableLoader = environmentVariableLoader;
        this.isProduction = environmentVariableLoader.environmentVariableisPresent("environment") ? environmentVariableLoader.environmentVariableisPresent("environment") : false;
        if (environmentVariableLoader.environmentVariableisPresent(MybatisGuiceUtil.DATABASE_URL_KEY)) {
            databaseUri = new URI(environmentVariableLoader.getEnvironmentVariable(MybatisGuiceUtil.DATABASE_URL_KEY));
            rawJdbcUrl = JdbcUtil.getRawJDBCUrlFromUri(databaseUri);
        } else {
            databaseUri = null;
            rawJdbcUrl = null;
            LOGGER.error("Database URL not set - Cannot initialize Mybatis");
        }
    }

    protected void initialize() {

        if (environmentVariableLoader.environmentVariableisPresent("DATABASE_URL"))
            environmentId("production");
        else
            environmentId("development");

        bindConstant().annotatedWith(Names.named("JDBC.driver")).to("org.postgresql.Driver");
        bindConstant().annotatedWith(Names.named("JDBC.url")).to(rawJdbcUrl);
        bindConstant().annotatedWith(Names.named("JDBC.username")).to(databaseUri.getUserInfo().split(JdbcUtil.JDBC_URL_SEPARATOR)[0]);
        bindConstant().annotatedWith(Names.named("JDBC.password")).to(databaseUri.getUserInfo().split(JdbcUtil.JDBC_URL_SEPARATOR)[1]);
        bindConstant().annotatedWith(Names.named("JDBC.autoCommit")).to(false);
//        bindConstant().annotatedWith(Names.named("mybatis.configuration.localCacheScope")).to(LocalCacheScope.STATEMENT.name());
    }

    private static final String getRawJDBCUrlFromUri(URI uri) {
        return JDBC_POSTGRESQL_URL_PREFIX + uri.getHost() + JDBC_URL_SEPARATOR + uri.getPort() + uri.getPath() ;
    }
}
