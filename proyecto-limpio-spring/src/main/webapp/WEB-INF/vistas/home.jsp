<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h3 class="form-signin-heading">BUSQUEDA DE EVENTOS</h3>
		</div>

		<form:form action="buscarEvento" method="POST" modelAttribute="evento">
			<div class="form-group">
				<label>Lugar</label>
				<form:input path="evento" id="evento" type="text" class="form-control" placeholder="Lugar"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>