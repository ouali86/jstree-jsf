/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jstree.tag;

import com.jstree.model.JSTreeModelInt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mostafa
 */
@FacesComponent(value="treeTag")
public class TreeTag extends UIComponentBase implements ClientBehaviorHolder {

    @Override
    public String getFamily() {
        return "treeTag";
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        System.out.println("select------");
        
       
      
       
        ClientBehaviorContext selectBehaviorContext =
                ClientBehaviorContext.createClientBehaviorContext(context,
                this, "select", getClientId(context), null);
        
        ClientBehaviorContext moveBehaviorContext =
                ClientBehaviorContext.createClientBehaviorContext(context,
                this, "move", getClientId(context), null);
        
        ClientBehaviorContext renameBehaviorContext =
                ClientBehaviorContext.createClientBehaviorContext(context,
                this, "rename", getClientId(context), null);
        
        ClientBehaviorContext createBehaviorContext =
                ClientBehaviorContext.createClientBehaviorContext(context,
                this, "create", getClientId(context), null);
        
        ClientBehaviorContext removeBehaviorContext =
                ClientBehaviorContext.createClientBehaviorContext(context,
                this, "remove", getClientId(context), null);

        
        String selectBehaviour = null;
        String moveBehaviour = null;
        String renameBehaviour = null;
        String createBehaviour = null;
        String removeBehaviour = null;
        
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.startElement("div", null);
        responseWriter.writeAttribute("id", getClientId(context), "clientId");
        responseWriter.writeAttribute("name", getClientId(context), "clientId");
        Map<String, List<ClientBehavior>> behaviors = getClientBehaviors();
        System.out.println("length ->"+behaviors.keySet().size());
   
        if (behaviors.containsKey("select")) {
            selectBehaviour = behaviors.get("select").get(0).getScript(selectBehaviorContext);
            System.out.println("selectBehaviour="+selectBehaviour);
            // responseWriter.writeAttribute("onclick", click, null);
        }
        if(behaviors.containsKey("move")){
            moveBehaviour = behaviors.get("move").get(0).getScript(moveBehaviorContext);
            System.out.println("moveBehaviour="+moveBehaviour);
        }
        if(behaviors.containsKey("rename")){
            renameBehaviour = behaviors.get("rename").get(0).getScript(renameBehaviorContext);
            System.out.println("renameBehaviour="+renameBehaviour);
        }
        if(behaviors.containsKey("create")){
            createBehaviour = behaviors.get("create").get(0).getScript(createBehaviorContext);
            System.out.println("createBehaviour="+createBehaviour);
        }
        if(behaviors.containsKey("remove")){
            removeBehaviour = behaviors.get("remove").get(0).getScript(removeBehaviorContext);
            System.out.println("removeBehaviour="+removeBehaviour);
        }
     String s=   
      "	<ul> "+
		"<li id=\"phtml_1\">"+
			"<a href=\"#\">Root node 1</a>"+
			"<ul>"+
				"<li id=\"phtml_2\">"+
					"<a href=\"#\">Child node 1</a>"+
				"</li>"+
				"<li id=\"phtml_3\">"+
					"<a href=\"#\">Child node 2</a>"+
				"</li>"+
			"</ul>"+
		"</li>"+
		"<li id=\"phtml_4\">"+
			"<a href=\"#\">Root node 2</a>"+
		"</li>"+
	"</ul>";
        responseWriter.write(s);
        System.out.println(">>>>>>>>>>>>>>TAG");
        
        responseWriter.endElement("div");
        
        responseWriter.startElement("script", this);
        responseWriter.write("$(function(){$(\"#"+getClientId(context).split(":")[0]+"\\\\:"+getClientId(context).split(":")[1] +"\").jstree({  \"plugins\" : [ \"themes\", \"html_data\", \"dnd\", \"ui\", \"crrm\" ]   })"+
       
        ".bind(\"move_node.jstree\", function (event, data) {"+                        
                       " data.rslt.o.each(function (i) { "
                 +"moveTree($(this).attr(\"id\"), data.rslt.cr === -1 ? 1 : data.rslt.np.attr(\"id\")); }); "+
                   moveBehaviour+ " }).bind(\"rename.jstree\", function (event, data) {"+
                     "rename(data.rslt.old_name, data.rslt.new_name);"+
                    " "+renameBehaviour+"}).bind(\"create.jstree\", function (event, data) {"+
                       " var node = data.rslt.obj;"+
                       " node.attr(\"id\", data.rslt.name);"+
                       " node.attr(\"name\", data.rslt.name);"+
                       " create(data.rslt.parent.attr(\"id\"), data.rslt.name);"+
                        createBehaviour+"}).bind(\"select_node.jstree\", function(event, data){"+
                        "var selectedObj = data.rslt.obj;"+
                        "selectTree(selectedObj.attr(\"id\"));"+
                        selectBehaviour+"}).bind(\"remove.jstree\", function (e, data) {"+
                        "data.rslt.obj.each(function () {"+
                           " remove(this.id); "+
                           removeBehaviour+"}); });"+
                        " $(\"#create_button\").click(function () { "+ 
                       " $(\"#"+getClientId(context).split(":")[0]+"\\\\:"+getClientId(context).split(":")[1] +"\").jstree(\"create\", null, \"last\", { \"attr\" : { \"rel\" : \"mm\" } });"+
                     " });   });"+
               "$(\"#rename_button\").click(function () { "+
                   "$(\"#"+getClientId(context).split(":")[0]+"\\\\:"+getClientId(context).split(":")[1] +"\").jstree(\"rename\");"+
                "});"+" $(\"#remove_button\").click(function () { "+
                   " $(\"#"+getClientId(context).split(":")[0]+"\\\\:"+getClientId(context).split(":")[1] +"\").jstree(\"remove\");  });");
                    
          
        
        responseWriter.endElement("script");
        
    }
    
    
     @Override
      public void decode(FacesContext context) {
         
           Map<String, List<ClientBehavior>> behaviors = getClientBehaviors();
           if (behaviors.isEmpty()) {
               return;
           }
           
          
           
           ExternalContext external = context.getExternalContext();
           Map<String, String> params = external.getRequestParameterMap();
          for (Map.Entry<String, String> entry : params.entrySet()) {
             String string = entry.getKey();
             String string1 = entry.getValue();
              System.out.println("Key="+string+"  value="+string1);
             
         }
           String behaviorEvent = params.get("javax.faces.behavior.event");
           System.out.println("Behavior Event-->"+behaviorEvent);
           if (behaviorEvent != null) {
               List<ClientBehavior> behaviorsForEvent = behaviors.get(behaviorEvent);
   
               if (behaviors.size() > 0) {
                   String behaviorSource = params.get("javax.faces.source");
                  String clientId = getClientId(context);
                  if (behaviorSource != null && behaviorSource.equals(clientId)) {
                      for (ClientBehavior behavior: behaviorsForEvent) {
                          behavior.decode(context, this);
                      }
                  }
               }
           }
       }
   
       @Override
       public Collection<String> getEventNames() {
           return Arrays.asList("select","move","rename" ,"create","remove");
       }
   
       @Override
       public String getDefaultEventName() {
           return "select";
       }
    
}
