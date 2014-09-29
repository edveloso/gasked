var app = angular.module('app', []);
app.controller('MatchCtrl', ['$scope', '$http', function ($scope, $http) {
     var urlBase="";
     $scope.player1 = {};
     $scope.player2 = {};
     $scope.players = [];
     $scope.currentPlayer = {};


       function findAllTasks() {
        //get all tasks and display initially

		$http({method: 'GET', url: 'jogador1=Grupo1;jogador2=Grupo2'}).
		  success(function(data, status, headers, config) {
		    // this callback will be called asynchronously
		    // when the response is available
		     if (data) {
                    $scope.players = data;
                    $scope.player1 = data[0];
                    $scope.player2 = data[1];
                    $scope.currentPlayer = $scope.player1;
                } else {
                    $scope.players = [];
                }   
		  }).
		  error(function(data, status, headers, config) {
		    // called asynchronously if an error occurs
		    // or server returns response with an error status.
		    console.log('err'+data);
		  });
    }

    findAllTasks();

 



}])
    