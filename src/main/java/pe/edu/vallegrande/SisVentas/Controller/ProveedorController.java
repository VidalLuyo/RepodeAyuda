package pe.edu.vallegrande.SisVentas.Controller;

import pe.edu.vallegrande.SisVentas.dto.Suppliers;
import pe.edu.vallegrande.SisVentas.Database.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {

    /*Listar Todos*/
    public List<Suppliers> listartodos() {
        List<Suppliers> supplierList = new ArrayList<>();
        try (Connection connection = ConexionDB.getConnection();
             Statement stmt = connection.createStatement()) {

            String query = "SELECT * FROM Suppliers";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Suppliers supplier = new Suppliers(
                        rs.getInt("id"),
                        rs.getString("document_type"),
                        rs.getString("document_number"),
                        rs.getString("gender").charAt(0),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("location"),
                        rs.getString("status").charAt(0)
                );
                supplierList.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    /* Agregar un nuevo proveedor */
    public void agregarProveedor(Suppliers supplier) {
        String query = "INSERT INTO Suppliers (document_type, document_number, gender, first_name, last_name, phone, location) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, supplier.getDocumentType());
            pstmt.setString(2, supplier.getDocumentNumber());
            pstmt.setString(3, String.valueOf(supplier.getGender()));
            pstmt.setString(4, supplier.getFirstName());
            pstmt.setString(5, supplier.getLastName());
            pstmt.setString(6, supplier.getPhone());
            pstmt.setString(7, supplier.getLocation());

            pstmt.executeUpdate();
            System.out.println("Proveedor creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear el proveedor.");
            e.printStackTrace();
        }
    }

    /* Editar un proveedor existente */
    public void editarProveedor(Suppliers supplier) {
        String query = "UPDATE Suppliers SET document_type = ?, document_number = ?, gender = ?, first_name = ?, last_name = ?, phone = ?, location = ?, status = ? WHERE id = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, supplier.getDocumentType());
            pstmt.setString(2, supplier.getDocumentNumber());
            pstmt.setString(3, String.valueOf(supplier.getGender()));
            pstmt.setString(4, supplier.getFirstName());
            pstmt.setString(5, supplier.getLastName());
            pstmt.setString(6, supplier.getPhone());
            pstmt.setString(7, supplier.getLocation());
            pstmt.setString(8, String.valueOf(supplier.getStatus()));
            pstmt.setInt(9, supplier.getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Proveedor actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un proveedor con el ID especificado.");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el proveedor.");
            e.printStackTrace();
        }
    }

    /* Eliminado logico*/
    public void eliminadoLogico(int id) {
        String query = "UPDATE Suppliers SET status = 'I' WHERE id = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Se elimino logicamente correctamente.");
            } else {
                System.out.println("No se encontró un proveedor con el ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar al proveedor.");
            e.printStackTrace();
        }
    }

    /* Eliminado fisico*/
    public void eliminadoFisico(int id) {
        String query = "DELETE FROM Suppliers WHERE id = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Se elimino fisicamente correctamente");
            } else {
                System.out.println("No se encontró un proveedor con el ID");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar al proveedor.");
            e.printStackTrace();
        }
    }

    /* Buscar un proveedor por ID */
    public Suppliers buscarporid (int id) {
        Suppliers supplier = null;
        String query = "SELECT * FROM Suppliers WHERE id = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                supplier = new Suppliers(
                        rs.getInt("id"),
                        rs.getString("document_type"),
                        rs.getString("document_number"),
                        rs.getString("gender").charAt(0),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("location"),
                        rs.getString("status").charAt(0)
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el proveedor.");
            e.printStackTrace();
        }

        return supplier;
    }

    /* Buscar un proveedor por DNI o CNE */
    public Suppliers buscarpornumerodeDocumento(String documentNumber) {
        Suppliers supplier = null;
        String query = "SELECT * FROM Suppliers WHERE document_number = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, documentNumber);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                supplier = new Suppliers(
                        rs.getInt("id"),
                        rs.getString("document_type"),
                        rs.getString("document_number"),
                        rs.getString("gender").charAt(0),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("location"),
                        rs.getString("status").charAt(0)
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el proveedor.");
            e.printStackTrace();
        }

        return supplier;
    }

    /* Buscar proveedores por nombre y apellido */
    public List<Suppliers> buscarpornombresyapellidos(String firstName, String lastName) {
        List<Suppliers> supplierList = new ArrayList<>();
        String query = "SELECT * FROM Suppliers WHERE first_name = ? AND last_name = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Suppliers supplier = new Suppliers(
                        rs.getInt("id"),
                        rs.getString("document_type"),
                        rs.getString("document_number"),
                        rs.getString("gender").charAt(0),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("location"),
                        rs.getString("status").charAt(0)
                );
                supplierList.add(supplier);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el proveedor por nombre y apellido.");
            e.printStackTrace();
        }

        return supplierList;
    }

    /* Listar proveedores activos */
    public List<Suppliers> listaractivos() {
        List<Suppliers> supplierList = new ArrayList<>();
        String query = "SELECT * FROM Suppliers WHERE status = 'A'";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Suppliers supplier = new Suppliers(
                        rs.getInt("id"),
                        rs.getString("document_type"),
                        rs.getString("document_number"),
                        rs.getString("gender").charAt(0),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("location"),
                        rs.getString("status").charAt(0)
                );
                supplierList.add(supplier);
            }
        } catch (Exception e) {
            System.out.println("Error al listar proveedores activos.");
            e.printStackTrace();
        }

        return supplierList;
    }

    /* Listar proveedores inactivos */
    public List<Suppliers> listarinactivos() {
        List<Suppliers> supplierList = new ArrayList<>();
        String query = "SELECT * FROM Suppliers WHERE status = 'I'";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Suppliers supplier = new Suppliers(
                        rs.getInt("id"),
                        rs.getString("document_type"),
                        rs.getString("document_number"),
                        rs.getString("gender").charAt(0),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("location"),
                        rs.getString("status").charAt(0)
                );
                supplierList.add(supplier);
            }
        } catch (Exception e) {
            System.out.println("Error al listar proveedores inactivos.");
            e.printStackTrace();
        }

        return supplierList;
    }
}
