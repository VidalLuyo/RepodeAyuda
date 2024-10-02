package pe.edu.vallegrande.SisVentas.test.Proveedor;

import pe.edu.vallegrande.SisVentas.Controller.ProveedorController;

public class EliminadoLogico {
    public static void main(String[] args) {
        ProveedorController proveedorController = new ProveedorController();

        int id = 2;
        proveedorController.eliminadoLogico(id);
    }
}
