
                
<%@page import="Bran.BranchBean"%>
<%@page import="Bran.Branch"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Branch</title>
    </head>
    <body>
        <div>
            <h2>   Branch   </h2>
            <table border="2">
                <thead>
                <tr>
                    <th>Branch Id </th>
                    <th>Branch Name </th>
                      <th>Branch City </th>
                        <th>Branch Address </th>
                          <th>Branch Email </th>  
                          <th>Branch Phone </th>
                            <th>Branch Fax </th>
                              <th>Branch Mobile </th>
                                <th>Branch Is Active </th>
                                 <th>Branch Active Since </th>
                                  <th>Branch Deactivated Since </th>
                          
                          
             
                </tr>
                <thead>
                <tbody>
                <%
                        BranchBean bran = new BranchBean();
                        List<Branch> list = bran.getBranchs();
                        for (Branch br : list) {
                    %>
              
                <tr>
                        <td><%=String.valueOf(br.getbrhid())%></td>
                        <td><%=br.getbrhname()%></td>
                        <td><%=br.getbrhcity()%></td>
                        <td><%=br.getbrhaddress()%></td>
                        <td><%=br.getbrhemail()%></td>
                        <td><%=br.getbrhphone()%></td>
                        <td><%=br.getbrhfax()%></td>
                        <td><%=br.getbrhmobile()%></td>
                        <td><%=br.getbrhisactive()%></td>
                        <td><%=br.getbrhactivatedsince()%></td>
                        <td><%=br.getbrhdeactivatedsince()%></td>
      
                
                        <td>
               <form method="post" action="UpdateBranch.jsp">
                 <table> <input type="hidden" name="updatebrhid" value="<%=String.valueOf(br.getbrhid())%>"/> 
                    <input type="submit" name ="update" value="Modify"/> 
                                </form>
                        </td>
                        <td>
        <form method="post" action="DelBranch">
            <input type="hidden" name="deleteId" value="<%=String.valueOf(br.getbrhid())%>"/> 
                <input type="submit" value="Delete"/> 
                </table>
                                </form>
                        </td>
                    </tr>
                     <%
                        }
                    %>
                    </tbody>
            </table>
                    <br>
                    <p><a href="index.html">Back to home page</a></p>
                       <a href="addBranch.jsp">Add Branch</a>
                       <a href="viewBranch.jsp">View Branch</a>
        </div>
    </body>
</html>
