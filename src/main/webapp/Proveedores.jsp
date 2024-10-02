<%@ page import="pe.edu.vallegrande.SisVentas.dto.Suppliers" %>
<%@ page import="pe.edu.vallegrande.SisVentas.Controller.ProveedorController" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Listado de Proveedores</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- SweetAlert2 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
    <!-- Custom CSS -->
    <link href="Css/Dashboard.css" rel="stylesheet" />
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
            <h1 class="mt-4">Listado de Proveedores</h1>

            <!-- Card para búsqueda -->
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-search"></i>
                    Buscar Proveedores
                </div>
                <div class="card-body">
                    <form id="searchForm" class="form-inline" action="listadoProveedores.jsp" method="GET">
                        <div class="form-group mx-sm-3 mb-2">
                            <input type="text" class="form-control" name="search" placeholder="Buscar por número o tipo">
                        </div>
                        <button type="submit" class="btn btn-primary mb-2">Buscar</button>
                    </form>
                </div>
            </div>

            <!-- Card para listado de proveedores -->
            <div class="card">
                <div class="card-header">
                    <i class="fas fa-users"></i>
                    Proveedores
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                            <thead class="thead-dark">
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">T. Documento</th>
                                <th class="text-center">N. Documento</th>
                                <th class="text-center">Género</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Apellido</th>
                                <th class="text-center">Direccion</th>
                                <th class="text-center">Celular</th>
                                <th class="text-center">Acciones</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                ProveedorController proveedorDAO = new ProveedorController();
                                List<Suppliers> proveedores = proveedorDAO.listaractivos();

                                if (proveedores.isEmpty()) {
                            %>
                            <tr>
                                <td colspan="9" class="text-center">No hay proveedores disponibles por el momento.</td>
                            </tr>
                            <%
                            } else {
                                for (Suppliers proveedor : proveedores) {
                            %>
                            <tr>
                                <td class="text-center"><%= proveedor.getId() %></td>
                                <td class="text-center"><%= proveedor.getDocumentType() %></td>
                                <td class="text-center"><%= proveedor.getDocumentNumber() %></td>
                                <td class="text-center"><%= proveedor.getGender() %></td>
                                <td class="text-center"><%= proveedor.getFirstName() %></td>
                                <td class="text-center"><%= proveedor.getLastName() %></td>
                                <td class="text-center"><%= proveedor.getLocation() %></td>
                                <td class="text-center"><%= proveedor.getPhone() %></td>
                                <td class="text-center">
                                    <!-- Botón Editar -->
                                    <a href="editarProveedor.jsp?id=<%= proveedor.getId() %>" class="btn btn-primary btn-sm">Editar</a>
                                    <!-- Botón Eliminar -->
                                    <button type="button" class="btn btn-danger btn-sm" onclick="confirmDelete(<%= proveedor.getId() %>)">Eliminar</button>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                            </tbody>
                        </table>
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
