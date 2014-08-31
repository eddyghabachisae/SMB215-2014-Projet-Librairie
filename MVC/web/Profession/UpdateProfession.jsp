
<%@page import="Profession.Profession"%>
<%@page import="Profession.ProfessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profession Update</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("updateId"));
            ProfessionBean pf = new ProfessionBean();
            Profession p = pf.getProfession(id);
        %>
        <div>
            <form action="UpdateProfession" method="post">
                <h1>Update profession ID:<%=p.getprfid()%></h1>
                <label><input type="hidden" name="prfid" id="prfid" value="<%=p.getprfid()%>"/></label>                    
                <label>Description</label>
                <input type="text" name="prfdescription" value="<%=p.getprfdescription()%>"/>
                <button type="submit">Update Profession</button>
                   
            </form>
        </div>   
    </body>
</html>