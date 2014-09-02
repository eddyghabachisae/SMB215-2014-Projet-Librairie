<%-- 
    Document   : addItem
    Created on : Aug 15, 2014, 5:00:02 PM
    Author     : Elie X2
--%>

<%@page import="java.util.List"%>
<%@page import="emp.ItemType"%>
<%@page import="emp.ItemTypeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
  <script>
  $(function() {
    $( "#itemdate" ).datepicker();
  });
  
  
  </script>
        <title>Add Item </title>
    </head>
    <body>
      <div>
            <form action="AddItem" method="post">
                <h2>Add new Item </h2>
                <table>
                    <tr>
                        <td><label>Item ID:</label></td>
                        <td><input type="text" name="itemid"/></td>
                    </tr>
                    <tr>
                        <td><label>Name:</label></td>
                        <td><input type="text" name="itemname"/></td>
                    </tr>
                    <tr>
                        <td>Date de publication :</td>
                        <td><input type="text" name ="itemdate" id="itemdate"></td>
                    </tr>
                 <tr>
                        <td>Item Type :</td>
                        <td>
                                                        <select name="itemtype">
                             <%
                        ItemTypeBean itb = new ItemTypeBean();
                        List<ItemType> list = itb.getItemTypes();
                        if(list.isEmpty())
                        { %>
                            <script>
                                alert("Add Item Types before attempting to add items !");
                                window.location = "addItemType.jsp";
                            </script> 
                        <%
                 
                        }
                        else
                        {
                        for (ItemType type : list) {
                            
                                 out.println("<Option Value=\""+type.getTypeId()+"\" >"+type.getTypeLabel()+"</Option>");
                            
                        }
                        
                        }
                    %>
                            </select>
                                </td>
                    </tr>
                     
                    <tr>
                        <td>
                            <button type="submit" id="submit_button">Add new Item</button>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <p><a href="index.html">Back to homepage</a></p>
        </div>
    </body>
</html>
