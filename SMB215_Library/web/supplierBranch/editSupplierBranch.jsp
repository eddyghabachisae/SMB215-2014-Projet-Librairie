<%@page import="province.ProvinceBean"%>
<%@page import="province.Province"%>
<%@page import="city.CityBean"%>
<%@page import="city.City"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <%@ include file="../main.html" %>
    <script type="text/javascript">
        function validateisactive() {

            if (document.getElementById('isactive').checked) {
                document.getElementById('deactivationlabel').style.display = 'none';
                document.getElementById('deactivationreason').value = '';
                document.getElementById('deactivationreason').style.display = 'none';
            } else {
                document.getElementById('deactivationlabel').style.display = 'block';
                document.getElementById('deactivationreason').style.display = 'block';
            }
        }

        function refreshprovinces() {
            var country = document.getElementById('country').value;
            document.getElementById('province').value = '';
            document.getElementById('city').value = '';
            if (country === '') {
                document.getElementById('province').disabled = true;
                document.getElementById('city').disabled = true;
            } else {
                document.getElementById('province').disabled = false;
                for (var i = 1; i <= document.getElementById('province').length - 1; i++) {
                    if (document.getElementById('province').options[i].className !== country) {
                        document.getElementById('province').options[i].hidden = true;
                    } else {
                        document.getElementById('province').options[i].hidden = false;
                    }
                }
            }
        }

        function refreshcities() {

            var province = document.getElementById('province').value;
            document.getElementById('city').value = '';
            if (province === '') {
                document.getElementById('city').disabled = true;
            } else {
                document.getElementById('city').disabled = false;
                for (var i = 1; i <= document.getElementById('city').length - 1; i++) {
                    if (document.getElementById('city').options[i].className !== province) {
                        document.getElementById('city').options[i].hidden = true;
                    } else {
                        document.getElementById('city').options[i].hidden = false;
                    }
                }
            }

        }
    </script>
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
                                        <li><a class="active" href="../home.jsp">Main</a></li>
                                        <li><a href="">Logout</a></li>
                                    </ul>
                                </nav>
                            </div>

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

                                <h3 class="prev-indent-bot">Supplier Branch</h3>
                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>


                                    <form id="form" name="form" action="../SaveSupplierBranch?id=<%=request.getParameter("id")%>" method="post">                    

                                        <fieldset>

                                            <label><span class="text-form">Name* </span><input type="text" class="inputText" name="name" value="<%=request.getParameter("name")%>"></label>
                                            <label><span class="text-form">Contact Name </span><input type="text" class="inputText" name="contactname" value="<%=request.getParameter("contactname")%>"></label>

                                            <label><span class="text-form">Country* </span>
                                                <select id="country" onchange="refreshprovinces()">
                                                    <option value="">Select</option>
                                                    <c:forEach items="${countries}" var="cnt">
                                                        <option value="${cnt.id}">${cnt.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>

                                            <label><span class="text-form">Province* </span>
                                                <select id="province" disabled onchange="refreshcities()">
                                                    <option value="">Select</option>
                                                    <c:forEach items="${provinces}" var="pvc">
                                                        <option class="${pvc.country}" value="${pvc.id}">${pvc.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>

                                            <label><span class="text-form">City* </span>
                                                <select id="city" disabled>
                                                    <option value="">Select</option>
                                                    <c:forEach items="${cities}" var="cty">
                                                        <option class="${cty.province}" value="${cty.id}">${cty.name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </label>


                                            <label><span class="text-form">Address </span><textarea class="inputText" name="address"><%=request.getParameter("address")%></textarea></label>
                                            <label><span class="text-form">Phone </span><input type="text" class="inputText" name="phone" value="<%=request.getParameter("phone")%>"></label>
                                            <label><span class="text-form">Contact Fax </span><input type="text" class="inputText" name="fax" value="<%=request.getParameter("fax")%>"></label>        
                                            <label><span class="text-form">Mobile </span><input type="text" class="inputText" name="mobile" value="<%=request.getParameter("mobile")%>"></label>
                                            <label><span class="text-form">Email </span><input type="text" class="inputText" name="email" value="<%=request.getParameter("email")%>"></label>
                                            <label><span class="text-form">Remarks </span><textarea class="inputText" name="remarks"><%=request.getParameter("remarks")%></textarea></label>
                                            <label><span class="text-form">Active?</span>
                                                <input type="checkbox" id="isactive" name="isactive" 
                                                       onchange="validateisactive()">
                                            </label>
                                            <label id="deactivationlabel"><span class="text-form">Deactivation reason </span><textarea class="inputText" name="deactivationreason" id="deactivationreason"><%=request.getParameter("deactivationreason")%></textarea></label>



                                            <div class="wrapper">
                                                <div class="extra-wrap">		
                                                    <div class="buttons">
                                                        <input type="submit" name="Submit" value="Submit" class="button"  />
                                                        <a href="../GetSupplierBranches?id="<%=request.getParameter("supplier")%>><input type="button" name="Cancel" value="Cancel" class="button"/></a>
           a                                         </div> 

                                                </div>

                                            </div>                      
                                        </fieldset>						
                                        <script>
                                            <% if (request.getParameter("id").equals("")
                                                        || request.getParameter("isactive").equals("true")) {%>
                                            document.getElementById('isactive').checked = true;
                                            validateisactive();
                                            <%}%>
                                        </script>
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
    <script type="text/javascript">

        new FormValidator('form', [{
                name: 'name',
                display: 'Name',
                rules: 'required'
            }, {
                name: 'city',
                display: 'city',
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
    </script>
</html>
