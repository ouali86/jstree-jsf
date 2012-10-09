/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstree.servlet;

import com.jstree.events.CreateEvent;
import com.jstree.events.MoveEvent;
import com.jstree.events.RemoveEvent;
import com.jstree.events.RenameEvent;
import com.jstree.events.SelectEvent;
import com.managedbeans.TreeManagedBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mostafa
 */
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String operation = request.getParameter("operation");
        if (operation.equals("selection")) {
            SelectEvent selectEvent=new SelectEvent();
            selectEvent.setSelectId(request.getParameter("selectedId"));
            request.getSession(true).setAttribute("selection", selectEvent);
            
        } else if (operation.equals("move")) {
            MoveEvent moveEvent=new MoveEvent();
            moveEvent.setDraggedNode(request.getParameter("dragged"));
            moveEvent.setDroppedNode(request.getParameter("dropped"));
            request.getSession(true).setAttribute("move", moveEvent);
            
        } else if (operation.equals("rename")) {
            RenameEvent renameEvent=new RenameEvent();
            renameEvent.setNewName(request.getParameter("newName"));
            renameEvent.setOldName(request.getParameter("oldName"));
            request.getSession(true).setAttribute("rename", renameEvent);
        } else if (operation.equals("create")) {
            CreateEvent createEvent=new CreateEvent();
            createEvent.setChild(request.getParameter("child"));
            createEvent.setParent(request.getParameter("parent"));
            request.getSession(true).setAttribute("create", createEvent);
        } else if (operation.equals("remove")) {
            RemoveEvent removeEvent=new RemoveEvent();
            removeEvent.setRemovedNode(request.getParameter("removeId"));
             request.getSession(true).setAttribute("remove", removeEvent);
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
