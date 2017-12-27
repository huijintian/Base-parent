package com.algorithm.classifiers.tree;

/**
 * Created by mengtian on 2017/11/27
 */
public class TreePruner {
    private TreePruner(){}

    public static enum PruningMethod{
        NODE,
        REDUCED_ERROR,
        ERROR_BASED
    }

    public static void prune(TreeNodeVisitor root, PruningMethod method, CLassificationDataSet testSet){

    }
}
