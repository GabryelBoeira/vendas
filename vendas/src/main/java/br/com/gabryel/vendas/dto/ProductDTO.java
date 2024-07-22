package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Represents a product")
public class ProductDTO {

        @Schema(description = "The unique identifier of the product")
        private Integer id;

        @Schema(description = "The description of the product")
        @NotBlank
        @Size(max = 100)
        private String description;

        @Schema(description = "The value of the product")
        @NotNull
        @Positive
        private BigDecimal value;

        public ProductDTO() {
        }

        public ProductDTO(Integer id, String description, BigDecimal value) {
                this.id = id;
                this.description = description;
                this.value = value;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public @NotBlank @Size(max = 100) String getDescription() {
                return description;
        }

        public void setDescription(@NotBlank @Size(max = 100) String description) {
                this.description = description;
        }

        public @NotNull BigDecimal getValue() {
                return value;
        }

        public void setValue(@NotNull BigDecimal value) {
                this.value = value;
        }
}
