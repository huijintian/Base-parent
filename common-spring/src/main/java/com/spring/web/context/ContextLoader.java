package com.spring.web.context;

import java.util.Properties;

/**
 * Created by mengtian on 2017/12/13
 */
public class ContextLoader {
    public static final String CONTEXT_ID_PARAM = "contextId";

    public static final String CONFIG_LOCATION_PARAM = "contextConfigLocation";

    public static final String CONTEXT_CLASS_PARAM = "contextCLass";

    public static final String CONTEXXT_INITIALIZER_CLASSES_PARAM = "contextInitializerClasser";

    public static final String GLOBAL_INITIALIZER_CLASSES_PARAM = "globalInitializerClasses";

    /**
     * Any number of these characters are considered delimiters between
     * multiple values in a single init-param String value.
     */
    public static final String INIT_PARAM_DELIMITERS = ",; \t\n";

    public static final String DEFAULT_STRATEGIES_PATH = "ContextLoader.properties";

    private static final Properties defaultStrategies;

    static {
        try {
            CLassPathResource resource = new ClassPathResource(DEFAULT_STRATEGIES_PATH, ContextLoader.class);
            defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
        }
    }

}
