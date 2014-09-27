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
                              
        <script language="javascript">
        function fncSubmit()
        {

        if(document.ChangePasswordForm.OldPassword.value == "")
        {
        alert('your old password field is empty, please input old password');
        document.ChangePasswordForm.OldPassword.focus();
        return false;
        } 

        if(document.ChangePasswordForm.newpassword.value == "")
        {
        alert('your new  password field is empty, please input new password');
        document.ChangePasswordForm.newpassword.focus(); 
        return false;
        } 

        if(document.ChangePasswordForm.conpassword.value == "")
        {
        alert('your confirmation  password field is empty, please confirm password');
        document.ChangePasswordForm.conpassword.focus(); 
        return false;
        } 

        if(document.ChangePasswordForm.newpassword.value != document.ChangePasswordForm.conpassword.value)
        {
        alert('Confirmation of Passwords dows not Match');
        document.ChangePasswordForm.conpassword.focus(); 
        return false;
        } 

        document.ChangePasswordForm.submit();
        }
        </script>
        <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <div class="indent-right">
                                <h3 class="prev-indent-bot">Change Password Form</h3>
                                <div id="content3"> 
                                <form id="ChangePasswordForm" name="ChangePasswordForm" method="post" action="../UpdatePassword" OnSubmit="return fncSubmit();">
                                    <fieldset>
                                      <label><span class="text-form">type your old password: </span><input name="OldPassword" type="password" id="OLDpwd"><% if (request.getParameter("wrongoldpassword") != null) { out.println("<b>your old password is wrong!</b>!"); }%></label><br />   
                                      <label><span class="text-form">type your new password: </span><input name="newpassword" type="password" id="newpassword"></label><br />
                                      <label><span class="text-form">confirm your new password: </span><input name="conpassword" type="password" id="conpassword"></label><br /> 
                                    </fieldset>           
                                <table border="1" align="center" bgcolor="#2B60DE">
                                     
                                </form>
                                    
                               <div class="wrapper">
                                    <div class="extra-wrap">		
                                        <div class="buttons">
                                            <input type="submit" name="Submit" value="update" class="button"  />
                                            <a href="indexClient.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                        </div> 

                                    </div>    
                                </div>
                            </div>
                            </div>
                        </article>

                    </div>
                </div>
            <!--==============================footer=================================-->

        </div>   
         
        <script type="text/javascript"> Cufon.now();</script>
    </h:body>
</html>



