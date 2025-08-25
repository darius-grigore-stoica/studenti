package repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private final Properties jdbcProps;
    private Logger logger;


    public JdbcUtils(Properties props) {
        this.jdbcProps = props;
        logger = LogManager.getLogger(JdbcUtils.class);
    }

    private Connection instance = null;

    private Connection getNewConnection() {
        String url = jdbcProps.getProperty("jdbc.url");
        String user = jdbcProps.getProperty("jdbc.user");
        String pass = jdbcProps.getProperty("jdbc.pass");
        logger.info("trying to connect to database url = " + url);
        Connection con = null;
        try {

            if (user != null && pass != null)
                con = DriverManager.getConnection(url, user, pass);
            else
                con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("Error getting connection " + e);
        }
        return con;
    }

    public Connection getInstance(){
        if(instance == null)
            return getNewConnection();
        else return this.instance;
    }
}