package com.base.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;


/**
 * Created by mengtian on 2017/9/28
 */
public class YamlConfigUtil {

    private static Map config = Maps.newHashMap();

    private Yaml yaml = new Yaml();

    private YamlConfigUtil() {
        Map map = yaml.loadAs(YamlConfigUtil.class.getResourceAsStream("/properties/resource.yml"), Map.class);
        config = readYamlMap(map);
    }

    private Map<String, Object> readYamlMap(Map map) {
        return readYamlMap("", map);
    }

    private Map<String, Object> readYamlMap(String upKey, Map map) {
        if (StringUtils.isBlank(upKey)) {
            upKey = "";
        } else {
            upKey += ".";
        }
        Map<String, Object> result = Maps.newHashMap();
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            if (value instanceof String) {
                result.put(upKey.concat(key.toString()), value);
            } else if (value instanceof Map) {
                result.putAll(readYamlMap(upKey.concat(key.toString()), (Map) value));
            }
        }
        return result;
    }

    public static YamlConfigUtil getInstance() {
        return Inner.INSTANCE;
    }

    private static class Inner {
        private static YamlConfigUtil INSTANCE = new YamlConfigUtil();
    }

    public String getConfig(String key) {
        return config.get(key).toString();
    }

    //未验证
    public <T> T loadYamlAs(String pathname, Class<T> clazz) throws Exception {
        T obj = yaml.loadAs(YamlConfigUtil.class.getResourceAsStream(pathname), clazz);
        return obj;
    }

    public static void main(String[] args) {
        System.out.println(YamlConfigUtil.getInstance().getConfig("robot.sentence.secondName"));
    }

}
