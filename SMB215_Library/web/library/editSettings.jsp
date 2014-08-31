<%@page import="branch.BranchBean"%>
<%@page import="branch.Branch"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Settings</title>
    </head>
    <body>
        <h1>Settings</h1>
            <select>
				 
                                       <%
                                            BranchBean brhBean = new BranchBean();
                                            List<Branch> list = brhBean.getBranchesSummary();
                                            for (Branch brh : list) {
                                        %>
                                        <option value="<%=String.valueOf(brh.getId())%>">
                                          <%=brh.getName()%>
                    
                                           </option>
                                           <% } %>
                                   
            </select>
            
    </body>
</html>
