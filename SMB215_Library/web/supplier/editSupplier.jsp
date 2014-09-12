<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Supplier</title>
        <script type="text/javascript">
    getRemarks(){        
    document.getElementById("remarks").value = <%=request.getParameter("remarks")%>
}
        </script>
    </head>
    <body>
        <h1>Supplier</h1>
        <form action="../SaveSupplier?id=<%=request.getParameter("id")%>" method="post">
            <table>
                <tr>
                    <td><label>Name:</label></td>
                    <td><input type="text" name="name" value="<%=request.getParameter("name")%>"></td>
                </tr>
                <tr>
                    <td><label>Website</label></td>
                    <td><input type="text" name="website" value="<%=request.getParameter("website")%>"></td>
                </tr>
                <tr>
                    <td><label>Remarks</label></td>
                    <td><textarea name="remarks" >
                        </textarea></td>
                <tr>
                    <td><label>Active</label></td>
                    <td>
                        <input type="radio" value="1"><label>Yes</label> 
                        <input type="radio" value="2"><label>No</label>
                    </td>
                </tr>

            </table>
               
                    
                


            <button type="submit">Save</button>
        </form>
        <a href="../GetSuppliers">Back</a>
    </body>
    
</html>
