<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../main.html" %>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
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
                                    <li><a class="active" href="${pageContext.request.contextPath}/home.jsp">Main</a></li>
                                    <li><a href="">Inbox</a></li>
                                    <li><a href="">Logout</a></li>
                                </ul>
                            </nav>
                        </div>
                        
                    </div>
                </div>
            </div>
        </header>
        
        <!--==============================content================================-->
        <section id="content"><div class="ic"><div class="inner_copy">All <a href="http://www.magentothemesworld.com" title="Best Magento Templates">premium Magento themes</a> at magentothemesworld.com!</div></div>
            <div class="container_12">
                <div class="wrapper">
                    <article class="grid_8">
                    	<div class="indent-right">
                        	<h3 class="prev-indent-bot">Item</h3>
                                <ul id="tabs">
                                    <li><a href="./GetItem?id=<%=request.getParameter("item_id")%>" title="tab1" class="notActive">Main Info</a></li>
                                    <li><a href="#" title="tab2" class="activeTab">Book Info</a></li>
                                    <li><a href="./GetBookStatus?book_id=<%=request.getParameter("id")%>&id=" title="tab2" class="notActive">Book Status Info</a></li>
                                </ul>
                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>
                                   
                            
                            <form id="form" name="form" action="SaveBook?id=<%=request.getParameter("id")%>" method="post" >                    
                                <fieldset>
                                    <input type="hidden" name="item_id" value="<%=request.getParameter("item_id")%>"/>
                                 
                                      <label><span class="text-form">Title* </span><input type="text" class="inputText" id="title" 
                                             name="title" value="<%=request.getParameter("title")%>"></label>
                                      <label><span class="text-form">SubTitle </span><input type="text" class="inputText" id="subtitle" 
                                        name="subtitle" value="<%=request.getParameter("subtitle")%>"></label>
                                      <label><span class="text-form">ISBN </span><input type="text" class="inputText" id="isbn" 
                                        name="isbn" value="<%=request.getParameter("isbn")%>"></label>
                                      <label><span class="text-form">Publisher* </span><input type="text" class="inputText" id="publisher" 
                                        name="publisher" value="<%=request.getParameter("publisher")%>"></label>
                                      
                                        <label><span class="text-form">Publish Date </span><input type="text" class="inputText" id="datepicker"  
                                        name="publishDate" value="<%=request.getParameter("publishDate")%>"></label>
                                      <label><span class="text-form">Pages Number* </span><input type="text" class="inputText" id="pagesNb" 
                                        name="pagesNb" value="<%=request.getParameter("pagesNb")%>"></label>
                                        <label><span class="text-form">Rent Price* </span><input type="text" class="inputText" id="rentPrice" 
                                        name="rentPrice" value="<%=request.getParameter("rentPrice")%>"></label>
                                      <label><span class="text-form">Language*</span>
                                          <select name="language" id="language" >
                                              <option value="" selected >Select</option>
                                            <c:forEach items="${LanguagesList}" var="lang">
					   <option value="${lang.id}">${lang.code}</option>
                                            </c:forEach>
                                          </select></label>
                                    <script>
                                                 if ("<%=request.getParameter("language_id")%>" !== "") {
                                                     var val = <%=request.getParameter("language_id")%>;
                                                     $('#language').val(val);
                                                 }
                                                </script>
                                     <label><span class="text-form">Category*</span>
                                          <select name="category" id="category">
                                              <option value="" selected>Select</option>
                                            <c:forEach items="${bookCategoriesList}" var="bookCat">
					   <option value="${bookCat.id}">${bookCat.code}</option>
                                            </c:forEach>
                                          </select></label>
                                    <script>
                                                 if ("<%=request.getParameter("bookCategory_id")%>" !== "") {
                                                     var val = <%=request.getParameter("bookCategory_id")%>;
                                                     $('#category').val(val);
                                                 }
                                                </script>
                                     <label><span class="text-form">Author</span>
                                          <select name="author" id="author" >
                                              <option value="" selected>Select</option>
                                            <c:forEach items="${authorsList}" var="auth">
					   <option value="${auth.id}">${auth.name}</option>
                                            </c:forEach>
                                          </select></label>
                                    <script>
                                                 if ("<%=request.getParameter("author_id")%>" !== "") {
                                                     var val = <%=request.getParameter("author_id")%>;
                                                     $('#author').val(val);
                                                 }
                                                </script>
                                    
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
	<script type="text/javascript"> Cufon.now(); </script>
</body>
<script type="text/javascript">

new FormValidator('form', [{
    name: 'title',
    display: 'Title',    
    rules: 'required'
},
{
    name: 'publisher',
    display: 'Publisher',    
    rules: 'required'
},
{
    name: 'pagesNb',
    display: 'Page Number',    
    rules: 'required|numeric'
},{
    name: 'language',
    display: 'Language',    
    rules: 'required'
},{
    name: 'author',
    display: 'Author',    
    rules: 'required'
},{
    name:'category',
    display: 'Category',    
    rules: 'required'
},{
    name:'rentPrice',
    display: 'Rent Price',    
    rules: 'required|numeric'
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