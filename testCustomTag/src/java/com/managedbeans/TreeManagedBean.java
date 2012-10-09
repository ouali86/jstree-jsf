/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbeans;

import com.jstree.data.JSTreeData;
import com.jstree.events.MoveEvent;
import com.jstree.events.SelectEvent;
import com.jstree.model.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.docutank.tank.webservice.ws.Category;

/**
 *
 * @author Mostafa
 */
@ManagedBean(name = "treeBean")
@SessionScoped
public class TreeManagedBean {

    Map<String, TreeNode> nodes = new HashMap<String, TreeNode>();
    List<TreeNode> rootNodes = new ArrayList<TreeNode>();

    public TreeManagedBean() {


        root = new TreeNode();
        List<Category> categories = new ArrayList<Category>();
        Category c1 = new Category();
        c1.setCategoryName("1");
        Category c2 = new Category();
        c2.setCategoryName("2");
        Category c3 = new Category();
        c3.setCategoryName("3");
        Category c11 = new Category();
        c11.setCategoryName("11");
        c11.setCategory(c1);
        Category c21 = new Category();
        c21.setCategoryName("21");
        c21.setCategory(c2);
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c11);
        categories.add(c21);
    }

    private void addNode(Category category) {

        if (category.getCategory() == null) {
            TreeNode node = new TreeNode();
            node.setChilds(new ArrayList<TreeNode>());
            node.setText(category.getCategoryName());
            rootNodes.add(node);
            nodes.put(category.getCategoryName(), node);
        } else if (nodes.containsKey(category.getCategory().getCategoryName())) {
            TreeNode parent = nodes.get(category.getCategory().getCategoryName());
            TreeNode node = new TreeNode();
            node.setChilds(new ArrayList<TreeNode>());
            node.setText(category.getCategoryName());
            parent.getChilds().add(node);
            nodes.put(category.getCategoryName(), node);
        } else {
            addNode(category.getCategory());
        }



    }
    String selected;
    TreeNode root;

    public void treeSelect() {
        SelectEvent selectEvent = JSTreeData.getSelectionEvent(FacesContext.getCurrentInstance());
        System.out.println("Tree Select ....... . ...");
        System.out.println("IDDDDDDDDD=" + selectEvent.getSelectId());
        selected = selectEvent.getSelectId();
    }

    public void treeMove() {
        MoveEvent moveEvent = JSTreeData.getMoveEvent(FacesContext.getCurrentInstance());
        System.out.println("Tree Move ....... . ...");
        System.out.println("Dragged=" + moveEvent.getDraggedNode());
        System.out.println("Dropped=" + moveEvent.getDroppedNode());

    }

    public void setSelected(String selected) {
        System.out.println("Selected=" + selected);
        this.selected = selected;
    }

    public String getSelected() {
        return selected;
    }
}
