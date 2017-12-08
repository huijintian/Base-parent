package com.base.util;

import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengtian on 2017/10/22
 */
public class YamlConfigUtil {
    private static Yaml yaml = new Yaml();

    private YamlConfigUtil() {
    }

    public static Map<String, Object> readConfig(File file) throws FileNotFoundException {
        Map map = yaml.loadAs(new FileReader(file), Map.class);
        return readYamlConfig("", map);
    }

    private static Map<String, Object> readYamlConfig(String upKey, Map map) {
        if (StringUtils.isBlank(upKey)) {
            upKey = "";
        } else {
            upKey += ".";
        }
        Map<String, Object> result = new HashMap<>();
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            if (value instanceof String) {
                result.put(upKey.concat(key.toString()), value);
            } else if (value instanceof Map) {
                result.putAll(readYamlConfig(upKey.concat(key.toString()), (Map) value));
            } else {
                result.put(upKey.concat(key.toString()), value);
            }
        }
        return result;
    }
}
