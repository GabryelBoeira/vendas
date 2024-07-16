package br.com.gabryel.vendas.util;

import br.com.gabryel.vendas.dto.ResponsePurchaseOrderDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerListDeserializer extends StdDeserializer<List<ResponsePurchaseOrderDTO>> {

    public CustomerListDeserializer() {
        this(null);
    }

    public CustomerListDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<ResponsePurchaseOrderDTO> deserialize(JsonParser jsonparser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        return new ArrayList<>();
    }
}
