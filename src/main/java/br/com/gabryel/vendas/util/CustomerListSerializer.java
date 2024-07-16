package br.com.gabryel.vendas.util;

import br.com.gabryel.vendas.dto.CustomerDTO;
import br.com.gabryel.vendas.dto.ResponsePurchaseOrderDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerListSerializer extends StdSerializer<List<ResponsePurchaseOrderDTO>> {

    public CustomerListSerializer() {
        this(null);
    }

    public CustomerListSerializer(Class<List<ResponsePurchaseOrderDTO>> t) {
        super(t);
    }

    @Override
    public void serialize(List<ResponsePurchaseOrderDTO> items, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<ResponsePurchaseOrderDTO> orders = new ArrayList<>();
        for (ResponsePurchaseOrderDTO item : items) {
            ResponsePurchaseOrderDTO order = new ResponsePurchaseOrderDTO();
            order.setId(item.getId());

            CustomerDTO c = item.getCustomer();
            c.setOrders(null);
            order.setCustomer(c);
            order.setValueTotal(item.getValueTotal());
            order.setDateOrder(item.getDateOrder());
            order.setItems(item.getItems());
            orders.add(item);
        }
        generator.writeObject(orders);
    }

}
