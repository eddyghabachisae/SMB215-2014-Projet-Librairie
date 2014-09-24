<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
     <%
        if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
            response.sendRedirect("login.jsp");
        }
    %>
<%@ include file="../main.html" %>
<body id="page5">
	<div class="main">
        <!--==============================header=================================-->
        <header>
            <div class="container_12">
                <div class="wrapper">
                    <div class="grid_12">
                        <div class="wrapper border-bot">
                            <h1><a href="home.jsp">Library</a></h1>
                            <nav>
                                 <ul class="menu">
                                    <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                    <li><a href="">Logout</a></li>
                                </ul>
                            </nav>
                        </div>
                        
                    </div>
                </div>
            </div>
        </header>
        
        <!--==============================content================================-->
        <section id="content">
            <div class="container_12">
                <div class="wrapper">
                    <article class="grid_8">
                    	<div class="indent-right">
                        	<h3 class="prev-indent-bot">Item</h3>
                                <ul id="tabs">
                                    <li><a href="./GetItem?id=<%=request.getParameter("item_id")%>" title="tab1" class="notActive">Main Info</a></li>
                                    <li><a href="./GetBook?id=<%=request.getParameter("book_id")%>" title="tab2" class="notActive">Book Info</a></li>
                                    <li><a href="#" title="tab2" class="activeTab">Book Status Info</a></li>
                                </ul>
                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>
                            <%
                             if(!request.getParameter("branchesListSize").equals("0"))
                             {
                            
                            %>       
                            
                            <form id="form" name="form" action="SaveBookStatus?id=<%=request.getParameter("id")%>" method="post" >                    
                                <fieldset>
                                    <input type="hidden" name="book_id" value="<%=request.getParameter("book_id")%>"/>
                                    <label><span class="text-form">Branch*</span>
                                          <select name="branch" id="branch" >
                                              <option value="" selected >Select</option>
                                            <c:forEach items="${branchesList}" var="branch">
					   <option value="${branch.id}">${branch.name}</option>
                                            </c:forEach>
                                          </select></label>
                                    <script>
                                                 if ("<%=request.getParameter("branch_id")%>" !== "") {
                                                     var val = <%=request.getParameter("branch_id")%>;
                                                     $('#branch').val(val);
                                                 }
                                                </script>
                                    <label><span class="text-form">Section* </span><input type="text" class="inputText" id="section" 
                                        name="section" value="<%=request.getParameter("section")%>"></label>
                                    <label><span class="text-form">Shelf* </span><input type="text" class="inputText" id="shelf" 
                                        name="shelf" value="<%=request.getParameter("shelf")%>"></label>
					<div class="wrapper">
                                        <div class="extra-wrap">		
                                            <div class="buttons">
							<input type="submit" name="Submit" value="Submit" class="button"/>
                                                        <a href="./GetItems"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
                                            </div> 
										
                                        </div>
										
                                      </div>                      
                                </fieldset>						
                            </form>
                                         <%}
                             else{
                            %>
                            <br>
                            <div class="emptyList_box">No Branches Available</div>
                            <%}%>
                            <%
                             if(!request.getParameter("sizeList").equals("0"))
                             {
                            
                            %>
                            <div class="CSSTableGenerator" >
                            <table>
                                <tbody>
                                    <tr>
                                        <td>Branch</td>
                                        <td>Section</td>
                                        <td>Shelf</td>
                                        <td>Reserved Copies</td>
                                        <td width="10%">Actions</td>
                                    </tr>
                                <c:forEach items="${bookStatusList}" var="bookStatus">
                                    <tr>
                                        <td>${bookStatus.getBranch().name}</td>
                                        <td>${bookStatus.section}</td>
                                        <td>${bookStatus.shelf}</td>
                                        <td>${bookStatus.reservedCopies}</td>
                                        <td>
                                            <a href="GetBookStatus?id=${bookStatus.id}" title="Edit" class="fa fa-lg fa-pencil-square-o"></a>
                                            <a href="DeleteBookStatus?id=${bookStatus.id}" tite="Delete" class="fa fa-lg fa-trash-o"></a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>        
                                </div>
                            <%}
                             else{
                            %>
                            <br>
                            <div class="emptyList_box">No Book Status Available</div>
                            <%}%>
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
	<script type="text/javascript"> Cufon.now(); </script>
</body>
<script type="text/javascript">

new FormValidator('form', [
{
    name:'branch',
    display: 'Branch',    
    rules: 'required'
},
{
    name:'section',
    display: 'Section',    
    rules: 'required'
},{
    name:'shelf',
    display: 'Shelf',    
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
        
        SELECTOR_SUCCESS.css({ display: 'none' });
        SELECTOR_ERRORS.fadeIn(200);
    } else {
        SELECTOR_ERRORS.css({ display: 'none' });
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