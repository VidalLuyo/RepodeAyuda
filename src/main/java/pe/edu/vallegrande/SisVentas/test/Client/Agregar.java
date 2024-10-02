package pe.edu.vallegrande.SisVentas.test.Client;


import pe.edu.vallegrande.SisVentas.Controller.ClienteController;
import pe.edu.vallegrande.SisVentas.dto.Clientes;

public class Agregar {

    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();

        // Crear un nuevo cliente
        Clientes nuevoCliente = new Clientes();
        nuevoCliente.setDocumentType("DNI");
        nuevoCliente.setDocumentNumber("71277795");
        nuevoCliente.setFirstName("Jesús Vidal");
        nuevoCliente.setLastName("Luyo Cárdenas");
        nuevoCliente.setBirthDate(java.time.LocalDate.of(1995, 5, 20));
        nuevoCliente.setEmail("jesus.luyo@gmail.com");
        nuevoCliente.setPhone("921320431");
        nuevoCliente.setPhone2("921320431");
        nuevoCliente.setAddress("Imperial- Cañete - Lima");
        nuevoCliente.setStatus('A');

        clienteController.agregarCliente(nuevoCliente);

    }
}