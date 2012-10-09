/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var className="";
var methodName="";
        
var xmlhttp;
if (window.XMLHttpRequest)
{// code for IE7+, Firefox, Chrome, Opera, Safari
    xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
   


function selectTree(selectedId){
    
    xmlhttp.open("POST","servlet",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            
    
        }
    }
  
    xmlhttp.send("operation=selection&selectedId="+selectedId);
    
}

function moveTree(dragged,dropped){
    
    xmlhttp.open("POST","servlet",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            
    
        }
    }
  
    xmlhttp.send("operation=move&dragged="+dragged+"&dropped="+dropped);
    

}

function rename(oldName,newName){

    
    xmlhttp.open("POST","servlet",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            
    
        }
    }
  
    xmlhttp.send("operation=rename&oldName="+oldName+"&newName="+newName);
    

}

function create(parent,child){

    
    xmlhttp.open("POST","servlet",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            
    
        }
    }
  
    xmlhttp.send("operation=create&parent="+parent+"&child="+child);
    
}

function remove(removedId){
   
      xmlhttp.open("POST","servlet",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            
    
        }
    }
  
    xmlhttp.send("operation=remove&removedId="+removedId);
    
}






