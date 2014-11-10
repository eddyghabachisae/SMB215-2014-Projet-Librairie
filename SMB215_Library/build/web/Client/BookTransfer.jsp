<%@page import="Client.ClientBook.BorrowedBean"%>
<%@page import="Client.ClientBook.Availability"%>
<%@page import="Client.ClientBook.AvailabilityBean"%>
<%@page import="java.util.List"%>
<%@page import="Book.Book"%>
<%@page import="Book.BookBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
        <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <head>
        <title>Client Home Page</title>
        <%@ include file="../main.html" %>
    </head>
    
    <body id="page1">
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
                                <%
                                //parse session id variable to long type
                                Object attribute = request.getSession().getAttribute("userid");
                                long userId = Long.parseLong(String.valueOf(attribute));   
                                
                                int bokid = Integer.parseInt(request.getParameter("bok_id"));
                                //generate Books list
                                AvailabilityBean AvailabilitiesBean = new AvailabilityBean();
                                List<Availability> Availabilitylist = AvailabilitiesBean.getAvailability(bokid);  
                                pageContext.setAttribute("Availabilitylist1", Availabilitylist);
                                %>
<section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Borrow <%=request.getParameter("item_name")%>  from Library database</h3>

                                <div id="content3"> 
                                        <form id="form" name="form" action="../transferBook" method="post" OnSubmit="return fncSubmit();" >                    
                                        <fieldset><label><span class="text-form">Please Select a branch:</span>
                                            
                                            <select name="towarehouse" id="towrh_id">
                                            <c:forEach items="${Availabilitylist1}" var="avail1">
                                                <c:choose>
                                                    <c:when test="${avail1.itm_maxlimit == avail1.itm_quantity}"><option value="${avail1.item_id}" disabled><del>${avail1.cty_name} - ${avail1.brh_name} - ${avail1.wrh_name}</del> &nbsp; <i>warehouse is Full</i></option>
                                                    </c:when>

                                                    <c:otherwise>
                                                        <c:choose>
                                                            <c:when test="${avail1.item_id == item_id}">
                                                            </c:when>
                                                            <c:otherwise>
                                                            <option value="${avail1.item_id}">${avail1.cty_name} - ${avail1.brh_name} - ${avail1.wrh_name}</option>
                                                         </c:otherwise>
                                                        </c:choose>  
                                                    </c:otherwise>
                                              </c:choose>  
                                            </c:forEach> 
                                              
                                                
                                            </select>
                                            <br />
                                            <label><span class="text-form">Are you sure you want to transfer this item?</span></label>
                                            
                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        
                                                        <input type="hidden" name="item_id" value="<%=request.getParameter("item_id")%>" />
                                                        <input type="hidden" name="item_min" value="<%=request.getParameter("item_min")%>" />
                                                        <input type="submit" name="Submit" value="Confirm" class="button"  />
                                                        <a href="indexClient.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                                    </div> 
                                                </div>
                                            </div>                      
                                        </fieldset>						

                                    </form>

                                    
                                </div>
                            </div>
                        </article>

                    </div>
                </div>
            </section>     


            <!--==============================footer=================================-->
            <footer>
                <div class="inner">
                    <div class="footer-bg">
                        ISAE &copy; 2014
                    </div>
                </div>
            </footer>
        </div>
        <script type="text/javascript"> Cufon.now();</script>
    </body>
</html>



