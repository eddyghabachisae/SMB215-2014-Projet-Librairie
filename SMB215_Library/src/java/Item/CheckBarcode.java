/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Item;

import Book.Book;
import Book.BookBean;
import itemCategory.ItemCategory;
import itemCategory.ItemCategoryBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import library.Library;
import library.LibraryBean;

/**
 *
 * @author Douha
 */
@WebServlet(name = "CheckBarcode", urlPatterns = {"/CheckBarcode"})
public class CheckBarcode extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       ItemBean itmBean = new ItemBean();
       List<Item> tempItemsList = itmBean.getItems();
       boolean isExist = true;
       if(tempItemsList.size()>0){
       for(Item item:tempItemsList){
           if(item.getBarcode()!=null)
           if(item.getBarcode().equals(request.getParameter("barcode")))
               isExist&=false;
       }
       }
       else{
           isExist = true;
       }
      
       LibraryBean libraryBean = new LibraryBean();
            Library library = libraryBean.getLibrary();
            String currency = "";
            if(library!=null){
             currency = library.getMainCurrency();
       System.err.println("id:"+request.getParameter("id"));
        if (request.getParameter("id")!= null && request.getParameter("id").equals("")==false){
            Item item = itmBean.getItem(Integer.valueOf(request.getParameter("id")));
            ItemCategoryBean itc = new ItemCategoryBean();
            List<ItemCategory> itemCategoryList = itc.getItemCategories();
            request.setAttribute("itemCategoryList", itemCategoryList);
            Item  item2 =itmBean.getLatestItem();
            long  nextBarcodeNb = item2.getId()+1;
            nextBarcodeNb = nextBarcodeNb+1;
            BookBean bookBean = new BookBean();
            Book book = bookBean.getBookFormItem(item.getId());
            boolean isBook = false;
            long book_id =0;
            if(book!=null && book.getItem_id()== item.getId()){
                isBook = true;
                book_id = book.getId();
            }
            if(isExist==true){
                item.setBarcode(request.getParameter("barcode"));
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
                     +"&isExist="+isExist
                     +"&AvgPrice="
                     +"&currency="+currency).forward(request, response);
        } else {
            ItemCategoryBean itc = new ItemCategoryBean();
            List<ItemCategory> itemCategoryList = itc.getItemCategories();
            List<Item> itemsList = itmBean.getItemsList();
            Item  item =itmBean.getLatestItem();
            long  nextBarcodeNb = item.getId()+1;
            request.setAttribute("itemCategoryList", itemCategoryList);
            if(isExist==true){
               request.getRequestDispatcher("Item/itemForm.jsp?" 
                     +"id=&name=&imgPath=&saleRentPrice=&minLimit=&maxLimit=&available=&active=&category=&description=&book=&barcode="+request.getParameter("barcode")+"&nextBarcodeNb="+nextBarcodeNb+"&AvgPrice=&isExist="+isExist+"&currency="+currency).forward(request, response);
        
           }
            else{
            request.getRequestDispatcher("Item/itemForm.jsp?" 
                     +"id=&name=&imgPath=&saleRentPrice=&minLimit=&maxLimit=&available=&active=&category=&description=&book=&barcode=&nextBarcodeNb="+nextBarcodeNb+"&AvgPrice=&isExist="+isExist+"&currency="+currency).forward(request, response);
        }
            }
            
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
