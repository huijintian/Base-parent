package com.simulation.robot.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mengtian on 2017/7/24.
 */
public class HtmlScriptUtil {
    private static final String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

    public static String replaceHtml(String htmlText) {
        if (StringUtils.isNotBlank(htmlText)) {
            Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            Matcher m_html = p_html.matcher(htmlText);
            return m_html.replaceAll("").replaceAll("&nbsp;", ""); //过滤html标签
        } else {
            return "";
        }

    }
}
