package pe.edu.vallegrande.SisVentas.Controller;

import pe.edu.vallegrande.SisVentas.dto.Clientes;
import pe.edu.vallegrande.SisVentas.Database.ConexionDB;
import pe.edu.vallegrande.SisVentas.dto.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    //Correlativo para el Cliente
    private String generarSiguienteClientCode() {
        String ultimoCodigo = "C0000";
        String query = "SELECT TOP 1 ClientCode FROM Client ORDER BY ClientID DESC";

        try (Connection connection = ConexionDB.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                ultimoCodigo = rs.getString("ClientCode").trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Generar el siguiente código correlativo
        int numero = Integer.parseInt(ultimoCodigo.substring(1)) + 1;
        return String.format("C%04d", numero);
    }

    /* Listar todos los clientes */
    public List<Clientes> listarTodos() {
        List<Clientes> clienteList = new ArrayList<>();
        String query = "SELECT * FROM Client";

        try (Connection connection = ConexionDB.getConnection();
             Statement stmt = connection.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setClientId(rs.getInt("ClientID"));
                cliente.setClientCode(rs.getString("ClientCode"));
                cliente.setDocumentType(rs.getString("DocumentType"));
                cliente.setDocumentNumber(rs.getString("DocumentNumber"));
                cliente.setFirstName(rs.getString("FirstName"));
                cliente.setLastName(rs.getString("LastName"));
                cliente.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                cliente.setEmail(rs.getString("Email"));
                cliente.setPhone(rs.getString("Phone"));
                cliente.setPhone2(rs.getString("Phone2"));
                cliente.setAddress(rs.getString("Address"));
                cliente.setStatus(rs.getString("Status").charAt(0));
                cliente.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());

                clienteList.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clienteList;
    }

    /* Agregar un nuevo cliente */
    public void agregarCliente(Clientes cliente) {
        String query = "INSERT INTO Client (ClientCode, DocumentType, DocumentNumber, FirstName, LastName, BirthDate, Email, Phone, Phone2, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Generar el siguiente ClientCode correlativo
        cliente.setClientCode(generarSiguienteClientCode());

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, cliente.getClientCode());
            pstmt.setString(2, cliente.getDocumentType());
            pstmt.setString(3, cliente.getDocumentNumber());
            pstmt.setString(4, cliente.getFirstName());
            pstmt.setString(5, cliente.getLastName());
            pstmt.setDate(6, java.sql.Date.valueOf(cliente.getBirthDate()));
            pstmt.setString(7, cliente.getEmail());
            pstmt.setString(8, cliente.getPhone());
            pstmt.setString(9, cliente.getPhone2());
            pstmt.setString(10, cliente.getAddress());

            pstmt.executeUpdate();
            System.out.println("Cliente creado exitosamente con código: " + cliente.getClientCode());
        } catch (Exception e) {
            System.out.println("Error al crear el cliente.");
            e.printStackTrace();
        }
    }

    /* Editar un cliente existente */
    public void editarCliente(Clientes cliente) {
        String query = "UPDATE Client SET ClientCode = ?, DocumentType = ?, DocumentNumber = ?, FirstName = ?, LastName = ?, BirthDate = ?, Email = ?, Phone = ?, Phone2 = ?, Address = ?, Status = ? WHERE ClientID = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, cliente.getClientCode());
            pstmt.setString(2, cliente.getDocumentType());
            pstmt.setString(3, cliente.getDocumentNumber());
            pstmt.setString(4, cliente.getFirstName());
            pstmt.setString(5, cliente.getLastName());
            pstmt.setDate(6, java.sql.Date.valueOf(cliente.getBirthDate()));
            pstmt.setString(7, cliente.getEmail());
            pstmt.setString(8, cliente.getPhone());
            pstmt.setString(9, cliente.getPhone2());
            pstmt.setString(10, cliente.getAddress());
            pstmt.setString(11, String.valueOf(cliente.getStatus()));
            pstmt.setInt(12, cliente.getClientId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un cliente con el ID especificado.");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente.");
            e.printStackTrace();
        }
    }

    /* Eliminado lógico */
    public void eliminarLogico(int clientId) {
        String query = "UPDATE Client SET Status = 'I' WHERE ClientID = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, clientId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente eliminado lógicamente correctamente.");
            } else {
                System.out.println("No se encontró un cliente con el ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar al cliente.");
            e.printStackTrace();
        }
    }

    /* Eliminado físico */
    public void eliminarFisico(int clientId) {
        String query = "DELETE FROM Client WHERE ClientID = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, clientId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente eliminado físicamente correctamente.");
            } else {
                System.out.println("No se encontró un cliente con el ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar al cliente.");
            e.printStackTrace();
        }
    }

    /* Buscar un cliente por ID */
    public Clientes buscarPorId(int clientId) {
        Clientes cliente = null;
        String query = "SELECT * FROM Client WHERE ClientID = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, clientId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Clientes();
                cliente.setClientId(rs.getInt("ClientID"));
                cliente.setClientCode(rs.getString("ClientCode"));
                cliente.setDocumentType(rs.getString("DocumentType"));
                cliente.setDocumentNumber(rs.getString("DocumentNumber"));
                cliente.setFirstName(rs.getString("FirstName"));
                cliente.setLastName(rs.getString("LastName"));
                cliente.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                cliente.setEmail(rs.getString("Email"));
                cliente.setPhone(rs.getString("Phone"));
                cliente.setPhone2(rs.getString("Phone2"));
                cliente.setAddress(rs.getString("Address"));
                cliente.setStatus(rs.getString("Status").charAt(0));
                cliente.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente.");
            e.printStackTrace();
        }

        return cliente;
    }

    /* Listar clientes activos */
    public List<Clientes> listarActivos() {
        List<Clientes> clienteList = new ArrayList<>();
        String query = "SELECT * FROM Client WHERE Status = 'A'";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setClientId(rs.getInt("ClientID"));
                cliente.setClientCode(rs.getString("ClientCode"));
                cliente.setDocumentType(rs.getString("DocumentType"));
                cliente.setDocumentNumber(rs.getString("DocumentNumber"));
                cliente.setFirstName(rs.getString("FirstName"));
                cliente.setLastName(rs.getString("LastName"));
                cliente.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                cliente.setEmail(rs.getString("Email"));
                cliente.setPhone(rs.getString("Phone"));
                cliente.setPhone2(rs.getString("Phone2"));
                cliente.setAddress(rs.getString("Address"));
                cliente.setStatus(rs.getString("Status").charAt(0));
                cliente.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());

                clienteList.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes activos.");
            e.printStackTrace();
        }

        return clienteList;
    }

    /* Listar clientes activos */
    public List<Clientes> listarInactivos() {
        List<Clientes> clienteList = new ArrayList<>();
        String query = "SELECT * FROM Client WHERE Status = 'I'";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setClientId(rs.getInt("ClientID"));
                cliente.setClientCode(rs.getString("ClientCode"));
                cliente.setDocumentType(rs.getString("DocumentType"));
                cliente.setDocumentNumber(rs.getString("DocumentNumber"));
                cliente.setFirstName(rs.getString("FirstName"));
                cliente.setLastName(rs.getString("LastName"));
                cliente.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                cliente.setEmail(rs.getString("Email"));
                cliente.setPhone(rs.getString("Phone"));
                cliente.setPhone2(rs.getString("Phone2"));
                cliente.setAddress(rs.getString("Address"));
                cliente.setStatus(rs.getString("Status").charAt(0));
                cliente.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());

                clienteList.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes inactivos.");
            e.printStackTrace();
        }

        return clienteList;
    }
    /* Buscar clientes por nombre y apellido */
    public List<Clientes> buscarpornombresyapellidos(String firstName, String lastName) {
        List<Clientes> clienteList = new ArrayList<>();
        String query = "SELECT * FROM Client WHERE FirstName = ? AND LastName = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setClientId(rs.getInt("ClientID"));
                cliente.setClientCode(rs.getString("ClientCode"));
                cliente.setDocumentType(rs.getString("DocumentType"));
                cliente.setDocumentNumber(rs.getString("DocumentNumber"));
                cliente.setFirstName(rs.getString("FirstName"));
                cliente.setLastName(rs.getString("LastName"));
                cliente.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                cliente.setEmail(rs.getString("Email"));
                cliente.setPhone(rs.getString("Phone"));
                cliente.setPhone2(rs.getString("Phone2"));
                cliente.setAddress(rs.getString("Address"));
                cliente.setStatus(rs.getString("Status").charAt(0));
                cliente.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());

                clienteList.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente por nombre y apellido.");
            e.printStackTrace();
        }

        return clienteList;
    }

    /* Buscar un cliente por DNI o CNE */
    public Clientes buscarpornumerodeDocumento(String documentNumber) {
        Clientes cliente = null;
        String query = "SELECT * FROM Client WHERE DocumentNumber = ?";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, documentNumber);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Clientes();
                cliente.setClientId(rs.getInt("ClientID"));
                cliente.setClientCode(rs.getString("ClientCode"));
                cliente.setDocumentType(rs.getString("DocumentType"));
                cliente.setDocumentNumber(rs.getString("DocumentNumber"));
                cliente.setFirstName(rs.getString("FirstName"));
                cliente.setLastName(rs.getString("LastName"));
                cliente.setBirthDate(rs.getDate("BirthDate").toLocalDate());
                cliente.setEmail(rs.getString("Email"));
                cliente.setPhone(rs.getString("Phone"));
                cliente.setPhone2(rs.getString("Phone2"));
                cliente.setAddress(rs.getString("Address"));
                cliente.setStatus(rs.getString("Status").charAt(0));
                cliente.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el cliente.");
            e.printStackTrace();
        }

        return cliente;
    }

}
