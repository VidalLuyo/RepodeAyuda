package pe.edu.vallegrande.SisVentas.test.Client;

import pe.edu.vallegrande.SisVentas.Controller.ClienteController;
import pe.edu.vallegrande.SisVentas.dto.Clientes;

public class Editar {

    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        // Datos del cliente a actualizar
        Clientes editar = new Clientes();
        editar.setClientId(4); // ID del cliente que se desea editar
        editar.setClientCode("C0004"); // Nuevo código de cliente si es necesario
        editar.setDocumentType("DNI");
        editar.setDocumentNumber("77277795");
        editar.setFirstName("Vidal");
        editar.setLastName("Luyo");
        editar.setBirthDate(java.time.LocalDate.of(2005, 01, 01)); // Nueva fecha de nacimiento
        editar.setEmail("vidal.luyo@gmail.com"); // Nuevo email
        editar.setPhone("921320431");
        editar.setPhone2("921320431"); // Si hay un segundo teléfono
        editar.setAddress("Cusco, Peru");
        editar.setStatus('A'); // Estado actualizado, 'A' o 'I'.

        /* Llamar al método */
        clienteController.editarCliente(editar);

    }
}
