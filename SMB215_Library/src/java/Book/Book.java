package Book;

import java.sql.Date;



public class Book {

    private long id;
    private String title;
    private String subtitle;
    private String isbn;
    private String publisher;
    private Date publishDate;
    private int pagesNb;
    private long bookCategory_id;
    private long language_id;
    private long author_id;
    private long item_id;
    private long bookStatus_id;

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", subtitle=" + subtitle + ", isbn=" + isbn + ", publisher=" + publisher + ", publishDate=" + publishDate + ", pagesNb=" + pagesNb + ", bookCategory_id=" + bookCategory_id + ", language_id=" + language_id + ", author_id=" + author_id + ", item_id=" + item_id + ", bookStatus_id=" + bookStatus_id + '}';
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setPagesNb(int pagesNb) {
        this.pagesNb = pagesNb;
    }

    public void setBookCategory_id(long bookCategory_id) {
        this.bookCategory_id = bookCategory_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public void setBookStatus_id(long bookStatus_id) {
        this.bookStatus_id = bookStatus_id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public int getPagesNb() {
        return pagesNb;
    }

    public long getBookCategory_id() {
        return bookCategory_id;
    }

    public long getLanguage_id() {
        return language_id;
    }

    public long getBookStatus_id() {
        return bookStatus_id;
    }
  

    

}
