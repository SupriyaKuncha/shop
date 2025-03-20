package com.onlinebookshop.shop.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.onlinebookshop.shop.model.Book;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for Book
    public RowMapper<Book> bookRowMapper = (rs, rowNum) ->
            new Book(rs.getInt("id"), rs.getString("title"), rs.getInt("author_id"), rs.getDouble("price"));

    public int save(Book book) {
        String sql = "INSERT INTO books (title, author_id, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, book.gettitle(), book.getAuthorId(), book.getPrice());
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, bookRowMapper);
    }

    public Book findById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, bookRowMapper, id);
    }

    public int update(Book book) {
        String sql = "UPDATE books SET title = ?, author_id = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, book.gettitle(), book.getAuthorId(), book.getPrice(), book.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
