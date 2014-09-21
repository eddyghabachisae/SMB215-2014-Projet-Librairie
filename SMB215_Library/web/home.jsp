<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <% 
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
      response.sendRedirect("login.jsp");
        }
    %>
    <head>
        <title>Home</title>
        <%@ include file="homeMain.html" %>
    </head>

<body id="page1">
	<div class="main">
        <!--==============================header=================================-->
        <header>
            <div class="container_12">
                <div class="wrapper p3">
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
                <article class="grid_3">
                    <div class="box">
                       <a href="#" class="imgCenter"> <figure class="fa-5x fa fa-group blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Clients</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_3">
                    <div class="box">
					<a href="GetItems" class="imgCenter"> <figure class="fa-5x fa fa-book blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Items</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_3">
                    <div class="box">
					  <a href="GetSuppliers" class="imgCenter"> <figure class="fa-5x fa fa-suitcase blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Suppliers</strong>
                        </div>
                    </div>
                </article>
                <article class="grid_3">
                    <div class="box">
					   <a href="GetEmployees" class="imgCenter"> <figure class="fa-5x fa fa-cogs blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Employees</strong>
                        </div>
                    </div>
                </article>
				<article class="grid_3">
                    <div class="box">
					  <a href="#" class="imgCenter"> <figure class="fa-5x fa fa-archive blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Sales Order</strong>
                        </div>
                    </div>
                </article>
				<article class="grid_3">
                    <div class="box">
					   <a href="GetPOHeaders" class="imgCenter"> <figure class="fa-5x fa fa-truck blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Purshased-Order</strong>
                        </div>
                    </div>
                </article>
				<article class="grid_3">
                    <div class="box">
					   <a href="#" class="imgCenter"> <figure class="fa-5x fa fa-list-alt blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Rental orders</strong>
                        </div>
                    </div>
                </article>
				<article class="grid_3">
                    <div class="box">
					  <a href="settings.jsp" class="imgCenter"> <figure class="fa-5x fa fa-cog blueColor"></figure></a>
                        <div class="padding">
                            <strong class="title-3 textCenter">Settings</strong>
                        </div>
                    </div>
                </article>
                <div class="clear"></div>
            </div>
        </header>
        
   
        
        
        <!--==============================footer=================================-->
        <footer>
        	<div class="inner">
            	<div class="footer-bg">
                	ISAE &copy; 2014
                    
                </div>
            </div>
        </footer>
    </div>
	<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>

