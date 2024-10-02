package pe.edu.vallegrande.SisVentas.Servlet;

import pe.edu.vallegrande.SisVentas.Controller.RegistroController;
import pe.edu.vallegrande.SisVentas.dto.Registro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

        Registro registro = new Registro();
        registro.setUsername(username);
        registro.setPassword(password);
        registro.setEmail(email);
        registro.setFirstName(firstName);
        registro.setLastName(lastName);
        registro.setStatus("A");

        RegistroController registroController = new RegistroController();

        if (registroController.existeUsuarioOEmail(username, email)) {
            response.sendRedirect("register.jsp?error=true");
        } else {
            registroController.registrarUsuario(registro);
            response.sendRedirect("register.jsp?success=true");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
}
