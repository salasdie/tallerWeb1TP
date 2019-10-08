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



<div class="limiter">
<div class="container-login100">
<div class="wrap-login100 p-t-30 p-b-50">
<span class="login100-form-title p-b-41">
					Taller Web 1
				</span>
<form:form action="validar-login" method="POST" modelAttribute="usuario" class="login100-form validate-form p-b-33 p-t-5">


		<div class="wrap-input100 validate-input" data-validate = "Enter username">
			<form:input path="email" id="email" type="email" class="input100" name="username" placeholder="Usuario"/>
			<span class="focus-input100" data-placeholder="&#xe82a;"></span>
		</div>

		<div class="wrap-input100 validate-input" data-validate="Enter password">
			<form:input path="password" type="password" id="password" class="input100"  name="pass" placeholder="Contrasena"/>
			<span class="focus-input100" data-placeholder="&#xe80f;"></span>
		</div>

		<div class="container-login100-form-btn m-t-32">
			<button class="login100-form-btn" Type="Submit"/>
			Iniciar sesion
			</button>
		</div>

	</form:form>

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
	<script src="js/main.js"></script>
	</body>
	</html>
