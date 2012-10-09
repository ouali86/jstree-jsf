/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstree.events;

/**
 *
 * @author Mostafa
 */
public class RenameEvent {
    
    private String oldName;
    private String newName;

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
    
    
    
}
