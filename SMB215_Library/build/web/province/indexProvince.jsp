
<%@page import="country.*"%>
<%@page import="province.*"%>
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
        <title>Province Home Page</title>
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
                                
                                //generate provinces list
                                ProvinceBean ProvincesBean = new ProvinceBean();
                                List<Province> Provinceslist = ProvincesBean.getProvinces();  
                                pageContext.setAttribute("Provinceslist1", Provinceslist);
 
                                %>
                                
                           <br />
                            
                            <table width="100%"cellspacing=0" cellpading="0">
                                
                                <tr>
                                    <td colspan="3" valign="bottom">View list of existing Provinces in Library database</td>  
                                    <td align="right"><a href="addProvince.jsp"><input type="submit" name="Submit" value="Add a new Province" class="button"></a></td>
                                </tr>
                                <tr>
                                    <td colspan="4"><hr width="100%"></td>
                                </tr>
                                <tr>
                                    <td width="200px"><strong>Province Name</strong></td>
                                    <td><strong>Province Code</strong></td>
                                    <td><strong>Country</strong></td>
                                    <td><strong>Actions</strong></td>
                                </tr>
                                <c:forEach items="${Provinceslist1}" var="pvc1">  
                                <tr>
                                     <td width="200px">${pvc1.name}</td>
                                     <td>${pvc1.code}</td>
                                     <c:set var="cntid" value="${pvc1.country}"/>
                                      
                                     <td></td>
                                     <td>
                                         <a href="editProvince.jsp?pvc1_id=${pvc1.id}&pvc1_name=${pvc1.name}"><input type="submit" name="Submit" value="Edit Province" class="button"></a>
                                         <a href="deleteProvince.jsp?pvc1_id=${pvc1.id}&pvc1_name=${pvc1.name}"><input type="submit" name="Submit" value="Delete Province" class="button"></a>
                                     </td>
                                </tr>
                                </c:forEach>
                                <tr>

                                </tr>

                            </table>
            </section>           



            <!--==============================footer=================================-->

        </div>   
         
        <script type="text/javascript"> Cufon.now();</script>
    </h:body>
</html>



