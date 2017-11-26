package com.algorithm.datamining.ID3;

import java.util.ArrayList;

/**
 * Created by mengtian on 2017/11/26
 */
public class AttrNode {
    //当前属性的名称
    private String attrName;
    //父节点的分类属性值
    private String parentAttrValue;
    //子节点
    private AttrNode[] childAttrNode;
    //孩子叶子节点
    private ArrayList<String> childDataIndex;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getParentAttrValue() {
        return parentAttrValue;
    }

    public void setParentAttrValue(String parentAttrValue) {
        this.parentAttrValue = parentAttrValue;
    }

    public AttrNode[] getChildAttrNode() {
        return childAttrNode;
    }

    public void setChildAttrNode(AttrNode[] childAttrNode) {
        this.childAttrNode = childAttrNode;
    }

    public ArrayList<String> getChildDataIndex() {
        return childDataIndex;
    }

    public void setChildDataIndex(ArrayList<String> childDataIndex) {
        this.childDataIndex = childDataIndex;
    }
}
