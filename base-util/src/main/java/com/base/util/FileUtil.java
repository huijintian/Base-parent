package com.base.util;

import com.base.util.model.FileCascades;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengtian on 2017/11/13
 */
public class FileUtil {
    public static List<String> listFile(String path, boolean fullPath) {
        return listFile(path, null, fullPath);
    }

    public static List<String> listFile(String path, String ext, boolean fullPath) {
        List<String> files = new ArrayList<>();
        File p = new File(path);
        if (!p.isDirectory()) {
            files.add(path);
            return files;
        }
        File[] listFiles = p.listFiles();
        for (File listFile : listFiles) {
            if (listFile.isDirectory()) {
                files.addAll(listFile(listFile.getAbsolutePath(), ext, fullPath));
            } else {
                if (ext != null) {
                    String fileAbsolutePath = listFile.getAbsolutePath();
                    if (fileAbsolutePath.contains(".")
                            && fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf(".") + 1).equals(ext)) {
                        files.add(fullPath ?
                                listFile.getAbsolutePath() :
                                p.getName().concat(File.separator).concat(listFile.getName()));
                    }
                } else {
                    files.add(fullPath ?
                            listFile.getAbsolutePath() :
                            p.getName().concat(File.separator).concat(listFile.getName()));
                }
            }
        }
        return files;
    }

    public static FileCascades listFile(String path, String ext) {
        FileCascades fileCascades = new FileCascades();

        fileCascades.setFile(path);

        File p = new File(path);
        if (!p.isDirectory()) {
            return fileCascades;
        }
        File[] listFiles = p.listFiles();

        List<FileCascades> cascades = new LinkedList<>();
        for (File listFile : listFiles) {
            if (listFile.isDirectory()) {
                cascades.add(listFile(listFile.getAbsolutePath(), ext));
            } else {
                if (ext != null) {
                    String fileAbsolutePath = listFile.getAbsolutePath();
                    if (fileAbsolutePath.contains(".")
                            && fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf(".") + 1)
                            .equals(ext)) {
                        cascades.add(new FileCascades(fileAbsolutePath));
                    }
                } else {
                    cascades.add(new FileCascades(listFile.getAbsolutePath()));
                }
            }
        }
        fileCascades.setChildFiles(cascades);
        return fileCascades;
    }
}
