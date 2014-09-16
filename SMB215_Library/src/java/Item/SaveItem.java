/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Item;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Douha
 */
public class SaveItem extends HttpServlet {

    
    private final String UPLOAD_DIRECTORY = "C:/Users/Douha/Documents/NetBeansProjects/LibraryLatest/web/public/images/itemImages";
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.err.println("fet 3al get");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.err.println("fet 3al post");
        Item item = new Item();
         System.err.println("fet la honnnn");
        System.err.println("request: "+request.getParameter("name"));
        item.setName(request.getParameter("name"));
        item.setDescription(request.getParameter("description"));
        item.setAvgUnitCost(Double.parseDouble(request.getParameter("avgCost")));
        item.setSaleRentPrice(Double.parseDouble(request.getParameter("saleRentPrice")));
        item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        item.setMinLimit(Integer.parseInt(request.getParameter("minLimit")));
        item.setMaxLimit(Integer.parseInt(request.getParameter("maxLimit")));
        item.setIsAvailable(Boolean.parseBoolean(request.getParameter("available")));
        item.setIsActive(Boolean.parseBoolean(request.getParameter("active")));
        item.setItemCategory_id(Long.parseLong(request.getParameter("category")));
        ItemBean itemBean = new ItemBean();
        System.err.println("itemmmm: "+item.toString());
        
        
        if(ServletFileUpload.isMultipartContent(request)){

            try {

                List<FileItem> multiparts = new ServletFileUpload(

                                         new DiskFileItemFactory()).parseRequest(request);

               

                for(FileItem file : multiparts){

                    if(!file.isFormField()){

                        String name = new File(file.getName()).getName();

                        file.write( new File(UPLOAD_DIRECTORY + "/"+ name));

                    }

                }

            

               //File uploaded successfully
                System.err.print("File Uploaded Successfully");

            } catch (Exception ex) {
                System.err.print("File Upload Failed due to " + ex);

            }         

          

        }else{
            System.err.print("Sorry this Servlet only handles file upload request");
           

        }

        if (request.getParameter("id")!=null) {
            System.err.println("fet 3al ifff");
            item.setId(Long.parseLong(request.getParameter("id")));
            itemBean.modifyItem(item);
            response.sendRedirect("GetItems");
        } else {
            System.err.println("fet 3al elseee");
            itemBean.addItem(item);
            response.sendRedirect("GetItems");
        }
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