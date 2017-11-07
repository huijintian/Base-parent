package com.base.util;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mengtian on 2017/10/20
 */
public class ConfigUtil {

    private static final Map<String, Object> config = new HashMap<>();
    private static final String ROOT_CONFIG_PATH = System.getProperty("user.dir").concat(File.separator).concat("config");

    private ConfigUtil() {
        readProperties();
    }

    private void readProperties() {
        System.out.println("系统配置文件夹：" + ROOT_CONFIG_PATH);
        String[] exts = {"properties", "yml"};
        Collection<File> files = FileUtils.listFiles(new File(ROOT_CONFIG_PATH), exts, true);
        files.forEach(file -> buildConfig(file));
    }

    private void buildConfig(File file) {
        try {
            if (file.getName().endsWith(".properties")) {
                Configurations configurations = new Configurations();
                PropertiesConfiguration properties = configurations.properties(file);
                Iterator keys = properties.getKeys();
                while (keys.hasNext()) {
                    String key = keys.next().toString();
                    config.put(key, properties.getString(key));
                }
            } else if (file.getName().endsWith(".yml")) {
                config.putAll(YamlConfigUtil.readConfig(file));
            } else {
                System.out.println(file.getName() + " 配置文件不可解析");
            }
        } catch (Exception e) {
            System.err.println("读取配置文件出错, " + e.toString());
        }
    }

    public Object getConfig(String key) {
        return config.get(key);
    }

    public Map getConfig() {
        return config;
    }

    private static class Inner {
        private static ConfigUtil INSTANCE = new ConfigUtil();
    }

    public static ConfigUtil getInstance() {
        return Inner.INSTANCE;
    }
}
