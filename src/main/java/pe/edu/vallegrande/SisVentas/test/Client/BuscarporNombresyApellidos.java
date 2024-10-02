package pe.edu.vallegrande.SisVentas.test.Client;

import pe.edu.vallegrande.SisVentas.Controller.ClienteController;
import pe.edu.vallegrande.SisVentas.dto.Clientes;

import java.util.List;

public class BuscarporNombresyApellidos {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        String firstName = "Carlos"; // Cambiar al nombre que deseas buscar
        String lastName = "Gonzales"; // Cambiar al apellido que deseas buscar

        List<Clientes> clientes = clienteController.buscarpornombresyapellidos(firstName, lastName);

        if (!clientes.isEmpty()) {
            System.out.println("Clientes encontrados:");
            for (Clientes cliente : clientes) {
                System.out.println("------------------------");
                System.out.println("ID: " + cliente.getClientId());
                System.out.println("Código de Cliente: " + cliente.getClientCode());
                System.out.println("Tipo de Documento: " + cliente.getDocumentType());
                System.out.println("Número de Documento: " + cliente.getDocumentNumber());
                System.out.println("Nombre: " + cliente.getFirstName());
                System.out.println("Apellidos: " + cliente.getLastName());
                System.out.println("Fecha de Nacimiento: " + cliente.getBirthDate());
                System.out.println("Correo Electrónico: " + cliente.getEmail());
                System.out.println("Teléfono: " + cliente.getPhone());
                System.out.println("Teléfono 2: " + cliente.getPhone2());
                System.out.println("Dirección: " + cliente.getAddress());
                System.out.println("Estado: " + cliente.getStatus());
                System.out.println("Fecha de Registro: " + cliente.getRegistrationDate());
            }
        } else {
            System.out.println("No se encontraron clientes con el nombre y apellido especificados.");
        }
    }
}
