package com.example.testconnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    Customer customer = new Customer();
    customer.setId(rs.getInt("id"));
    customer.setName(rs.getString("name"));
    customer.setAddress(rs.getString("address"));
    return customer;
  }
}
