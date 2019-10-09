<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Eventos</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="vendor/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="vendor/iconfonts/ionicons/css/ionicons.css">
    <link rel="stylesheet" href="vendor/iconfonts/typicons/src/font/typicons.css">
    <link rel="stylesheet" href="vendor/iconfonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="vendor/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="vendor/css/vendor.bundle.addons.css">
    <!-- endinject -->

    <link rel="stylesheet" href="css/shared/style.css">
    <link rel="stylesheet" href="css/demo_1/style.css">
    <link rel="stylesheet" href="css/styles.css">
    <!-- End Layout styles -->
</head>
<body>
<div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
            <a class="navbar-brand brand-logo" href="index.html">
               SportApp </a>
            <a class="navbar-brand brand-logo-mini" href="index.html">
                <img src="images/logo-mini.svg" alt="logo" /> </a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center">
            <ul class="navbar-nav">
                <li class="nav-item font-weight-semibold d-none d-lg-block">Taller web 1</li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown d-none d-xl-inline-block user-dropdown">
                    <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
                        <img class="img-xs rounded-circle" src="images/faces/face8.jpg" alt="Profile image"> </a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                        <div class="dropdown-header text-center">
                            <img class="img-md rounded-circle" src="images/faces/face8.jpg" alt="Profile image">
                            <p class="mb-1 mt-3 font-weight-semibold">Usuario</p>
                            <p class="font-weight-light text-muted mb-0">profesor@gmail.com</p>
                        </div>
                        <a class="dropdown-item">Mi perfil<span class="badge badge-pill badge-danger">1</span><i class="dropdown-item-icon ti-dashboard"></i></a>
                        <a class="dropdown-item">Actividad<i class="dropdown-item-icon ti-location-arrow"></i></a>
                        <a class="dropdown-item">Salir<i class="dropdown-item-icon ti-power-off"></i></a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
            <ul class="nav">
                <li class="nav-item nav-profile">
                    <a href="#" class="nav-link">
                        <div class="profile-image">
                            <img class="img-xs rounded-circle" src="images/faces/face8.jpg" alt="profile image">
                            <div class="dot-indicator bg-success"></div>
                        </div>
                        <div class="text-wrapper">
                            <p class="profile-name">Usuario</p>
                            <p class="designation">Profesor</p>
                        </div>
                    </a>
                </li>
                <li class="nav-item nav-category">Menu</li>
                <li class="nav-item">
                    <a class="nav-link" href="index.html">
                        <i class="menu-icon typcn typcn-document-text"></i>
                        <span class="menu-title">Eventos</span>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <!-- Page Title Header Starts-->
                <div class="row page-title-header">
                    <div class="col-12">
                        <div class="page-header">
                            <h4 class="page-title">Eventos</h4>
                        </div>
                    </div>
                </div>
                <!-- Page Title Header Ends-->
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Actividades</th>
                                        <th>Lugar</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${eventos}" var="evento">
                                        <tr>
                                            <td>${evento.nombre}</td>
                                            <td>${evento.descripcion}</td>
                                            <td>${evento.lugar}</td>
                                            <td><img src="${evento.urlImagen}" width="300" class="rounded"></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- content-wrapper ends -->
            <!-- partial:partials/_footer.html -->
            <footer class="footer">
                <div class="container-fluid clearfix">
                    <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2019  All rights reserved.</span>
                </div>
            </footer>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="vendor/js/vendor.bundle.base.js"></script>
<script src="vendor/js/vendor.bundle.addons.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="js/shared/off-canvas.js"></script>
<script src="js/shared/misc.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="js/demo_1/dashboard.js"></script>
<!-- End custom js for this page-->
</body>
</html>