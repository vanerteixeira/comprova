<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html ng-app="pizzariaApp" lang="pt-br">
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pedido Cliente</title>
	</head>
	
	<body>
		<div ng-controller="pedidoClienteController">
			Pizzas - <button type="button" id="novaPizza" ng-click="novaPizza();">Nova Pizza</button>
			<div ng-repeat="s in listaSabores">
				<input type="checkbox" name="sabores" value="{{s.id}}" 
						ng-model="checkSabores[s.id]"
						class="sabor"
						ng-change="selecionarSabor(s.id); adicionarSaboresAoPedido(s);" /> {{s.nome}} - R$ {{s.preco}}
			</div>
			
			Bebidas		
			<div ng-repeat="b in listaBebidas">
				<input type="checkbox" name="bebidas"
						ng-model="checkBebidas[b.id]"
						ng-change="adicionarBebidasAoPedido(b);" 
						value="{{b.id}}" /> {{b.nome}} - R$ {{b.preco}}
			</div>
			
			Sobremesas		
			<div ng-repeat="sb in listaSobremesas">
				<input type="checkbox" name="sobremesas"
						ng-model="checkSobremesas[sb.id]"
						ng-change="adicionarSobremesasAoPedido(sb);" 
						value="{{sb.id}}" /> {{sb.nome}} - R$ {{sb.preco}}
			</div>
			
			<div>
				Pedido
				Pizzas
				<div ng-repeat="p in pedido.pizzas"> Pizza {{$index + 1}}
					<div ng-repeat="s in p.sabores">{{s.nome}}</div>
				</div>
				Bebidas
				<div ng-repeat="b in pedido.bebidas">{{b.nome}}</div>
				Sobremesas
				<div ng-repeat="sb in pedido.sobremesas">{{sb.nome}}</div>
				Total - R$ {{pedido.total}}
			</div>
			
			<div>
				<button type="button" id="finalizar" ng-click="finalizarPedido();">Finalizar</button>
			</div>
		</div>
		
	</body>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	<script src="./resources/js/cliente/app.js"></script>

</html>