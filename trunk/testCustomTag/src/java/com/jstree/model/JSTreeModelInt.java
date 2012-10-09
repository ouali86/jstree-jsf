/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstree.model;

/**
 *
 * @author Mostafa
 */
public interface JSTreeModelInt {
    
    
    StringBuffer loadTreeData();
    
    void selectTree(String selectedId);
    
    void moveTree(String dragged,String dropped);
    
    void rename(String oldName,String newName);
    
    void create(String parent,String child);
    
    void remove(String removedId);
    
}
