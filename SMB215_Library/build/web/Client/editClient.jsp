<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Client.*"%>
<%@page import="gender.*"%>
<%@page import="Marital.*"%>
<!DOCTYPE html>
<html lang="en">
        <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <head>
        <title>Edit My Profile</title>
        <%@ include file="../main.html" %>

    </head>
    
    <body id="page5">
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <div class="container_12">
                    <div class="wrapper">
                        <div class="grid_12">
                            <div class="wrapper border-bot">
                                <h1><a href="index.html">Library</a></h1>
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
                </div>
            </header>

            <!--==============================content================================-->
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
                                
            <section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Update my profile information</h3>

                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <!--div class="error_box"></div><div>erroe!</div-->

                                    <form id="form" name="form" action="../SaveClient?id=<%=request.getSession().getAttribute("userid")%>" method="post">                    
                                        <fieldset>
                                            <label><span class="text-form">Username: </span><input type="text" class="inputText" name="name" value="<%=clt1.getUsername()%>"></label>
                                            <label><span class="text-form">First Name: </span><input type="text" class="inputText" name="website" value="<%=clt1.getFirstname()%>"></label>
                                            <label><span class="text-form">Last Name: </span><input type="text" class="inputText" name="remarks" value="<%=clt1.getLastname()%>"></label>
                                            <label><span class="text-form">Gender: </span><input type="text" class="inputText" name="name" value="<%=gen.getGender()%> "></label>
                                            <label><span class="text-form">Marital Status: </span><input type="text" class="inputText" name="website" value="<%=mar.getMarital()%>"></label>
                                            <label><span class="text-form">Address: </span><textarea class="inputText" name="remarks"><%=clt1.getAddress()%> </textarea></label>
                                            <label><span class="text-form">Phone: </span><input type="text" class="inputText" name="remarks" value="<%=clt1.getPhone()%>"> </label>
                                            <label><span class="text-form">Mobile: </span><input type="text" class="inputText" name="remarks" value="<%=clt1.getMobile()%>"></label>
                                            <label><span class="text-form">Email: </span><input type="text" class="inputText" name="remarks" value="<%=clt1.getEmail()%>"> </label>
                                            <label><span class="text-form">Remarks: </span><textarea class="inputText" name="remarks"><%=clt1.getRemarks()%> </textarea></label> 
                                           
                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button"  />
                                                        <a href="../ViewProfile"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                                    </div> 

                                                </div>

                                            </div>                      
                                        </fieldset>						

                                    </form-->
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
    <!--script type="text/javascript">
      new FormValidator('form', [{
                username: 'name',
                display: 'Name',
                rules: 'required'
            }
        ], function(errors, event) {
            var SELECTOR_ERRORS = $('.error_box'),
                    SELECTOR_SUCCESS = $('.success_box');

            if (errors.length > 0) {
                SELECTOR_ERRORS.empty();

                for (var i = 0, errorLength = errors.length; i < errorLength; i++) {
                    SELECTOR_ERRORS.append(errors[i].message + '<br />');
                }

                SELECTOR_SUCCESS.css({display: 'none'});
                SELECTOR_ERRORS.fadeIn(200);
            } else {
                SELECTOR_ERRORS.css({display: 'none'});
                SELECTOR_SUCCESS.fadeIn(200);
                document.getElementById("form").submit();
            }

            if (event && event.preventDefault) {
                event.preventDefault();
            } else if (event) {
                event.returnValue = false;
            }
        });
    </script -->
</html>
