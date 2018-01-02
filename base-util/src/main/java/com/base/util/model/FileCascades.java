package com.base.util.model;

import java.util.List;

/**
 * Created by mengtian on 2018/1/3
 */
public class FileCascades {
    private String file;
    private List<FileCascades> childFiles;

    public FileCascades() {
    }

    public FileCascades(String file) {
        this.file = file;
    }

    public FileCascades(String file, List<FileCascades> childFiles) {
        this.file = file;
        this.childFiles = childFiles;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<FileCascades> getChildFiles() {
        return childFiles;
    }

    public void setChildFiles(List<FileCascades> childFiles) {
        this.childFiles = childFiles;
    }

    @Override
    public String toString() {
        return "FileCascades{" +
                "file='" + file + '\'' +
                ", childFiles=" + childFiles +
                '}';
    }
}
