package com.base.util;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengtian on 2017/12/5
 */
public class CSVUtil {

    private static final String CSV_EXT = "csv";

    /**
     * 将某个路径下面的csv文件合并到一个文件中
     *
     * @param targetPath 目标文件夹
     * @param toFile     合并到的文件
     */
    public static void unionCSV(String targetPath, String toFile) throws IOException {
        unionCSV(targetPath, toFile, true);
    }

    /**
     * @param targetPath
     * @param toFile
     * @param delFileOnExist 是否删除存在的文件
     * @throws IOException
     */
    public static void unionCSV(String targetPath, String toFile, boolean delFileOnExist) throws IOException {
        if (delFileOnExist) {
            File file = new File(toFile);
            if (file.exists()) {
                file.deleteOnExit();
            }
        }

        List<String> allFile = FileUtil.listFile(targetPath, CSV_EXT, true);

        for (String file : allFile) {
            List<String[]> contents = readCSV(file);
            writeCSV(contents, toFile, true);
        }
    }

    public static List<String[]> readCSV(String filePath) throws IOException {
        return readCSV(filePath, 0);
    }

    /**
     * 读取csv文件
     *
     * @param filePath
     * @param ignoreColumnNum 忽略前几行
     * @return
     * @throws IOException
     */
    public static List<String[]> readCSV(String filePath, int ignoreColumnNum) throws IOException {
        List<String[]> contents = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line = null;
            if (ignoreColumnNum != 0) {
                int num = 0;
                while (num < ignoreColumnNum) {
                    reader.readLine();
                }
            }
            while ((line = reader.readLine()) != null) {
                String[] content = line.split(",");
                contents.add(content);
            }
        } catch (IOException e) {
            throw new IOException("readCSV error", e);
        }
        return contents;
    }

    public static void writeCSV(List<String[]> contents, String toFile) throws IOException {
        writeCSV(contents, null, toFile, false);
    }

    public static void writeCSV(List<String[]> contents, String[] titles, String toFile) throws IOException {
        writeCSV(contents, titles, toFile, false);
    }

    public static void writeCSV(List<String[]> contents, String toFile, boolean appendToFile) throws IOException {
        writeCSV(contents, null, toFile, appendToFile);
    }

    /**
     * 写CSV文件
     *
     * @param contents
     * @param titles       标题
     * @param toFile       文件路径
     * @param appendToFile 是否追加
     * @throws IOException
     */
    public static void writeCSV(List<String[]> contents, String[] titles, String toFile, boolean appendToFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(toFile, appendToFile), "UTF-8"), 1024)) {

            if (titles != null) {
                for (int i = 0; i < titles.length; i++) {
                    writer.write(titles[i]);
                    writer.write(",");
                }
                writer.newLine();
            }
            for (String[] content : contents) {
                for (String txt : content) {
                    writer.write(HtmlScriptUtil.replaceHtml(txt));
                    writer.write(",");
                }
                writer.newLine();
            }

        } catch (IOException e) {
            throw new IOException("writeCSV error", e);
        }
    }
}
