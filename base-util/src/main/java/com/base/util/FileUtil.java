package com.base.util;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    public static void newDirs(String... paths) throws IOException {
        for (String path : paths) {
            if (path.contains(".")) {
                System.out.println(path + " is a file, just create parent dir");
                Files.createParentDirs(new File(path));
                continue;
            }
            newDir(path);
        }
    }

    public static void newDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
