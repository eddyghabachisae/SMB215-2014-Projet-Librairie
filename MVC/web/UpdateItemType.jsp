<%-- 
    Document   : UpdateItemType
    Created on : Aug 15, 2014, 4:40:04 PM
    Author     : Elie X2
--%>

<%@page import="emp.ItemType"%>
<%@page import="emp.ItemTypeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Type Update</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            ItemTypeBean ib = new ItemTypeBean();
            ItemType type = ib.getItemType(id);
        %>
        <div>
            <form action="UpdateItemType" method="post">
                <h1>Update Item Type ID:<%=type.getTypeId()%></h1>
                <label><input type="hidden" name="typeid" id="typeid" value="<%=type.getTypeId()%>"/></label>                    
                <label>Label</label>
                <input type="text" name="typelabel" value="<%=type.getTypeLabel()%>"/>
                <button type="submit">Update Item Type</button>
            </form>
        </div>   
    </body>
</html>