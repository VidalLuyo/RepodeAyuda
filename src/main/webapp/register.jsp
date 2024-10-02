<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Regístrate</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Css/Login.css">
</head>
<body>

<div class="container">
    <div class="row justify-content-center align-items-center vh-100">
        <div class="col-lg-5 col-md-8 col-sm-10">
            <div class="auth-container shadow">
                <h3 class="text-center mb-4">Regístrate</h3>
                <form action="/SistemadeVentas/registerServlet" method="post">

                <div class="form-group">
                        <label for="username">Nombre de Usuario</label>
                        <input type="text" class="form-control" id="username" name="username" required maxlength="50">
                    </div>
                    <div class="form-group">
                        <label for="first_name">Nombre</label>
                        <input type="text" class="form-control" id="first_name" name="first_name" required maxlength="50">
                    </div>
                    <div class="form-group">
                        <label for="last_name">Apellido</label>
                        <input type="text" class="form-control" id="last_name" name="last_name" required maxlength="50">
                    </div>
                    <div class="form-group">
                        <label for="email">Correo Electrónico</label>
                        <input type="email" class="form-control" id="email" name="email" required maxlength="100">
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password" required maxlength="255">
                    </div>
                    <button type="submit" class="btn btn-success btn-block mt-4">REGISTRARSE</button>
                </form>

                <div class="divider mt-4">
                    <span>O</span>
                </div>

                <button class="btn btn-google btn-block mt-3">
                    <img src="https://img.icons8.com/color/16/000000/google-logo.png"> Regístrate con Google
                </button>

                <div class="text-center mt-3">
                    <span>¿Ya tienes una cuenta? <a href="index.jsp">Inicia sesión aquí</a></span>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/Js/Register.js"></script>

</body>
</html>

