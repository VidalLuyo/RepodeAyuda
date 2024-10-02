package pe.edu.vallegrande.SisVentas.test.Client;

import pe.edu.vallegrande.SisVentas.Controller.ClienteController;
import pe.edu.vallegrande.SisVentas.Controller.ProveedorController;

public class EliminadoFisico {
    public static void main(String[] args) {
        ClienteController EliminidoF = new ClienteController();

        int id = 1;
        EliminidoF.eliminarFisico(id);
    }
}
