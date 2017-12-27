package com.spring.beans;

import com.spring.core.ResolvableType;

/**
 * Created by mengtian on 2017/12/12
 */
public interface BeanFactory {
    String FACTORY_BEAN_PREFIX = "&";

    Object getBean(String name);

    <T> T getBean(String name, Class<T> requiredType);

    Object getBean(String name, Object... args);

    <T> T getBean(Class<T> requiredType);

    <T> T getBean(Class<T> requiredType, Object... args);

    boolean containsBean(String name);

    /**
     * 是否是单例的，即在spring IOC容器中是否只存在一个实例
     * @param name
     * @return
     */
    boolean isSingleton(String name);

    /**
     * 是否是"原型"的（不翻译可能更好），Prototype在每次被请求时都是新建一个实例返回
     */
    boolean isPrototype(String name);

    boolean isTypeMatch(String name, ResolvableType typeToMatch);

    boolean isTypeMatch(String name, Class<?> typeToMatch);

    /**
     * 返回给定名称、别名对应的类型
     */
    Class<?> getType(String name);

    /**
     * 返回给定名称的别名，如果给定的名称是别名的话，返回此名称对应的原始名称和别名，原始名称排在第一位
     */
    String[] getAliases(String name);

}
