/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstree.model;

import java.util.List;

/**
 *
 * @author Mostafa
 */
public class TreeNode {
    
    
    private String text;
    private List<TreeNode> childs;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeNode> getChilds() {
        return childs;
    }

    public void setChilds(List<TreeNode> childs) {
        this.childs = childs;
    }
    
    
}
