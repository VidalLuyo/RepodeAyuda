package pe.edu.vallegrande.SisVentas.test.Proveedor;

import pe.edu.vallegrande.SisVentas.Controller.ProveedorController;
import pe.edu.vallegrande.SisVentas.dto.Suppliers;

import java.util.List;

public class ListarTodos {

    public static void main(String[] args) {
        ProveedorController proveedorController = new ProveedorController();
        List<Suppliers> suppliers = proveedorController.listartodos();

        System.out.println("Lista de Suppliers:");
        for (Suppliers supplier : suppliers) {
            System.out.println("------------------------");
            System.out.println("ID: " + supplier.getId());
            System.out.println("Tipo de Documento: " + supplier.getDocumentType());
            System.out.println("Número de Documento: " + supplier.getDocumentNumber());
            System.out.println("Género: " + supplier.getGender());
            System.out.println("Nombre: " + supplier.getFirstName());
            System.out.println("Apellidos: " + supplier.getLastName());
            System.out.println("Teléfono: " + supplier.getPhone());
            System.out.println("Ubicación: " + supplier.getLocation());
            System.out.println("Estado: " + supplier.getStatus());
        }
    }
}
