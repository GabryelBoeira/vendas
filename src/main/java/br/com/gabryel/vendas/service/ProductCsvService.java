package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.entity.Product;
import br.com.gabryel.vendas.exception.BusinessException;
import com.opencsv.CSVWriter;
import jakarta.servlet.ServletOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class ProductCsvService {

    private static final String CSV_HEADER = "ID, DESCRICAO, VALOR \n";
    private static final String[] CSV_HEADER_LIST = {"ID", "DESCRICAO", "VALOR"};


    /**
     * Method to create a CSV file containing product information.
     *
     * @return a byte array representing the CSV file content
     */
    public byte[] createCsvProductFile(List<Product> products) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);

        for (Product product : products) {
            csvContent.append(product.getId()).append(",")
                    .append(product.getDescription()).append(",")
                    .append(product.getValue()).append("\n");
        }

        return csvContent.toString().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Creates a ZIP file containing a CSV file of product information.
     *
     * @param sos the ServletOutputStream to write the ZIP file to
     * @return the ZipOutputStream used to write the ZIP file
     * @throws ResponseStatusException if an I/O error occurs
     */
    public ZipOutputStream createCsvZipProductFile(ServletOutputStream sos, List<Product> products) throws BusinessException {
        try {
            final ZipOutputStream zos = new ZipOutputStream(sos);
            zos.putNextEntry(new ZipEntry("products.csv"));

            CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(zos, StandardCharsets.UTF_8));
            csvWriter.writeNext(CSV_HEADER_LIST, false);

            for (Product product : products) {
                csvWriter.writeNext(new String[]{ product.getId().toString(), product.getDescription(), product.getValue().toString()}, false);
            }

            csvWriter.flushQuietly();
            zos.closeEntry();
            zos.close();
            return zos;
        } catch (IOException e) {
            throw new BusinessException("Error creating CSV file: " + e.getMessage());
        }
    }


}
