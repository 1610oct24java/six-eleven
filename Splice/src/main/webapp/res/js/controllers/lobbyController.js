app.controller("lobbyController", function($rootScope, $scope, $http, $location) {
	//
	// VARIABLE DECLARTIONS
	// 
	$scope.lobbyName = $rootScope.lobby.lobbyName;
	$scope.playerCount = $rootScope.lobby.numMembers;
    $scope.username = $rootScope.onlineUser;
    $scope.playerList = $rootScope.lobby.membersNames;
    
    $rootScope.game;
	
    $scope.startGame = function(){
    	console.log("Starting game...");
    	getGame($scope.lobbyName);        
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
		  $location.path("/game");
	  });
    }
    
    $scope.refreshData = function() {
        console.log("Refreshing player data...");
        getPlayerList($scope.lobbyName);
    }
    
    function getPlayerList(lobbyName) {
        console.log("Fetching online users...");
        $http ({
            method: 'POST',
            url: '/Splice/getUsersInLobby',
            headers: {'Content-Type': 'application/json'},
        	data: lobbyName
        }).success (function (data){
        	console.log(data);
            $scope.playerList = data;
        }).error (function (response) {
            console.log("ERROR: Something went wrong fetching the online users!");
        })
    }
    
    $scope.leaveGame = function(){
//      $http({
//          method: 'POST',
//          url: 'LeaveGame.do',
//          headers: {'Content-Type': 'application/json'},
//          //data: data
//      }).success(function (output){
//          //console.log("JSON output: " + JSON.parse(output));
//          //$location.path="/lobby";
//      });
        $location.path("/lobby");
    }
    
    $scope.playerCount = $rootScope.lobby.numMembers;
    $scope.username = $rootScope.onlineUser;
    
    $scope.playerList = $rootScope.lobby.membersNames;
    
    $scope.chatlog = [{
        playerName : 'System: ',
        message : "Welcome to the lobby!"
    }];
    
    $scope.sendMessage = function(){
        $scope.chatlog.push({playerName:$scope.username,message:$scope.message});
        
        var newMessageData = JSON.stringify({chatlog:$scope.message});
        
        postNewMessage(newMessageData);
        
        console.log(newMessageData); 
        
        $scope.message = "";
    }
    
});