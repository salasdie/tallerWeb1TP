<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<link href="images/icons/favicon.ico" rel="icon" >
	<link href="fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" >
	<link href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css" rel="stylesheet" >
	<link href="vendor/animate/animate.css" rel="stylesheet" >
	<link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" >
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
	<link href="vendor/select2/select2.min.css" rel="stylesheet" >
	<link href="vendor/daterangepicker/daterangepicker.css" rel="stylesheet" >
	<link href="vendor/animsition/css/animsition.min.css" rel="stylesheet" >
	<link href="css/login/util.css" rel="stylesheet" >
	<link href="css/login/main.css" rel="stylesheet" >


</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Bienvenido</h5>
						<form:form action="validar-login" method="POST" modelAttribute="usuario" class="form-signin validate-form">
							<div class="form-label-group validate-input" data-validate = "Enter username">
								<form:input path="email" id="email" type="email" class="form-control input100" name="username" placeholder="Usuario"/>
								<span class="focus-input100" data-placeholder="&#xe82a;"></span>
							</div>

							<div class="form-label-group validate-input" data-validate="Enter password">
								<form:input path="password" type="password" id="password" class="form-control input100"  name="pass" placeholder="Contrasena"/>
								<span class="focus-input100" data-placeholder="&#xe80f;"></span>
							</div>
							<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Ingresar</button>
							<hr class="my-4">
<%--							<button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>--%>
<%--							<button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook</button>--%>
						</form:form>
					</div>
					<%--Bloque que es visible si el elemento error no está vacío	--%>
					<c:if test="${not empty error}">
						<p class=" text-center" style="color:red;font-weight:bold">${error}</p>
						<br>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="jquery.slim.min.js"></script>
	<script src="bootstrap.bundle.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
