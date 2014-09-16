<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Supplier Branch</title>
    </head>
    <body>
        <form action="../SaveSupplierBranch?id=<%=request.getParameter("id")%>" method="post">
        <table>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" value="<%=request.getParameter("name")%>"></td>
            </tr>
            <tr>
                <td><label> Contact Name:</label></td>
                <td><input type="text" name="contactname" value="<%=request.getParameter("contactname")%>"></td>
            </tr>
            
                <tr><td><label>City:</label></td>
                    <td>
                                    <select name="city">

                        <c:forEach items="${cities}" var="cit">
                            <option value="${cit.id}"> ${cit.name} </option>
                        </c:forEach>
                                        </select>
                    </td>
                </tr>
             
            
            <tr>
                    <td><label>Address:</label></td>
                    <td><textarea name="address" ><%=request.getParameter("address")%></textarea>
                    </td>
                </tr>
            <tr>
                <td><label>Phone:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Fax:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Mobile:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                    <td><label>Remarks</label></td>
                    <td><textarea name="remarks" ><%=request.getParameter("remarks")%></textarea>
                    </td>
                </tr>
             <tr>
                    <td><label>Active</label></td>
                    <td>
                        <input type="radio" id="isactiveyes" name="isactive" value="true" 
                               <% if (request.getParameter("isactive").equals("true")) {%> 
                               checked <%}%>>
                        <label for="isactiveyes">Yes</label> 
                        <input type="radio" id="isactiveno" name="isactive" value="false"
                                <% if (request.getParameter("isactive").equals("false")) {%> 
                               checked <%}%>>
                        <label for="isactiveno">No</label>
                    </td>
                </tr>
                <tr>
                    <td><label>Deactivation reason</label></td>
                    <td><textarea id="deactivationreason" name="deactivationreason"><%=request.getParameter("deactivationreason")%></textarea>
                    </td>
                </tr>
        </table>
        </form>
    </body>
</html>
