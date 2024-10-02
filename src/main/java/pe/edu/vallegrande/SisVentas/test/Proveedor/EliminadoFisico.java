package pe.edu.vallegrande.SisVentas.test.Proveedor;

import pe.edu.vallegrande.SisVentas.Controller.ProveedorController;

public class EliminadoFisico {
    public static void main(String[] args) {
        ProveedorController proveedorController = new ProveedorController();

        int id = 11;
        proveedorController.eliminadoFisico(id);
    }
}
