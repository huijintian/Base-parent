package com.base.akka.extension.setting;

import akka.actor.*;

/**
 * Created by mengtian on 2017/11/12
 */
public class MySQLJDBCSettings
        extends AbstractExtensionId<MySQLJDBCSettingsImpl>
        implements ExtensionIdProvider {

    public static final MySQLJDBCSettings settingProvider = new MySQLJDBCSettings();

    @Override
    public MySQLJDBCSettingsImpl createExtension(ExtendedActorSystem extendedActorSystem) {
        return new MySQLJDBCSettingsImpl(extendedActorSystem.settings().config());
    }

    @Override
    public ExtensionId<? extends Extension> lookup() {
        return MySQLJDBCSettings.settingProvider;
    }
}
