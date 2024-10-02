package pe.edu.vallegrande.SisVentas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suppliers {

    private int id;
    private String documentType;
    private String documentNumber;
    private char gender;
    private String firstName;
    private String lastName;
    private String phone;
    private String location;
    private char status;
}





