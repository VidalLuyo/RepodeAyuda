package pe.edu.vallegrande.SisVentas.Servlet;

import pe.edu.vallegrande.SisVentas.Controller.RegistroController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailOrUsername = request.getParameter("email");
        String password = request.getParameter("password");

        RegistroController registroController = new RegistroController();
        boolean loginExitoso = registroController.validarCredenciales(emailOrUsername, password);

        if (loginExitoso) {
            response.sendRedirect("index.jsp?success=true");
        } else {
            response.sendRedirect("index.jsp?error=true");
        }
    }
}
