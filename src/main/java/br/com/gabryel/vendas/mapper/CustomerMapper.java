package br.com.gabryel.vendas.mapper;

import br.com.gabryel.vendas.dto.CustomerDTO;
import br.com.gabryel.vendas.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    /**
     * Converts a Customer object to a CustomerDTO object.
     *
     * @param  customer	The Customer object to be converted
     * @return         	The CustomerDTO object converted from the Customer
     */
    CustomerDTO toDTO(Customer customer);

    /**
     * Converts a CustomerDTO object to a Customer entity.
     *
     * @param  customerDTO	The CustomerDTO object to be converted
     * @return         	The Customer entity converted from the CustomerDTO
     */
    Customer toEntity(CustomerDTO customerDTO);

    /**
     * Converts a list of Customer objects to a list of CustomerDTO objects.
     *
     * @param  customers   the list of Customer objects to be converted
     * @return             the list of CustomerDTO objects converted from the list of Customer objects
     */
    List<CustomerDTO> toDTOs(List<Customer> customers);

    /**
     * Converts a list of CustomerDTO objects to a list of Customer entities.
     *
     * @param  customerDTOS   the list of CustomerDTO objects to be converted
     * @return                the list of Customer entities converted from the list of CustomerDTO objects
     */
    List<Customer> toEntities(List<CustomerDTO> customerDTOS);

}
