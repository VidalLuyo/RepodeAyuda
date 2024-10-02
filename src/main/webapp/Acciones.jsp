<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Registrar Cliente</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- SweetAlert2 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
    <!-- Custom CSS -->
    <link href="Css/Dashboard.css" rel="stylesheet" />

    <style>
        .icono-grande {
            font-size: 3rem; /* Ajusta el tamaño del icono */
        }
        .card {
            border: 1px solid #e0e0e0; /* Agrega un borde suave */
        }
        .card-body {
            padding: 1.25rem; /* Ajusta el padding dentro de las tarjetas */
        }

        .container {
            margin-top: 2rem; /* Espacio superior de la sección principal */
        }
        .card-title {
            font-size: 1.5rem; /* Tamaño del texto del título */
        }
        .card-text {
            font-size: 1rem; /* Tamaño del texto del contenido */
        }
        #layoutSidenav_nav {
            width: 250px; /* Ajusta el ancho del sidebar */
        }

        .sb-sidenav {
            width: 100%; /* Asegúrate de que el sidebar ocupe todo el ancho definido */
        }
    </style>
</head>

<body class="sb-nav-fixed">
<!-- Navbar -->
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand ps-3" href="index.jsp">Puesto de Frutas N° 65</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!">
        <i class="fas fa-bars"></i>
    </button>
</nav>

<div id="layoutSidenav">
    <!-- Sidebar -->
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Bienvenido</div>
                    <a class="nav-link" href="index.jsp">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Inicio
                    </a>

                    <!-- Interfaz Proveedores -->
                    <div class="sb-sidenav-menu-heading">Interfaces</div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseProveedores" aria-expanded="false" aria-controls="collapseProveedores">
                        <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                        Proveedores
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseProveedores" aria-labelledby="headingProveedores" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="registrarProveedor.jsp">Registrar</a>
                            <a class="nav-link" href="listadoProveedores.jsp">Listado de Proveedores</a>
                        </nav>
                    </div>

                    <!-- Interfaz Clientes -->

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseClientes" aria-expanded="false" aria-controls="collapseClientes">
                        <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                        Clientes
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseClientes" aria-labelledby="headingClientes" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="registrarCliente.jsp">Registrar</a>
                            <a class="nav-link" href="ClientList.jsp">Listado de Clientes</a>
                        </nav>
                    </div>

                    <!-- Interfaz Producto -->
                    <a class="nav-link" href="productos.jsp">
                        <div class="sb-nav-link-icon"><i class="fas fa-boxes"></i></div>
                        Productos
                    </a>

                    <!-- Interfaz Ventas -->
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVentas" aria-expanded="false" aria-controls="collapseVentas">
                        <div class="sb-nav-link-icon"><i class="fas fa-shopping-cart"></i></div>
                        Ventas
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseVentas" aria-labelledby="headingVentas" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="registrarVenta.jsp">Registrar Venta</a>
                            <a class="nav-link" href="listadoVentas.jsp">Listado de Ventas</a>
                        </nav>
                    </div>
                </div>
            </div>
        </nav>
    </div>


    <!-- Main Content -->
    <div id="layoutSidenav_content">
        <main role="main" class="container-fluid">
            <div class="container">
                <h1 class="text-center mb-4 mt-5">Bienvenido. Elija una opción</h1>
                <div class="row">
                    <!-- Tarjeta para Realizar una Venta -->
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm text-center">
                            <div class="card-body">
                                <i class="fas fa-cash-register icono-grande text-primary"></i>
                                <h5 class="card-title mt-3">Realizar una venta</h5>
                                <p class="card-text">Hacer una venta al contado o un apartado.</p>
                                <a href="registrarVenta.jsp" class="btn btn-primary">Ir a Ventas</a>
                            </div>
                        </div>
                    </div>

                    <!-- Tarjeta para Ver Inventario -->
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm text-center">
                            <div class="card-body">
                                <i class="fas fa-box icono-grande text-success"></i>
                                <h5 class="card-title mt-3">Ver inventario</h5>
                                <p class="card-text">Registrar, eliminar o actualizar detalles productos.</p>
                                <a href="productos.jsp" class="btn btn-success">Ir al Inventario</a>
                            </div>
                        </div>
                    </div>

                    <!-- Tarjeta para Mis Clientes -->
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm text-center">
                            <div class="card-body">
                                <i class="fas fa-users icono-grande text-info"></i>
                                <h5 class="card-title mt-3">Mis clientes</h5>
                                <p class="card-text">Registrar, eliminar o actualizar detalles clientes.</p>
                                <a href="ClientList.jsp" class="btn btn-info">Ir a Clientes</a>
                            </div>
                        </div>
                    </div>

                    <!-- Tarjeta para Mis Clientes -->
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm text-center">
                            <div class="card-body">
                                <i class="fas fa-users icono-grande text-info"></i>
                                <h5 class="card-title mt-3">Mis Proveedores</h5>
                                <p class="card-text">Registrar, eliminar o actualizar detalles de mis proveedores.</p>
                                <a href="Proveedores.jsp" class="btn btn-info">Ir a Proveedores</a>
                            </div>
                        </div>
                    </div>
                    <!-- Tarjeta para Caja -->
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm text-center">
                            <div class="card-body">
                                <i class="fas fa-cash-register icono-grande text-danger"></i>
                                <h5 class="card-title mt-3">Caja</h5>
                                <p class="card-text">Administrar ingresos y egresos de dinero.</p>
                                <a href="caja.jsp" class="btn btn-danger">Ir a Caja</a>
                            </div>
                        </div>
                    </div>

                    <!-- Tarjeta para Reportes -->
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm text-center">
                            <div class="card-body">
                                <i class="fas fa-chart-line icono-grande text-warning"></i>
                                <h5 class="card-title mt-3">Reportes</h5>
                                <p class="card-text">Ver y generar reportes de ventas y productos.</p>
                                <a href="reportes.jsp" class="btn btn-warning">Ir a Reportes</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <<!-- Modal para solicitud de contraseña -->
            <div class="modal fade" id="passwordModal" tabindex="-1" aria-labelledby="passwordModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="passwordModalLabel">Autenticación requerida</h5>
                        </div>
                        <div class="modal-body">
                            <p>Por favor, ingrese su contraseña para continuar:</p>
                            <input type="password" id="passwordInput" class="form-control">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" id="cancelButton" disabled>Cancelar</button>
                            <button type="button" class="btn btn-primary" id="passwordSubmit">Enviar</button>
                        </div>
                    </div>
                </div>
            </div>

        </main>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<!-- SweetAlert2 JS -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/Js/datatables-simple-demo.js"></script>



</body>

</html>
