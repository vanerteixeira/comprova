<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html ng-app="pizzariaApp" lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Loja</title>
	</head>
	<body>
	
		<div ng-controller="lojaController">
			
			<table border="1">
				<thead>
					<th>Ordem</th>
					<th>Status</th>
					<th>Pizza(s)</th>
					<th>Bebida(s)</th>
					<th>Sobremesa(s)</th>
					<th>Valor Total</th>
				</thead>
				<tbody>
					<tr ng-repeat="p in pedidos | orderBy:'-ordem'">
						<td>{{'#' + p.ordem}}</td>
						<td>
							<a href="#">{{(p.pedidoFechado) ? 'Fechado' : 'Aberto'}}</a>
						</td>
						<td>
							<div ng-repeat="pz in p.pizzas | orderBy:'id'">
								Pizza {{$index + 1}}
								<div ng-repeat="s in pz.sabores | orderBy:'nome'">
									{{s.nome}} 
								</div>
							</div>
						</td>
						<td>
							<div ng-repeat="b in p.bebidas | orderBy:'nome'">
								{{b.nome}}
							</div>
						</td>
						<td>
							<div ng-repeat="sb in p.sobremesas | orderBy:'nome'">
								{{sb.nome}}
							</div>
						</td>
						<td>{{p.total}}</td>
					</tr>	
				</tbody>
			</table>
		
		</div>
	</body>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	<script src="./resources/js/loja/app.js"></script>

</html>
