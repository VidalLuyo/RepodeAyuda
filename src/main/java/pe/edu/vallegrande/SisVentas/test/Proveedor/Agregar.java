package pe.edu.vallegrande.SisVentas.test.Proveedor;

import pe.edu.vallegrande.SisVentas.Controller.ProveedorController;
import pe.edu.vallegrande.SisVentas.dto.Suppliers;

public class Agregar {

    public static void main(String[] args) {
        ProveedorController proveedorController = new ProveedorController();

        // Crear un nuevo proveedor
        Suppliers agregar = new Suppliers();
        agregar.setDocumentType("DNI");
        agregar.setDocumentNumber("87654321");
        agregar.setGender('M');
        agregar.setFirstName("Jesús");
        agregar.setLastName("Vidal");
        agregar.setPhone("987654321");
        agregar.setLocation("Lima, Peru");
        /*Llama el metodo para agregar*/
        proveedorController.agregarProveedor(agregar);

    }
}
