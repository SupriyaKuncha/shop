package com.onlinebookshop.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.model.Order;
import com.onlinebookshop.shop.service.AuthorService;
import com.onlinebookshop.shop.service.BookService;
import com.onlinebookshop.shop.service.OrderService;
@EnableAspectJAutoProxy
@SpringBootApplication
public class ShopApplication { // implements CommandLineRunner

//    @Autowired
//    private BookService bookService;
//
//    @Autowired
//    private AuthorService authorService;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private Book book1;
//    @Autowired
//    private Book book2;
//    @Autowired
//    private Author author1;
//    @Autowired
//    private Author author2;
//    @Autowired
//    private Order order1;
//    @Autowired
//    private Order order2;
//    
    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        // Test the services
//
//        // Add authors
////        Author author1 = new Author(3, "J.K. Rowling", "India");
////        Author author2 = new Author(4, "Robert", "US");
//
//        authorService.addAuthor(author1);
//        authorService.addAuthor(author2);
//
//        System.out.println("Authors added successfully");
//
//        // Fetch all authors
//        List<Author> authors = authorService.getAllAuthors();
//        System.out.println("-----Author List-----");
//        authors.forEach(author -> System.out.println("Author Id: " + author.getId() + ", Name: " + author.getName() + ", Country: " + author.getCountry()));
//
//        // Get author by id
//        int authorId = 1;
//        Author foundAuthor = authorService.getAuthorById(authorId);
//        System.out.println("Found Author: " + foundAuthor);
//
//        // Update author country
//        foundAuthor.setCountry("United Kingdom");
//        authorService.updateAuthor(foundAuthor);
//        System.out.println("Author Id: " + foundAuthor.getId() + ", Updated Country: " + foundAuthor.getCountry());
//
//        // Delete an author by id
//        int authorId2 = 3;
//        authorService.deleteAuthor(authorId2);
//        System.out.println("Author with Id " + authorId2 + " deleted successfully");
//
//        // Fetch updated author list
//        System.out.println("-----Updated Author List-----");
//        authorService.getAllAuthors().forEach(author -> System.out.println("Author Id: " + author.getId() + ", Name: " + author.getName() + ", Country: " + author.getCountry()));
//
//        // Add books
////        Book book1 = new Book(3, "New Book JDBC", 1, 300.00);
////        Book book2 = new Book(4, "New Book JDBC2", 2, 310.00);
//
//        bookService.addBook(book1);
//        bookService.addBook(book2);
//
//        System.out.println("Books added successfully");
//
//        // Fetch all books
//        List<Book> books = bookService.getAllBooks();
//        System.out.println("-----Book List-----");
//        books.forEach(book -> System.out.println("Book Id: " + book.getId() + ", Title: " + book.gettitle() + ", Price: " + book.getPrice()));
//
//        // Get book by id
//        int bookId = 1;
//        Book foundBook = bookService.getBookById(bookId);
//        System.out.println("Found Book: " + foundBook);
//
//        // Update book price
//        foundBook.setPrice(450.00);
//        bookService.updateBook(foundBook);
//        System.out.println("Book Id: " + foundBook.getId() + ", Updated Price: " + foundBook.getPrice());
//
//        // Delete a book by id
//        int bookId2 = 3;
//        bookService.deleteBook(bookId2);
//        System.out.println("Book with Id " + bookId2 + " deleted successfully");
//
//        // Fetch updated book list
//        System.out.println("-----Updated Book List-----");
//        bookService.getAllBooks().forEach(book -> System.out.println("Book Id: " + book.getId() + ", Title: " + book.gettitle() + ", Price: " + book.getPrice()));
//
//        // Add orders
////        Order order1 = new Order(3, 1, 2);
////        Order order2 = new Order(4, 2, 3);
//
//        orderService.addOrder(order1);
//        orderService.addOrder(order2);
//
//        System.out.println("Orders added successfully");
//
//        // Fetch all orders
//        List<Order> orders = orderService.getAllOrders();
//        System.out.println("-----Order List-----");
//        orders.forEach(order -> System.out.println("Order Id: " + order.getId() + ", Book Id: " + order.getBookId() + ", Quantity: " + order.getQuantity()));
//
//        // Get order by id
//        int orderId = 1;
//        Order foundOrder = orderService.getOrderById(orderId);
//        System.out.println("Found Order: " + foundOrder);
//
//        // Update order quantity
//        foundOrder.setQuantity(5);
//        orderService.updateOrder(foundOrder);
//        System.out.println("Order Id: " + foundOrder.getId() + ", Updated Quantity: " + foundOrder.getQuantity());
//
//        // Delete an order by id
//        int orderId2 = 3;
//        orderService.deleteOrder(orderId2);
//        System.out.println("Order with Id " + orderId2 + " deleted successfully");
//
//        // Fetch updated order list
//        System.out.println("-----Updated Order List-----");
//        orderService.getAllOrders().forEach(order -> System.out.println("Order Id: " + order.getId() + ", Book Id: " + order.getBookId() + ", Quantity: " + order.getQuantity()));
//    }
}
