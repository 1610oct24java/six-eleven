app.controller("gameController", function($rootScope, $scope, $http, $location) {
    $scope.wylds = $rootScope.game.wylds;
    $scope.players = $rootScope.game.players;
    $scope.state = $rootScope.game.state;
    
    $scope.getTurn = function () {
    	var p = $rootScope.game.players[$rootScope.game.state.turn];
    	var s = p.sorc;
    	var n = s.name;
        return n;
    };
    
    $scope.getPhase = function () {
        if ($rootScope.game.state.phase == 0) {
            return "Environment";
        }
        if ($rootScope.game.state.phase == 1) {
            return "Research";
        }
        if ($rootScope.game.state.phase == 2) { 
            return "Combat";
        }
    };
    
    $scope.leaveGame = function () {
    	$location.path("/lobby");
    }
    
    $scope.checkWin = function() {
    	if ($rootScope.game.winnerIndex > 0 ) {
    		var p = $rootScope.game.players[$rootScope.game.winnerIndex];
        	var s = p.sorc;
        	var winner= s.name;
        	
        	alert(winner + " has won! ");
    	}
    }
    
    $scope.refreshGame = function () {
    	console.log("Refreshing game...");
    	wylds = $rootScope.game.wylds;
        players = $rootScope.game.players;
        state = $rootScope.game.state;
    	getGame($rootScope.lobby.lobbyName);
    }
    
    function getGame(lobbyName){
        $http({
  	      method: 'POST',
  	      url: '/Splice/getGame',
  	      headers: {'Content-Type': 'application/json'},
  	      data: lobbyName
  	  }).success(function (data){
  		  console.log(data);
  		  $rootScope.game = data;
      	checkWin();
  	  });
     }
    
    $scope.stepGame = function () {
    	console.log("Step called");
    	
    	var packet = {
    		lobbyName: $rootScope.lobby.lobbyName,
    		command: "skip",
    		data: "",
    		from: $rootScope.onlineUser
    	};
    	console.log("Skip: ");
    	console.log(packet);
    	handleCommand(packet);
    	checkWin();
    }
    
    $scope.attack = function (input) {
        console.log("Attack called");
        
        var inputData = input;
        
        var packet = {
    		lobbyName: $rootScope.lobby.lobbyName,
            command: "attack",
            data: input,
            from: $rootScope.onlineUser
        };
        console.log("Attack: " + inputData);
        console.log(packet);
        packet.data = input;
        handleCommand(packet);
    };
    
    $scope.research = function (input) {
        console.log("Research called");
        
        var p = $rootScope.game.players[$rootScope.game.state.turn];
        var rp = p.researchPool;
        var valid = rp > 0;
        
        if (!valid) {
        	alert("You have exhausted all your research this turn!");
        	$scope.stepGame();
        }
        
        var inputData = input;
        
        var packet = {
        	lobbyName: $rootScope.lobby.lobbyName,
            command: "research",
            data: input,
            from: $rootScope.onlineUser
        };
        console.log("Research: " + input);
        console.log(packet);
        handleCommand(packet);       		

    };
    
    function handleCommand(packet){
    	$http({
          method: 'POST',
          url: '/Splice/handleCommand',
          headers: {'Content-Type': 'application/json'},
          data: packet
      }).success(function (data){
          console.log("packet returned:");
          console.log(data);
          $rootScope.game = data;
      	checkWin();
      });
    }
});