package com.onlinebookshop.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.model.Order;

@Configuration
public class AppConfig {

    @Bean
    public Author author1() {
        return new Author(1, "J.K. Rowling", "India");
    }

    @Bean
    public Author author2() {
        return new Author(2, "Robert", "US");
    }
    

    @Bean
    public Book book1() {
        return new Book(1, "Spring Framework", 1, 350.00);
    }

    @Bean
    public Book book2() {
        return new Book(2, "Microservices", 2, 450.00);
    }
    @Bean
    public Order order1() {
        return new Order(3, 1, 2);
    }
    @Bean
    public Order order2() {
        return new Order(4, 1, 2);
    }
}
