package BookStatus;

import Book.Book;
import Book.BookBean;
import branch.Branch;
import branch.BranchBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetBookStatus", urlPatterns = {"/GetBookStatus"})
public class GetBookStatus extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            List<BookStatus> bookStatusList = new ArrayList();
         if (request.getParameter("id") != null && !request.getParameter("id").equals("") && !request.getParameter("id").equals("0")){
           
             BranchBean branchBean = new BranchBean();
            List<Branch> branchesList = branchBean.getBranchesList();
            BookStatusBean bookStatusBean = new BookStatusBean();
           
            Long id= Long.parseLong(request.getParameter("id"));
            BookStatus bookStatus = bookStatusBean.getBookStatus(id);
            Branch branch = branchBean.getBranch(bookStatus.getBranch_id());
            branchesList.add(branch);
            request.setAttribute("branchesList", branchesList);
            bookStatusList = bookStatusBean.getBookStatuss(bookStatus.getBook_id());
            request.setAttribute("bookStatusList", bookStatusList);
            for(BookStatus bookstat:bookStatusList)
            {
              Branch branch2=branchBean.getBranch(bookstat.getBranch_id());
              branchesList.remove(branch);
             }
            int branchesListSize= 0;
            branchesListSize = branchesList.size();
            String branchName = bookStatus.getBranch().getName();
            request.getRequestDispatcher("BookStatus/bookStatusForm.jsp?" 
                     +"id="+bookStatus.getId()+"&branch_id="+bookStatus.getBranch_id()+"&branchName="+branchName+"&section="+bookStatus.getSection()+"&shelf="+bookStatus.getShelf()+"&book_id="+bookStatus.getBook_id()+"&item_id"+bookStatus.getBook().getItem_id()+"&sizeList="+bookStatusList.size()+"&branchesListSize="+branchesListSize).forward(request, response);
            }
            else{
                BranchBean branchBean = new BranchBean();
                List<Branch> branchesList = branchBean.getBranchesList();
                BookStatusBean bookStatusBean = new BookStatusBean();
                bookStatusList = bookStatusBean.getBookStatuss(Long.parseLong(request.getParameter("book_id")));
                request.setAttribute("bookStatusList", bookStatusList);
                for(BookStatus bookstat:bookStatusList)
                {
                Branch branch=branchBean.getBranch(bookstat.getBranch_id());
                branchesList.remove(branch);
                }
            
                int branchesListSize= branchesList.size();
                request.setAttribute("bookStatusList", bookStatusList);
                request.setAttribute("branchesList", branchesList);
                BookBean bookBean = new BookBean();
                Book book = bookBean.getBook(Long.parseLong(request.getParameter("book_id")));
                System.err.println("size la list"+bookStatusList.size());
                request.getRequestDispatcher("BookStatus/bookStatusForm.jsp?" 
                         +"id=&branch_id=&section=&shelf=&book_id="+request.getParameter("book_id")+"&item_id="+book.getItem_id()+"&sizeList="+bookStatusList.size()+"&branchesListSize="+branchesListSize).forward(request, response);

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
