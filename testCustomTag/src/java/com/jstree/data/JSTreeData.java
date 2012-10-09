/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstree.data;

import com.jstree.events.CreateEvent;
import com.jstree.events.MoveEvent;
import com.jstree.events.RemoveEvent;
import com.jstree.events.RenameEvent;
import com.jstree.events.SelectEvent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mostafa
 */
public class JSTreeData {

    public static SelectEvent getSelectionEvent(FacesContext context) {

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        SelectEvent selectEvent = (SelectEvent) request.getSession().getAttribute("selection");
        request.getSession().removeAttribute("selection");
        return selectEvent;

    }

    public static MoveEvent getMoveEvent(FacesContext context) {

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        MoveEvent moveEvent = (MoveEvent) request.getSession().getAttribute("move");
        request.getSession().removeAttribute("move");
        return moveEvent;

    }

    public static RenameEvent getRenameEvent(FacesContext context) {

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        RenameEvent renameEvent = (RenameEvent) request.getAttribute("rename");;
        request.getSession().removeAttribute("rename");
        return renameEvent;

    }

    public static CreateEvent getCreateEvent(FacesContext context) {

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        CreateEvent createEvent = (CreateEvent) request.getAttribute("create");
        request.getSession().removeAttribute("create");
        return createEvent;

    }

    public static RemoveEvent getRemoveEvent(FacesContext context) {

        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        RemoveEvent removeEvent = (RemoveEvent) request.getAttribute("remove");
        request.getSession().removeAttribute("remove");
        return removeEvent;

    }
}
