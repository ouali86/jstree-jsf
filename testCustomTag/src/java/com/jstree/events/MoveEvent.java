/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstree.events;

/**
 *
 * @author Mostafa
 */
public class MoveEvent {
    
    private String draggedNode;
    private String droppedNode;

    public String getDraggedNode() {
        return draggedNode;
    }

    public void setDraggedNode(String draggedNode) {
        this.draggedNode = draggedNode;
    }

    public String getDroppedNode() {
        return droppedNode;
    }

    public void setDroppedNode(String droppedNode) {
        this.droppedNode = droppedNode;
    }
    
    
    
}
