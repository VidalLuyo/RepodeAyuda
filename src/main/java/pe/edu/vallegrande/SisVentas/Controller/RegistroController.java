package pe.edu.vallegrande.SisVentas.Controller;

import pe.edu.vallegrande.SisVentas.dto.Registro;
import pe.edu.vallegrande.SisVentas.Database.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistroController {

    public void registrarUsuario(Registro registro) {
        String query = "INSERT INTO Registro (username, password, email, first_name, last_name, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, registro.getUsername());
            pstmt.setString(2, registro.getPassword());
            pstmt.setString(3, registro.getEmail());
            pstmt.setString(4, registro.getFirstName());
            pstmt.setString(5, registro.getLastName());
            pstmt.setString(6, "A");

            pstmt.executeUpdate();
            System.out.println("Usuario registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario.");
            e.printStackTrace();
        }
    }


    public boolean existeUsuarioOEmail(String username, String email) {
        String query = "SELECT COUNT(*) FROM Registro WHERE username = ? OR email = ?";
        boolean existe = false;

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar el usuario o email.");
            e.printStackTrace();
        }

        return existe;
    }


    public boolean validarCredenciales(String emailOrUsername, String password) {
        String query = "SELECT COUNT(*) FROM Registro WHERE (email = ? OR username = ?) AND password = ?";
        boolean credencialesValidas = false;

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, emailOrUsername);
            pstmt.setString(2, emailOrUsername);
            pstmt.setString(3, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                credencialesValidas = rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            System.out.println("Error al validar las credenciales.");
            e.printStackTrace();
        }

        return credencialesValidas;
    }

}
