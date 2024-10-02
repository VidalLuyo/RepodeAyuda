package pe.edu.vallegrande.SisVentas.test.Proveedor;

import pe.edu.vallegrande.SisVentas.Controller.ProveedorController;
import pe.edu.vallegrande.SisVentas.dto.Suppliers;

public class Editar {

    public static void main(String[] args) {
        ProveedorController proveedorController = new ProveedorController();

        // Datos del proveedor a actualizar
        Suppliers editar = new Suppliers();
        editar.setId(11);
        editar.setDocumentType("CNE");
        editar.setDocumentNumber("123456789012345");
        editar.setGender('F');
        editar.setFirstName("Ana");
        editar.setLastName("Gomez");
        editar.setPhone("912345678");
        editar.setLocation("Cusco, Peru");
        editar.setStatus('A'); // Estado actualizado, 'A' o 'I'.

        /* Llamar al metodo*/
        proveedorController.editarProveedor(editar);

    }
}
