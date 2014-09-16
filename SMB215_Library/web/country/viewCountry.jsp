<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <title>Settings</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../public/stylesheets/reset.css" type="text/css" media="screen">
    <link rel="stylesheet" href="../public/stylesheets/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="../public/stylesheets/grid.css" type="text/css" media="screen">   
    <link rel="stylesheet" href="../public/font-awesome-4.1.0/css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="../public/stylesheets/table.css" type="text/css" />
    <link rel="stylesheet" href="../public/stylesheets/pagination.css" type="text/css" />
    <link rel="stylesheet" href="../public/stylesheets/tabs.css" type="text/css">
    <script src="../public/javascripts/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="../public/javascripts/cufon-yui.js" type="text/javascript"></script>
    <script src="../public/javascripts/cufon-replace.js" type="text/javascript"></script>
    <script src="../public/javascripts/Asap_400.font.js" type="text/javascript"></script>
    <script src="../public/javascripts/Asap_italic_400.font.js" type="text/javascript"></script> 
    <!--- validation!--->
	<link rel="stylesheet" href="../public/stylesheets/validate.css" type="text/css" media="screen"> 
	<script type="text/javascript" src="../public/javascripts/jquery.min.js"></script>	
	<script type="text/javascript" src="../public/javascripts/validate.min.js"></script>
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
                                        <li><a class="active" href="../home.jsp">Main</a></li>
                                        <li><a href="">Inbox</a></li>
                                        <li><a href="">Logout</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <div class="clear"></div>
                </div>
            </header>

            <!--==============================content================================-->
            <section id="content"><div class="ic"></div>
                <div class="container_12">
                    <div class="wrapper">
                        <div class="pull-right">
                            <a href="editCountry.jsp"><input type="submit" name="Submit" value="Add" class="button"/></a>
                        </div>
                        <div class="clear2"></div>
                        <div class="CSSTableGenerator" >
                            <table >
                                <tbody>
                                    <tr>
                                        <td>Code</td>
                                        <td>Name</td>
                                        <td width="10%">Actions</td>
                                    </tr>

                                    <c:forEach items="${countries}" var="cnt">
                                        <tr>
                                            <td>${cnt.code}</td>
                                            <td>${cnt.name}</td>
                                            <td>
                                                <a href="GetCountry?id=${itc.id}">Modify</a>
                                                <a href="DeleteCountry?id=${itc.id}">Delete</a> 
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="clear"></div>
                        <div id="tnt_pagination">
                            <span class="disabled_tnt_pagination">Prev</span>
                            <a href="#1">1</a><a href="#2">2</a>
                            <a href="#3">3</a>
                            <span class="active_tnt_link">4</span>
                            <a href="#5">5</a>
                            <a href="#6">6</a>
                            <a href="#7">7</a>
                            <a href="#8">8</a>
                            <a href="#9">9</a>
                            <a href="#10">10</a>
                            <a href="#forwaed">Next</a></div>


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



