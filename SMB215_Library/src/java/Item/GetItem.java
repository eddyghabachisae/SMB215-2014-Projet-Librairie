package Item;

import Book.Book;
import Book.BookBean;
import itemCategory.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetItem", urlPatterns = {"/GetItem"})
public class GetItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            ItemBean itmBean = new ItemBean();
            Item item = itmBean.getItem(Integer.valueOf(request.getParameter("id")));
            ItemCategoryBean itc = new ItemCategoryBean();
            List<ItemCategory> itemCategoryList = itc.getItemCategories();
            System.err.print("sizeee: "+itemCategoryList.size());
            request.setAttribute("itemCategoryList", itemCategoryList);
            BookBean bookBean = new BookBean();
            Book book = bookBean.getBookFormItem(item.getId());
            boolean isBook = false;
            if(book!=null && book.getItem_id()== item.getId())
                isBook = true;
            request.getRequestDispatcher("Item/itemForm.jsp?" 
                     +"id=" + item.getId()
                     +"&name=" + item.getName()
                     +"&imgPath=" + item.getImgPath()
                     +"&saleRentPrice="+item.getSaleRentPrice()
                     +"&minLimit="+item.getMinLimit()
                     +"&maxLimit="+item.getMaxLimit()
                     +"&available="+item.getIsAvailable()
                     +"&active="+item.getIsActive()
                     +"&category="+item.getItemCategory_id()
                     +"&description="+item.getDescription()
                     +"&book="+isBook
                     +"&book_id="+book.getId()).forward(request, response);
        } else {
            ItemCategoryBean itc = new ItemCategoryBean();
            List<ItemCategory> itemCategoryList = itc.getItemCategories();
            System.err.print("sizeee: "+itemCategoryList.size());
            request.setAttribute("itemCategoryList", itemCategoryList);
            request.getRequestDispatcher("Item/itemForm.jsp?" 
                     +"id=&name=&imgPath=&saleRentPrice=&minLimit=&maxLimit=&available=&active=&category=&description=&book=").forward(request, response);
         }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
