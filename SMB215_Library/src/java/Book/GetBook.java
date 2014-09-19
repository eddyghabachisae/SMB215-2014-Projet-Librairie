package Book;


import Author.Author;
import Author.AuthorBean;
import BookCategory.BookCategory;
import BookCategory.BookCategoryBean;
import BookStatus.BookStatus;
import BookStatus.BookStatusBean;
import Language.Language;
import Language.LanguageBean;
import branch.Branch;
import branch.BranchBean;
import static com.sun.mail.imap.protocol.INTERNALDATE.format;
import itemCategory.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetBook", urlPatterns = {"/GetBook"})
public class GetBook extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null){
            BookBean bookBean = new BookBean();
            Book book = bookBean.getBook(Integer.valueOf(request.getParameter("id")));
             LanguageBean langBean = new LanguageBean();
           // List<Language> LanguagesList = langBean.getLanguage();
            //request.setAttribute("LanguagesList", LanguagesList);
            BookCategoryBean bookCatBean = new BookCategoryBean();
            List<BookCategory> bookCategoriesList = bookCatBean.getBookCategories();
            request.setAttribute("bookCategoriesList", bookCategoriesList);
            AuthorBean authorBean = new AuthorBean();
            List<Author> authorsList = authorBean.getAuthors();
            request.setAttribute("authorsList", authorsList);
            BranchBean branchBean = new BranchBean();
            List<Branch> branchesList = branchBean.getBranchesList();
            request.setAttribute("branchesList", branchesList);
            BookStatusBean bookStatusBean = new BookStatusBean();
            BookStatus bookStatus = bookStatusBean.getBookStatus(book.getBookStatus_id());
            String publishDate="";
            System.err.print(book.toString());
            if(book!=null && book.getPublishDate()!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.err.print("publish dateeee"+book.getPublishDate());
             publishDate = sdf.format(book.getPublishDate());
            }
             request.getRequestDispatcher("Book/bookForm.jsp?"
                     +"id"+book.getId()
                     +"&title=" + book.getTitle()
                     +"&subtitle=" + book.getSubtitle()
                     +"&isbn=" + book.getIsbn()
                     +"&publisher="+book.getPublisher()
                     +"&publishDate="+publishDate
                     +"&pagesNb="+book.getPagesNb()
                     +"&language_id="+book.getLanguage_id()
                     +"&bookCategory_id="+book.getBookCategory_id()
                     +"&author_id="+book.getAuthor_id()
                     +"&item_id="+book.getItem_id()
                     +"&bookStatus_id="+book.getBookStatus_id()
                     +"&branch_id="+bookStatus.getBranch_id()
                     +"&section="+bookStatus.getSection()
                     +"&shelf="+bookStatus.getShelf()).forward(request, response);
        } else {
            BookBean bookBean = new BookBean();
            BookCategoryBean bookCatBean = new BookCategoryBean();
            List<BookCategory> bookCategoriesList = bookCatBean.getBookCategories();
            request.setAttribute("bookCategoriesList", bookCategoriesList);
            AuthorBean authorBean = new AuthorBean();
            List<Author> authorsList = authorBean.getAuthors();
            System.err.println("listttt:"+authorsList.size());
            request.setAttribute("authorsList", authorsList);
            BranchBean branchBean = new BranchBean();
            List<Branch> branchesList = branchBean.getBranchesList();
            request.setAttribute("branchesList", branchesList);
            System.err.println("item iddd:"+request.getParameter("item_id"));
                request.getRequestDispatcher("Book/bookForm.jsp?" 
                     +"id=&title=&subtitle=&isbn=&publisher=&publishDate=&pagesNb=&bookCategory_id=&bookAuthor_id=&item_id="+request.getParameter("item_id")+"&bookStatus_id=&section=&shelf=&branch_id="+request.getParameter("item_id")+"&bookStatus_id=").forward(request, response);
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
