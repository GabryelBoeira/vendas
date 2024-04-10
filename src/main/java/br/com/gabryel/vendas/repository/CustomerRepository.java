package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepository {

	private static String SAVE_CUSTOMER = "insert into CLIENTE (nome) values (?)"; // String
	private static String SELECT_CUSTOMER = "select * from CLIENTE";

	private JdbcTemplate jdbcTemplate;

	public CustomerRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Gets the customer information.
	 *
	 * @return the customer information
	 */
	public List<Customer> findAllCustomer() {
		return jdbcTemplate.query(SELECT_CUSTOMER, new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Customer(rs.getInt("id"), rs.getString("nome"));
			}
		});
	}

	/**
	 * Saves the customer information.
	 *
	 * @return a message indicating that the customer has been saved
	 */
	public Customer saveCustomer(Customer customer) {
		jdbcTemplate.update(SAVE_CUSTOMER, new Object[] {customer.getName()});
		return customer;
	}


}
