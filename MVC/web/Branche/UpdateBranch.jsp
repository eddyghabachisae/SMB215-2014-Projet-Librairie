
<%@page import="Bran.BranchBean"%>
<%@page import="Bran.Branch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Branch Update</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            BranchBean brh = new BranchBean();
            Branch br = brh.getBranch(id);
        %>
        <div>
            <form action="UpdateBranch" method="post">
                <h1>Update Branch ID:<%=br.getbrhid()%></h1>
                <label><input type="hidden" name="brhid" id="empid" value="<%=b.getbrhid()%>"/></label>   
    
                <input type="text" name="brhname" value="<%=br.getbrhname()%>"/>
                <input type="text" name="brhcity" value="<%=br.getbrhcity()%>"/>
                <input type="text" name="brhaddress" value="<%=br.getbrhaddress()%>"/>
                <input type="text" name="brhemail" value="<%=br.getbrhemail()%>"/>
                 <input type="text" name="brhphone" value="<%=br.getbrhphone()%>"/>
                <input type="text" name="brhfax" value="<%=br.getbrhfax()%>"/>
                <input type="text" name="brhmobile" value="<%=br.getbrhmobile()%>"/>
                   <input type="text" name="brhisactive" value="<%=br.getbrhisactive()%>"/>
                <input type="text" name="brhactivesince" value="<%=br.getbrhactivesince()%>"/>
                <input type="text" name="brhdeactivatedsince" value="<%=br.getbrhdeactivatedsince()%>"/>
                <button type="submit">Update Branch</button>
                   
            </form>
        </div>   
    </body>
</html>
   