<%-- 
    Document   : ViewItems
    Created on : Aug 15, 2014, 4:59:47 PM
    Author     : Elie X2
--%>

<%@page import="emp.ItemBean"%>
<%@page import="emp.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Items</title>
    </head>
    <body>
        <div>
            <h2>Existing Items</h2>
            <table border="1">
                <thead>
                <tr>
                    <th>ItemId</th>
                    <th>ItemName</th>
                    <th>Date de publication</th>
                    <th>Item Type</th>
                </tr>
                </thead>
                <tbody>
                <%
                        ItemBean ib = new ItemBean();
                        List<Item> list = ib.getItems();
                        for (Item item : list) {
                    %>

                    <tr>
                        <td><%=String.valueOf(item.getItemId())%></td>
                        <td><%=item.getItemName()%></td>
                        <td><%=String.valueOf(item.getItemDatepb())%></td>
                        <td><%=item.getItemType().getTypeLabel()%></td>
                        <td>
                            <form method="post" action="UpdateItem.jsp">
                                    <input type="hidden" name="updateId" value="<%=String.valueOf(item.getItemId())%>"/> 
                                    <input type="submit" value="Modify"/> 
                                </form>
                        </td>
                        <td>
                            <form method="post" action="DelItem">
                                    <input type="hidden" name="delId" value="<%=String.valueOf(item.getItemId())%>"/> 
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
