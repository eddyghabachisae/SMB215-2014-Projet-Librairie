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

        if(document.form.username.value == "")
        {
        alert('username field could not be empty');
        document.form.username.focus();
        return false;
        } 

        if(document.form.firstname.value == "")
        {
        alert('first name field could not be empty');
        document.form.firstname.focus(); 
        return false;
        } 

        if(document.form.lastname.value == "")
        {
        alert('first name field could not be empty');
        document.form.lastname.focus(); 
        return false;
        } 

        if(document.form.email.value == "")
        {
        alert('email field could not be empty');
        document.form.email.focus(); 
        return false;
        } 
        
        if(document.form.mobile.value == "")
        {
        alert('mobile field could not be empty');
        document.form.mobile.focus(); 
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
                                //parse session id variable to long type
                                Object attribute = request.getSession().getAttribute("userid");
                                long orgId = Long.parseLong(String.valueOf(attribute));   
                                
                                // query client data using a session id        
                                ClientBean cltBean = new ClientBean();
                                Client clt1 = cltBean.getClient(orgId);
                                int testgen = clt1.getGender();
                                // Get Gender information
                                GenderBean genBean = new GenderBean();
                                Gender gen = genBean.getGender(clt1.getGender()); 
                                
                                //generate gender list
                                GetGendersBean gendersBean = new GetGendersBean();
                                List<Gender> Genderslist = gendersBean.getGenders();  
                                pageContext.setAttribute("Genderslist1", Genderslist);
                                
                                 //generate Martial list
                                GetMaritalsBean MaritalsBean = new GetMaritalsBean();
                                List<Marital> Maritalslist = MaritalsBean.getMaritals();  
                                pageContext.setAttribute("Maritalslist1", Maritalslist);      
                                
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
                                    <!--div class="error_box"></div><div>error!</div-->

                                    <form id="form" name="form" action="../SaveClient" method="post" OnSubmit="return fncSubmit();">                    
                                        <fieldset>
                                            <input type="hidden" name="id" value="<%=request.getSession().getAttribute("userid")%>">

                                            <label><span class="text-form">Username: </span><input type="text" class="inputText" name="username" value="<%=clt1.getUsername()%>"><% if (request.getParameter("existingusername") != null) { out.println("<b>The username you chose already taken!</b>"); }%></label>
                                            <label><span class="text-form">First Name: </span><input type="text" class="inputText" name="firstname" value="<%=clt1.getFirstname()%>"></label>
                                            <label><span class="text-form">Last Name: </span><input type="text" class="inputText" name="lastname" value="<%=clt1.getLastname()%>"></label>
                                            
                                            <label><span class="text-form">Gender: </span>
                                            <select name="gender" id="gender"><%=clt1.getGender()%>"
                                            <c:forEach items="${Genderslist1}" var="gen1">                                                    
                                               <c:set var="usergen" value="<%=clt1.getGender()%>"/>
                                               <option value="${gen1.id}" <c:if test="${gen1.id == usergen}">selected="selected"</c:if>>${gen1.gender}</option>
                                            </c:forEach> 
                                            </select>
                                            </label>     
                                            <label><span class="text-form">Marital Status:</span>
                                            <select name="marital" id="marital"><%=clt1.getMaritalstatus()%>"
                                            <c:forEach items="${Maritalslist1}" var="mar1">                                                    
                                               <c:set var="usermar" value="<%=clt1.getMaritalstatus()%>"/>
                                               <option value="${mar1.id}" <c:if test="${mar1.id == usermar}">selected="selected"</c:if>>${mar1.marital}</option>
                                            </c:forEach> 
                                            </select> 
                                            </label>
                                            <label><span class="text-form">Date of Birth </span>
                                            <% SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
                                            String DOB=formatter.format(clt1.getDateofbirth());%>

                                                <input type="Text" class="inputText" name="timestamp" value="<%=DOB%> "><a href="javascript:show_calendar('document.form.timestamp', document.form.timestamp.value );"><img src="../javascript/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date of birth"></a></label>
                                            <label><span class="text-form">Address: </span><textarea class="inputText" name="address"><%=clt1.getAddress()%> </textarea></label>
                                            <label><span class="text-form">Phone: </span><input type="text" class="inputText" name="phone" value="<%=clt1.getPhone()%>"> </label>
                                            <label><span class="text-form">Mobile: </span><input type="text" class="inputText" name="mobile" value="<%=clt1.getMobile()%>"></label>
                                            <label><span class="text-form">Email: </span><input type="text" class="inputText" name="email" value="<%=clt1.getEmail()%>"> </label>
                                            <label><span class="text-form">Remarks: </span><textarea class="inputText" name="remarks"><%=clt1.getRemarks()%> </textarea></label> 
                                           
                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button"  />
                                                        <a href="indexClient.jsp"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
   
</html>
