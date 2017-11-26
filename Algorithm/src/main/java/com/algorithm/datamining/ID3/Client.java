package com.algorithm.datamining.ID3;

/**
 * Created by mengtian on 2017/11/27
 */
public class Client {
    public static void main(String[] args) {
        String filePath = "E:\\CODE\\JAVA\\Base-parent\\Algorithm\\src\\main\\resources\\input.txt";
        ID3Tool tool = new ID3Tool(filePath);
        tool.startBuildingTree(true);
    }
}
