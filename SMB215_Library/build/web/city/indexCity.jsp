
<%@page import="city.*"%>
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
        <title>City Home Page</title>
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
                                long userId = Long.parseLong(String.valueOf(attribute));   
                                
                                //generate Cities list
                                CityBean CitiesBean = new CityBean();
                                List<City> Citieslist = CitiesBean.getCities();  
                                pageContext.setAttribute("Citieslist1", Citieslist);
                                %>
                                
                           <br />
                            
                            <table width="100%"cellspacing=0" cellpading="0">
                                
                                <tr>
                                    <td colspan="2" valign="bottom">View list of existing Cities in Library database</td>  
                                    <td align="right"><a href="addCity.jsp"><input type="submit" name="Submit" value="Add a new City" class="button"></a></td>
                                </tr>
                                <tr>
                                    <td colspan="3"><hr width="100%"></td>
                                </tr>
                                <tr>
                                    <td width="200px"><strong>City Name</strong></td>
                                    <td><strong>City Code</strong></td>
                                    <td><strong>Actions</strong></td>
                                </tr>
                                <c:forEach items="${Citieslist1}" var="cit1">  
                                <tr>
                                     <td width="200px">${cit1.name}</td>
                                     <td>${cit1.code}</td>
                                     <td>
                                         <a href="editCity.jsp?cit_id=${cit1.id}"><input type="submit" name="Submit" value="Edit City" class="button"></a>
                                         <a href="deleteCity.jsp?cit_id=${cit1.id}&cit_name=${cit1.name}"><input type="submit" name="Submit" value="Delete City" class="button"></a>
                                     </td>
                                </tr>
                                </c:forEach>

                            </table>
            </section>           



            <!--==============================footer=================================-->

        </div>   
         
        <script type="text/javascript"> Cufon.now();</script>
    </h:body>
</html>



