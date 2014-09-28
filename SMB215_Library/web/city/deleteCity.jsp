<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
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
        
        <!Calendar Picker javascript>
        <script language="JavaScript" src="../javascript/ts_picker.js">

        //Script by Denis Gritcyuk: tspicker@yahoo.com
        //Submitted to JavaScript Kit (http://javascriptkit.com)
        //Visit http://javascriptkit.com for this script

        </script>
        <script language="javascript">
        function fncSubmit()
        {

        if(document.form.cityname.value == "")
        {
        alert('city name field could not be empty');
        document.form.cityname.focus();
        return false;
        } 

        if(document.form.citycode.value == "")
        {
        alert('city code field could not be empty');
        document.form.citycode.focus(); 
        return false;
        } 

        
        document.ChangePasswordForm.submit();
        }
        </script>
    </head>
    
    <body id="page5">
        <div class="main">
            <!--==============================header=================================-->
            <header>
                <div class="container_12">
                    <div class="wrapper">
                        <div class="grid_12">
                            <div class="wrapper border-bot">
                                <h1><a href="../home.jsp">Library</a></h1>
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
            </header>

            <!--==============================content================================-->
      
                                
            <section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Delete <%=request.getParameter("cit_name")%> city from Library database</h3>

                                <div id="content3"> 
                                        <form id="form" name="form" action="../deleteCity" method="post" OnSubmit="return fncSubmit();" >                    
                                        <fieldset>
                                            
                                            <label><span class="text-form">are you sure you want to delete?</span></label>
                                            
                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="hidden" name="cit_id" value="<%=request.getParameter("cit_id")%>" />
                                                        <input type="submit" name="Submit" value="delete" class="button"  />
                                                        <a href="indexCity.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
