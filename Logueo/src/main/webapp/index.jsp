<!DOCTYPE html>
<html>
<head>
	<title>LOGIN</title>
	<meta charset="utf-8">

	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/js" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js">
	<link rel="stylesheet" type="text/js" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel= "stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body background="img/fondo.jpg">
	<form action="serveletUser" method="post">
<h1><MARQUEE >WELCOME TO THE SYSTEM</MARQUEE></h1>
<div class="modal-dialog text-center">
<div class="col-sm-8 main-section">
<div class="modal-content">
<div class="col-12 user-img">
<img src="img/inicio.png" >
</div>
<form class="col-12">
<div class="form-group">
<i class="fas fa-user">USER</i>
<input type="text" class="form-control" placeholder="Username" name="usuario">
<div class="form-group">
<i class="fas fa-lock">PASSWORD</i>
<input type="password" class="form-control" placeholder="user password" name="contra">
</div>
<button type="submit" class="btn btn-warning" name="ingresar"><i class="fas fa-sign-in-alt">Log in</i>	
</button>
</form>	
<div class="col-12 forgot">
<a href="#">Forgot your password?</a>
</div >
<a href="registro.jsp">Sign up</a>

<div></div>
</div> <!--------End of Modal Content ----------->
</div>
</div>
</form>
</div>

</body>
</html>