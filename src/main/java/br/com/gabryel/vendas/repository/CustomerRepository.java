package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

	private static final String SAVE_CUSTOMER = "INSERT INTO CLIENTE (nome) values (?)"; // String
	private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM CLIENTE";
	private static final String UPDATE_CUSTOMER = "UPDATE CLIENTE SET nome = ? WHERE id = ?";
	private static final String DELETE_CUSTOMER = "DELETE FROM CLIENTE where id = ?";


	private final JdbcTemplate jdbcTemplate;

	public CustomerRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Gets the customer information.
	 *
	 * @return the customer information
	 */
	public List<Customer> findAllCustomer() {
		return jdbcTemplate.query(SELECT_ALL_CUSTOMER,
			(rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("nome")));
	}

	/**
	 * Saves the customer information.
	 *
	 * @return a message indicating that the customer has been saved
	 */
	public Customer saveCustomer(Customer customer) {
		jdbcTemplate.update(SAVE_CUSTOMER, new Object[]{customer.getName()});
		return customer;
	}

	public Customer updateCustomer(Customer customer) {
		jdbcTemplate.update(UPDATE_CUSTOMER, new Object[]{customer.getName(), customer.getId()});
		return customer;
	}

	/**
	 * Deletes a customer from the database.
	 *
	 * @param  customer	The customer object to be deleted
	 * @return         	void
	 */
	public void deleteCustomer(Customer customer) {
		deleteCustomerById(customer.getId());
	}

	/**
	 * Deletes a customer from the database by ID.
	 *
	 * @param  customerId The customer ID to be deleted
	 * @return         	void
	 */
	public void deleteCustomerById(Integer customerId) {
		jdbcTemplate.update(DELETE_CUSTOMER, new Object[] {customerId});
	}

	/**
	 * Find customers by name.
	 *
	 * @param  name	 find customer name by like
	 * @return        list for customers
	 */
	public List<Customer> findCustomerByName(String	name) {
		return jdbcTemplate.query(SELECT_ALL_CUSTOMER.concat(" WHERE nome like ?"),
				new Object[]{"%" + name + "%"},
				(rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("nome")));
	}

}
