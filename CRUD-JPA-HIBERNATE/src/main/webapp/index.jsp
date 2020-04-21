<html>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
	$(document).ready(function () {
		
			var btn = $('#carga').val();
			$.post('ServletController', {

			}, function (response) {
				
				let datos = JSON.parse(response);
				console.log(datos);
				
				var tablaDatos = document.getElementById('tablaDatos');
				for (let item of datos) {
					tablaDatos.innerHTML += `
					<tr>
					<td>${item.id}</>
					<td>${item.nombreProducto}</>
					<td>${item.precioProducto}</>
					<td>${item.cantidadProducto}</>
					<td>${item.totalProducto}</>
					<td>
					<a href="ServletController?btn=Eliminar&Id=${item.id}" class="btn btn-warning">Eliminar</a>
					<a href="funciones.jsp?idBus=${item.id}&nombrePr=${item.nombreProducto}&precioPr=${item.precioProducto}&cantidadPr=${item.cantidadProducto}&totalPr=${item.totalProducto}" class="btn btn-danger">Actualizar</a>
					</td>
					</tr>

					`
				}
			

		});

	});

</script>


<body>
	

	
	<a href="funciones.jsp" class="btn btn-info">Agregar</a>


	<table class="table table-dark" id="tablaDatos">

		<head>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Total</th>
			<th>Opciones</th>
		</head>

		<tbody>


		</tbody>
	</table>

</body>

</html>