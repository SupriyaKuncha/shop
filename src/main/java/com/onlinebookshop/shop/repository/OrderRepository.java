package com.onlinebookshop.shop.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Order;

@Repository

public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }

    private RowMapper<Order> orderRowMapper = (rs, rowNum) -> 

        new Order(rs.getInt("id"), rs.getInt("bookId"), rs.getInt("quantity"));


    public int save(Order order) {

        String sql = "INSERT INTO orders(bookId, quantity) VALUES(?, ?)";

        return jdbcTemplate.update(sql, order.getBookId(), order.getQuantity());

    }


    public List<Order> findAll() {

        String sql = "SELECT * FROM orders";

        return jdbcTemplate.query(sql, orderRowMapper);

    }


    public Order findById(int id) {

        String sql = "SELECT * FROM orders WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, orderRowMapper, id);

    }


    public int update(Order order) {

        String sql = "UPDATE orders SET bookId = ?, quantity = ? WHERE id = ?";

        return jdbcTemplate.update(sql, order.getBookId(), order.getQuantity(), order.getId());

    }


    public int delete(int id) {

        String sql = "DELETE FROM orders WHERE id = ?";

        return jdbcTemplate.update(sql, id);

    }

}
 