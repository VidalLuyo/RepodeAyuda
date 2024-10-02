package pe.edu.vallegrande.SisVentas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {
    private int clientId;
    private String clientCode;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String phone2;
    private String address;
    private char status;
    private LocalDate registrationDate;
}
