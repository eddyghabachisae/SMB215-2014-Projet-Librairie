<%@page import="country.*"%>
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
        <title>Add a Province</title>
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

        if(document.form.provincename.value == "")
        {
        alert('province name field could not be empty');
        document.form.provincename.focus();
        return false;
        } 

        if(document.form.provincecode.value == "")
        {
        alert('province code field could not be empty');
        document.form.provincecode.focus(); 
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
                </div>
            </header>

            <!--==============================content================================-->
                                <%                               
                                //generate gender list
                                CountryBean countriesBean = new CountryBean();
                                List<Country> Countrieslist = countriesBean.getCountries();  
                                pageContext.setAttribute("Countrieslist1", Countrieslist);
                                %>
      
                                
            <section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Add a new Province to Library database</h3>

                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <!--div class="error_box"></div><div>error!</div-->

                                    <form id="form" name="form" action="../insertProvince" method="post" OnSubmit="return fncSubmit();" >                    
                                        <fieldset>
                                            
                                            <label><span class="text-form">Province Name </span><input type="text" class="inputText" name="provincename" value=""><% if (request.getParameter("existingprovincename") != null) { out.println("<b>The province you are trying to enter <br />already exists!</b>"); }%></label>
                                            <label><span class="text-form">Province Code: </span><input type="text" class="inputText" name="provincecode" value="" ></label>
                                           
                                            <label><span class="text-form">Country: </span>
                                            <select name="country" id="country">
                                            <c:forEach items="${Countrieslist1}" var="cnt1">
                                                <option value="${cnt1.id}" >${cnt1.name}</option>
                                            </c:forEach> 
                                            </select>
                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Add" class="button"  />
                                                        <a href="indexProvince.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
