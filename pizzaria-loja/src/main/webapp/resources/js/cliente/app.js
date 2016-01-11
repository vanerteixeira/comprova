'use strict';

(function(){

	var pizzaria = angular.module('pizzariaApp', []);
	pizzaria.controller('pedidoClienteController', ['$scope', '$window', '$http', pedidoClienteController]);

	function pedidoClienteController($scope, $window, $http){
		var indexPizzas = -1;
		$scope.checkSabores = [];
		$scope.checkBebidas = [];
		$scope.checkSobremesas = [];
		$scope.pedido = {
			"pizzas": [],
			"bebidas": [], 
			"sobremesas": [],
			"total": 0
		};

		function getItens(url, callback){
			$http({ 
				method: 'GET',
				url: url
			}).then(callback);
		}

		function selecionarSabor(saborId){
			var sabores = $scope.checkSabores;
			var selecionado = sabores[saborId];

			if(selecionado){
				var total = sabores.filter(function(saborCheck){ return saborCheck == true; }).length;
				if(total == 4) jQuery('.sabor').filter(':not(:checked)').prop('disabled', true);
			} else {
				var total = sabores.filter(function(saborCheck){ return saborCheck == false; }).length;
				if(total < 4) jQuery('.sabor').filter(':not(:checked)').prop('disabled', false);
			}
		}

		function recalcularTotal(){
			var total = 0;
			var maxSabor = 0;

			angular.forEach($scope.pedido.bebidas, function(bebida, idx){
				total += bebida.preco;
			});
			
			angular.forEach($scope.pedido.sobremesas, function(sobremesa, idx){
				total += sobremesa.preco;
			});

			angular.forEach($scope.pedido.pizzas, function(pizza, idx){
				angular.forEach(pizza.sabores, function(sabor, idx){
					if(sabor.preco > maxSabor) maxSabor = sabor.preco;
				});
				total += maxSabor;
			});

			return total;
		}

		function adicionarAoPedido(item, itensSelecionados, itensPedido){
			var escolhido = itensSelecionados[item.id];
			if(escolhido){
				itensPedido.push(item);
			} else {
				itensPedido.splice(itensPedido.indexOf(item), 1);				
			}
			$scope.pedido.total = recalcularTotal();
		}

		function adicionarSaboresAoPedido(sabor){
			adicionarAoPedido(sabor, $scope.checkSabores, $scope.pedido.pizzas[indexPizzas].sabores);
		}

		function adicionarBebidasAoPedido(bebida){
			adicionarAoPedido(bebida, $scope.checkBebidas, $scope.pedido.bebidas);
		}

		function adicionarSobremesasAoPedido(sobremesa){
			adicionarAoPedido(sobremesa, $scope.checkSobremesas, $scope.pedido.sobremesas);
		}

		function novaPizza(){
			indexPizzas++;
			$scope.pedido.pizzas.push({"sabores":[]});
			$scope.checkSabores = [];
			jQuery('.sabor').prop('checked', false).prop('disabled', false);
		}

		function finalizarPedido(){
			console.log($scope.pedido);
			$http({
				method: 'POST',
				url: './pedido/finalizar',
				data: JSON.stringify($scope.pedido),
				headers: {'Content-Type': 'application/json' }
			}).then(function(response){
				var ordem = response.data
				alert('Pedido realizado com sucesso. Ordem #' + ordem);
				$window.location.reload();
			});
		}

		$scope.selecionarSabor = selecionarSabor;
		$scope.adicionarSaboresAoPedido = adicionarSaboresAoPedido;
		$scope.adicionarBebidasAoPedido = adicionarBebidasAoPedido;
		$scope.adicionarSobremesasAoPedido = adicionarSobremesasAoPedido;
		$scope.novaPizza = novaPizza;
		$scope.finalizarPedido = finalizarPedido;

		angular.element(document).ready(function(){
			getItens('./sabores', function successCallback(response) {
				$scope.listaSabores = response.data;
			});
			
			getItens('./bebidas', function successCallback(response) {
				$scope.listaBebidas = response.data;
			});
			
			getItens('./sobremesas', function successCallback(response) {
				$scope.listaSobremesas = response.data;
			});
			
			novaPizza();
		});
	}

})();
