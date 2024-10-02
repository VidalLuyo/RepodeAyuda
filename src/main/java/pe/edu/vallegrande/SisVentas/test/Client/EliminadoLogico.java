package pe.edu.vallegrande.SisVentas.test.Client;

import pe.edu.vallegrande.SisVentas.Controller.ClienteController;
import pe.edu.vallegrande.SisVentas.Controller.ProveedorController;

public class EliminadoLogico {
    public static void main(String[] args) {
        ClienteController EliminidoL = new ClienteController();

        int id = 4;
        EliminidoL.eliminarLogico(id);
    }
}
