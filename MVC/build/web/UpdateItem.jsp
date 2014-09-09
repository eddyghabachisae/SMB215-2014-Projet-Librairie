<%-- 
    Document   : UpdateItem
    Created on : Aug 15, 2014, 4:59:38 PM
    Author     : Elie X2
--%>


<%@page import="java.util.Calendar"%>
<%@page import="emp.Item"%>
<%@page import="emp.ItemBean"%>
<%@page import="emp.ItemTypeBean"%>
<%@page import="emp.ItemType"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Update</title>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
  <script>
  $(function() {
    $( "#itemdate" ).datepicker();
  });
  </script>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            ItemBean ib = new ItemBean();
            Item item = ib.getItem(id);
        %>
        <div>
            <form action="UpdateItem" method="post">
                <h1>Update Item Type ID:<%=item.getItemId()%></h1>
                <label><input type="hidden" name="itemid" id="itemid" value="<%=item.getItemId()%>"/></label>                    
                <label>Name</label>
                <input type="text" name="itemname" id="itemname" value="<%=item.getItemName()%>"/>
                <label>Date</label>
               <!-- <input type="text" name="itemdate" id="itemdate" value="<%=item.getItemDatepb()%>"/>-->
                <input type="text" name="itemdate" id="itemdate" value="<%
                Calendar c=Calendar.getInstance();
                c.setTime(item.getItemDatepb());
                out.println((c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.YEAR));
                %>"/>
                <label>Item Type</label>
                
                <select name="itemtype">
                    <%
                        ItemTypeBean itb = new ItemTypeBean();
                        List<ItemType> list = itb.getItemTypes();
                        for (ItemType type : list) {
                            if(type.getTypeId()==item.getItemType().getTypeId())
                            {
                                out.println("<Option Value=\""+type.getTypeId()+"\" Selected=\"selected\">"+type.getTypeLabel()+"</Option>");
                            }
                            else
                            {
                                 out.println("<Option Value=\""+type.getTypeId()+"\" >"+type.getTypeLabel()+"</Option>");
                            }
                        }
                        
                            
                    %>
                
                 </select>
                
                <button type="submit">Update Item</button>
            </form>
        </div>   
    </body>
</html>