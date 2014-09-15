<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../main.html" %>
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
                                    <li><a href="#" title="tab1" class="notActive">Main Info</a></li>
                                    <li><a href="#" title="tab2" class="activeTab">Book Info</a></li>
                                </ul>
                                <div id="content3"> 
                                    <div class="success_box">All of the fields were successfully validated!</div>
                                    <div class="error_box"></div>
                                   
                            <form id="form" name="form" action="../SaveBook?id=<%=request.getParameter("id")%>" method="post" enctype="multipart/form-data">                    
                                <fieldset>
                                      <label><span class="text-form">Title* </span><input type="text" class="inputText" id="title" 
                                             name="name" value=""></label>
                                      <label><span class="text-form">SubTitle </span><input type="text" class="inputText" id="subtitle" 
                                        name="subtitle" value=""></label>
                                      <label><span class="text-form">ISBN </span><input type="text" class="inputText" id="isbn" 
                                        name="isbn" value=""></label>
                                      <label><span class="text-form">Publisher* </span><input type="text" class="inputText" id="publisher" 
                                        name="publisher" value=""></label>
                                      <label><span class="text-form">Publish Date* </span><input type="text" class="inputText" id="publishDate" 
                                        name="publishDate" value=""></label>
                                      <label><span class="text-form">Pages Number* </span><input type="text" class="inputText" id="pagesNb" 
                                        name="pagesNb" value=""></label>
                                      <label><span class="text-form">Language*</span>
                                          <select name="language" ><option value="1">Select</option>
                                            <c:forEach items="${itemCategoryList}" var="itemCat">
					   <option value="${itemCat.id}">${itemCat.code}</option>
                                            </c:forEach>
                                          </select></label>
                                     <label><span class="text-form">Category*</span>
                                          <select name="language" ><option value="1">Select</option>
                                            <c:forEach items="${itemCategoryList}" var="itemCat">
					   <option value="${itemCat.id}">${itemCat.code}</option>
                                            </c:forEach>
                                          </select></label>
                                     <label><span class="text-form">Author*</span>
                                          <select name="language" ><option value="1">Select</option>
                                            <c:forEach items="${itemCategoryList}" var="itemCat">
					   <option value="${itemCat.id}">${itemCat.code}</option>
                                            </c:forEach>
                                          </select></label>
					<div class="wrapper">
                                        <div class="extra-wrap">		
                                            <div class="buttons">
							<input type="submit" name="Submit" value="Submit" class="button"/>
                                                        <a href="../GetItems"><input type="button" name="Cancel" value="Cancel" class="button"/></a>
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
    name: 'publishDate',
    display: 'Publish Date',    
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