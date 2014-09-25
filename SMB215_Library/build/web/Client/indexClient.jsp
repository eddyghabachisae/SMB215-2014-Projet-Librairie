<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Client.*"%>
<%@page import="gender.*"%>
<%@page import="Marital.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html">
        <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <h:head>
        <title>Client Home Page</title>
        <%@ include file="../main.html" %>
    </h:head>
    
    <h:body id="page1">
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <div class="container_12">
                    <div class="wrapper p3">
                        <div class="grid_12">
                            <div class="wrapper border-bot">
                                <h1><a href="${pageContext.request.contextPath}/home.jsp">Library</a></h1>
                                <nav>
                                    <ul class="menu">
                                        <li><b><% out.print(session.getAttribute("username"));%></b></li>
                                        <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                    <li><a href="logout.jsp">Logout</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <div class="clear"></div>
                </div>
            </header>
<!--==============================content================================-->
 <section id="content1"><div class="ic"></div>
                                <%
                                //parse session id variable to long type
                                Object attribute = request.getSession().getAttribute("userid");
                                long orgId = Long.parseLong(String.valueOf(attribute));   
                                
                                // query client data using a session id        
                                ClientBean cltBean = new ClientBean();
                                Client clt1 = cltBean.getClient(orgId);
                                
                                // Get Gender information
                                GenderBean genBean = new GenderBean();
                                Gender gen = genBean.getGender(clt1.getGender()); 
                                
                                // Get Marital Status information            
                                MaritalBean marBean = new MaritalBean();
                                Marital mar = marBean.getMarital(clt1.getMaritalstatus()); %>  
                                
                            Welcome to the Profile page of user: <b><%=clt1.getUsername()%></b><br />
                            
                            <table width="100%"cellspacing=0" cellpading="0">
                                <tr><td colspan="2"><h1>General Information:</h1><br /><br /></td></tr>
                                <tr>
                            <td  width="150px"><image src="../images/Client/<%=clt1.getId()%>.jpg" border="2" alt="Photo of <%=clt1.getFirstname()%> <%=clt1.getLastname()%>" /> </td><td>
                                Full Name: <i><%=clt1.getFirstname()%> <%=clt1.getLastname()%><i><br/>
            
                            Gender:  <i><%=gen.getGender()%> </i> <br/>
                            Marital status:  <i><%=mar.getMarital()%> </i> <br/>
                            Address:  <i><%=clt1.getAddress()%> </i> <br/>
                            
                            Phone:  <i><%=clt1.getPhone()%> </i> <br/>
                            Mobile:  <i><%=clt1.getMobile()%> </i> <br/>
                            Email:  <i><%=clt1.getEmail()%> </i> <br/>
                            Remarks:  <i><%=clt1.getRemarks()%></i> <br/>
                            Account is active:  <i><%=clt1.getIsactive()%> </i> <br/>                            
                            </br></td>
                            </tr>
                            <tr><td colspan="2">Please select an option from the below:</td></tr>
                            <tr><td colspan="2">
                            <a href="editClient.jsp"><input type="submit" name="Submit" value="Edit My Profile" class="button"></a>
                                   <a href="GetClient"><input type="submit" name="Submit" value="Borrow a book" class="button"/></a>
                            <a href="GetClient"><input type="submit" name="Submit" value="Borrowed Books List" class="button"/></a>
                            <a href="GetClient"><input type="submit" name="Submit" value="change your password" class="button"/></a>
                                </td>
                            </tr>
            </section>           



            <!--==============================footer=================================-->

        </div>   
         
        <script type="text/javascript"> Cufon.now();</script>
    </h:body>
</html>



