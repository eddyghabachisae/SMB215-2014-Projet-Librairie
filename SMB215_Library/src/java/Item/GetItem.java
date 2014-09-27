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
import library.Library;
import library.LibraryBean;

@WebServlet(name = "GetItem", urlPatterns = {"/GetItem"})
public class GetItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            LibraryBean libraryBean = new LibraryBean();
            Library library = libraryBean.getLibrary();
            String currency = "";
            if(library!=null){
             currency = library.getMainCurrency();
            }
        if (request.getParameter("id") != null){
            ItemBean itmBean = new ItemBean();
            Item item = itmBean.getItem(Integer.valueOf(request.getParameter("id")));
            ItemCategoryBean itc = new ItemCategoryBean();
            List<ItemCategory> itemCategoryList = itc.getItemCategories();
            request.setAttribute("itemCategoryList", itemCategoryList);
            Item  item2 =itmBean.getLatestItem();
            long  nextBarcodeNb = item2.getId()+1;
            BookBean bookBean = new BookBean();
            Book book = bookBean.getBookFormItem(item.getId());
            boolean isBook = false;
            long book_id =0;
            if(book!=null && book.getItem_id()== item.getId()){
                isBook = true;
                book_id = book.getId();
            }
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
                     +"&book_id="+book_id
                     +"&barcode="+item.getBarcode()
                     +"&nextBarcodeNb="+nextBarcodeNb
                     +"&AvgPrice="+item.getAvgUnitCost()
                     +"&currency="+currency).forward(request, response);
        } else {
            ItemCategoryBean itc = new ItemCategoryBean();
            List<ItemCategory> itemCategoryList = itc.getItemCategories();
            ItemBean itmBean = new ItemBean();
            Item  item =itmBean.getLatestItem();
            long  nextBarcodeNb = item.getId()+1;
            System.err.println("nextBarcodeNb:"+nextBarcodeNb);
            request.setAttribute("itemCategoryList", itemCategoryList);
            
            request.getRequestDispatcher("Item/itemForm.jsp?" 
                    +"id=&name=&imgPath=&saleRentPrice=&minLimit=&maxLimit=&available=&active=&category=&description=&book=&barcode=&nextBarcodeNb="+nextBarcodeNb+"&AvgPrice=&currency="+currency).forward(request, response);
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
