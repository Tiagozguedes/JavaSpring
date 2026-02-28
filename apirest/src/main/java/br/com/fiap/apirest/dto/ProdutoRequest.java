package br.com.fiap.apirest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProdutoRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 150, message = "O nome deve ter entre 2 e 150 caracteres")
        String nome,
        @NotNull(message = "O preço é obrigatório")
        @DecimalMin(value = "0.99", message = "O valor ménimo deve ser 0.99")
        BigDecimal preco,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate expiracao
) {
    // Vou apenas transferir os dados e não mudalos, por isso o record.
}
