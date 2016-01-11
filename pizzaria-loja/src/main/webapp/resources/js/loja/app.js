'use strict';

(function(){

	var pizzaria = angular.module('pizzariaApp', []);
	pizzaria.controller('lojaController', ['$scope', '$window', '$http', lojaController]);
	
	function lojaController($scope, $window, $http){
		function getPedidos(){
			$http({
				method: 'GET',
				url: './service/pedidos',
				headers: {'Content-Type': 'application/json' }
			}).then(function(response){
				console.log(response.data);
				$scope.pedidos = response.data;
			});
		}

		angular.element(document).ready(function(){
			getPedidos();
			//setInterval(getPedidos, 6000);
		});
	}

})();
	