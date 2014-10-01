var app = angular.module('app', []);
app.controller('MatchCtrl', ['$scope', '$http', function ($scope, $http) {
     var urlBase="";
     $scope.player1 = {};
     $scope.player2 = {};
     $scope.players = [];
     $scope.currentPlayer = {};
     $scope.currentQuestion = {};
     $scope.questionNumber = 0;
     $scope.complement = "";
     $scope.answered = false;
     $scope.startapp = false;
     $scope.jogador1 = "";
     $scope.jogador2 = "";



       function findAllTasks(_url) {
        //get all tasks and display initially

		$http({method: 'GET', url: _url}).
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

//    findAllTasks('jogador1=Grupo1;jogador2=Grupo2');

     $scope.$watch('questionNumber === 10', function() {        
          $scope.complement = " novamente ";
      });

     $scope.jogar = function (){
        $scope.player1 = {};
        $scope.player2 = {};
        $scope.players = [];
        $scope.currentPlayer = {};
        $scope.currentQuestion = {};
        $scope.questionNumber = 0;
        $scope.complement = "";
        $scope.answered = false;
        $scope.startapp = true;
        var _url = 'jogador1='+$scope.jogador1;
        _url = _url+';jogador2='+$scope.jogador2;
        findAllTasks(_url);
     }

     $scope.answer = function (value){
        $scope.message = "";
        var q = $scope.currentPlayer.questions[$scope.questionNumber];
        var alter = q.alternatives[value];
        if(alter.response){
            $scope.message = "Parabéns você acertou!";
            if($scope.currentPlayer.name == $scope.player1.name){           
                $scope.player1.questions[$scope.questionNumber].correctAnswered = true;
            }else{
            $scope.player2.questions[$scope.questionNumber].correctAnswered = true;    
            }
            
        }else{            
            if($scope.currentPlayer.name == $scope.player1.name){           
                $scope.player1.questions[$scope.questionNumber].correctAnswered = false;
            }else{
                $scope.player2.questions[$scope.questionNumber].correctAnswered = false;    
            }
            for (var i = 0; i < q.alternatives.length; i++) {
                alter = q.alternatives[i];
                if(alter.response){
                    break;
                }
            };
            $scope.message = "Oh não! Você errou! A resposta correta é "+ alter.value;
        }
        $scope.answered = true;
     }

    $scope.changeNextPlayer = function (){
        if($scope.currentPlayer.name == $scope.player1.name){           
           $scope.currentPlayer = $scope.player2;
        }
        else{            
            $scope.currentPlayer = $scope.player1;
            $scope.questionNumber = $scope.questionNumber + 1;  
            if($scope.questionNumber == 10){
               $scope.startapp = false; 
            }      
        }
        $scope.answered = false;
        
    }

 



}])
    