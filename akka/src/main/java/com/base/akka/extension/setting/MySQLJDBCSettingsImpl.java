package com.base.akka.extension.setting;

import akka.actor.Extension;
import com.typesafe.config.Config;

/**
 * Created by mengtian on 2017/11/12
 */
public class MySQLJDBCSettingsImpl implements Extension {

    public final String DB_URL;
    public final String DB_NAME;
    public final String DB_DRIVER;
    public final String DB_USER_NAME;
    public final String DB_USER_PASSWORD;

    public MySQLJDBCSettingsImpl(Config config) {
        DB_URL = config.getString("connection.db.mysql.url");
        DB_NAME = config.getString("connection.db.mysql.dbname");
        DB_DRIVER = config.getString("connection.db.mysql.driver");
        DB_USER_NAME = config.getString("connection.db.mysql.username");
        DB_USER_PASSWORD = config.getString("connection.db.mysql.password");

    }
}
