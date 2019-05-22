package com.elect.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * id INT(12) NOT NULL,
 *   author VARCHAR(200) NOT NULL,
 *   publishing VARCHAR(200) NOT NULL,
 *   publish_time BIGINT(20) NOT NULL,
 *   word_number VARCHAR(15) DEFAULT NULL,
 *   which_edtion VARCHAR(15) DEFAULT NULL,
 *   total_page VARCHAR(15) DEFAULT NULL,
 *   print_time INT(20) DEFAULT NULL,
 *   print_number VARCHAR(15) DEFAULT NULL,
 *   isbn VARCHAR(25) DEFAULT NULL,
 *   author_summary TEXT NOT NULL,
 *   catalogue TEXT NOT NULL,
 */
@Component("book")
public class Book {
    private int id;
    private String author;
    private String publishing;
    private long publish_time;
    private String word_number;
    private String which_edtion;
    private String total_page;
    private int print_time;
    private String print_number;
    private String isbn;
    private String author_summary;
    private String catalogue;
    private Product product;

    public Book() {
    }

    public Book(int id, String author, String publishing,
                    long publish_time, String word_number, String which_edtion,
                    String total_page, int print_time, String print_number, String isbn,
                    String author_summary, String catalogue, Product product) {
        this.id = id;
        this.author = author;
        this.publishing = publishing;
        this.publish_time = publish_time;
        this.word_number = word_number;
        this.which_edtion = which_edtion;
        this.total_page = total_page;
        this.print_time = print_time;
        this.print_number = print_number;
        this.isbn = isbn;
        this.author_summary = author_summary;
        this.catalogue = catalogue;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public long getPublish_time() {
        return publish_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publish_time == book.publish_time &&
                print_time == book.print_time &&
                Objects.equals(author, book.author) &&
                Objects.equals(publishing, book.publishing) &&
                Objects.equals(word_number, book.word_number) &&
                Objects.equals(which_edtion, book.which_edtion) &&
                Objects.equals(total_page, book.total_page) &&
                Objects.equals(print_number, book.print_number) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(author_summary, book.author_summary) &&
                Objects.equals(catalogue, book.catalogue) &&
                Objects.equals(product, book.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, publishing, publish_time, word_number, which_edtion, total_page, print_time, print_number, isbn, author_summary, catalogue, product);
    }

    public void setPublish_time(long publish_time) {
        this.publish_time = publish_time;
    }

    public String getWord_number() {
        return word_number;
    }

    public void setWord_number(String word_number) {
        this.word_number = word_number;
    }

    public String getWhich_edtion() {
        return which_edtion;
    }

    public void setWhich_edtion(String which_edtion) {
        this.which_edtion = which_edtion;
    }

    public String getTotal_page() {
        return total_page;
    }

    public void setTotal_page(String total_page) {
        this.total_page = total_page;
    }

    public int getPrint_time() {
        return print_time;
    }

    public void setPrint_time(int print_time) {
        this.print_time = print_time;
    }

    public String getPrint_number() {
        return print_number;
    }

    public void setPrint_number(String print_number) {
        this.print_number = print_number;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor_summary() {
        return author_summary;
    }

    public void setAuthor_summary(String author_summary) {
        this.author_summary = author_summary;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", publishing='" + publishing + '\'' +
                ", publish_time=" + publish_time +
                ", word_number='" + word_number + '\'' +
                ", which_edtion='" + which_edtion + '\'' +
                ", total_page='" + total_page + '\'' +
                ", print_time=" + print_time +
                ", print_number='" + print_number + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author_summary='" + author_summary + '\'' +
                ", catalogue='" + catalogue +
                '}';
    }

    public Book(int id, String author, String publishing,
                long publish_time, String word_number,
                String which_edtion, String total_page,
                int print_time, String print_number,
                String isbn, String author_summary, String catalogue) {
        this.id = id;
        this.author = author;
        this.publishing = publishing;
        this.publish_time = publish_time;
        this.word_number = word_number;
        this.which_edtion = which_edtion;
        this.total_page = total_page;
        this.print_time = print_time;
        this.print_number = print_number;
        this.isbn = isbn;
        this.author_summary = author_summary;
        this.catalogue = catalogue;
    }
}
