package xyz.jamesnuge.fantasyleague.guice;

import com.google.inject.name.Names;
import org.mybatis.guice.MyBatisModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.jamesnuge.fantasyleague.config.environment.utils.AppUtil;
import xyz.jamesnuge.fantasyleague.guice.mybatis.JdbcUtil;
import xyz.jamesnuge.fantasyleague.config.environment.EnvironmentVariableLoader;

import java.net.URI;

import static xyz.jamesnuge.fantasyleague.guice.mybatis.JdbcUtil.*;

/**
 * Created by james on 11/04/17.
 */
public class FantasyMybatisBinder extends MyBatisModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(FantasyMybatisBinder.class);

    private final EnvironmentVariableLoader environmentVariableLoader;
    private final URI databaseUri;
    private final String rawJdbcUrl;
    private final String driverType;


    private final Boolean isProduction;

    public FantasyMybatisBinder(EnvironmentVariableLoader environmentVariableLoader, String driverType) throws Exception {
        this.environmentVariableLoader = environmentVariableLoader;
        this.driverType = driverType;
        this.isProduction = environmentVariableLoader.environmentVariableisPresent(AppUtil.ENVIRONMENT_KEY) ? environmentVariableLoader.environmentVariableisPresent("environment") : false;
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

        if (environmentVariableLoader.environmentVariableisPresent(MybatisGuiceUtil.DATABASE_URL_KEY)) {
            environmentId(MybatisGuiceUtil.PRODUCTION_GUICE_ENVIRONMENT_VARIABLE);
        } else {
            environmentId(MybatisGuiceUtil.DEVELOPMENT_GUICE_ENVIRONMENT_VARIABLE);
        }

        bindConstant().annotatedWith(Names.named(JDBC_DRIVER_INJECTION_NAME)).to(driverType);
        bindConstant().annotatedWith(Names.named(JDBC_URL_INJECTION_NAME)).to(rawJdbcUrl);
        bindConstant().annotatedWith(Names.named(JDBC_USERNAME_INJECTION_NAME)).to(databaseUri.getUserInfo().split(JdbcUtil.JDBC_URL_SEPARATOR_STRING)[0]);
        bindConstant().annotatedWith(Names.named(JDBC_PASSWORD_INJECTION_NAME)).to(databaseUri.getUserInfo().split(JdbcUtil.JDBC_URL_SEPARATOR_STRING)[1]);
        bindConstant().annotatedWith(Names.named(JDBC_AUTO_COMMIT_INJECTION_NAME)).to(false);
//        bindConstant().annotatedWith(Names.named("mybatis.configuration.localCacheScope")).to(LocalCacheScope.STATEMENT.name());
    }

}
