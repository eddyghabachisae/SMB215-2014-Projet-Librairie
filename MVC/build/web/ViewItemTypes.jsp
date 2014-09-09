<%-- 
    Document   : ViewItemTypes
    Created on : Aug 15, 2014, 3:49:26 PM
    Author     : Elie X2
--%>

<%@page import="emp.ItemTypeBean"%>
<%@page import="emp.ItemType"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Item Types</title>
    </head>
    <body>
        <div>
            <h2>Existing Item Types</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>Item Type Id</th>
                    <th>Item Type Label</th>
                </tr>
                </thead>
                <tbody>
                <%
                        ItemTypeBean ib = new ItemTypeBean();
                        List<ItemType> list = ib.getItemTypes();
                        for (ItemType type : list) {
                    %>

                    <tr>
                        <td><%=String.valueOf(type.getTypeId())%></td>
                        <td><%=type.getTypeLabel()%></td>
                        <td>
                            <form method="post" action="UpdateItemType.jsp">
                                    <input type="hidden" name="updateId" value="<%=String.valueOf(type.getTypeId())%>"/> 
                                    <input type="submit" value="Modify"/> 
                                </form>
                        </td>
                        <td>
                            <form method="post" action="DelItemType">
                                    <input type="hidden" name="delId" value="<%=String.valueOf(type.getTypeId())%>"/> 
                                    <input type="submit" value="Delete"/> 
                                </form>
                        </td>
                    </tr>
                     <%
                        }
                    %>
                    </tbody>
            </table>
                    <br>
                    <p><a href="index.html">Back to homepage</a></p>
        </div>
    </body>
</html>
