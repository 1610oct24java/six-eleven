app.controller("browserController", function($rootScope, $scope, $http, $location) {
    $scope.playerCount = 0;
    $scope.lobbyList;
    $scope.onlineUser = authUser;
    $scope.playerList;
    getNewLobbyData();
    getPlayerList();
    
    // Creates a new Lobby bean and adds a new lobby to the Lobbies List view
    $scope.createLobby = function() {  
    	$scope.lobbyName = this.lobbyName;
    	console.log("lobby name entered: " + $scope.lobbyName);
    	$scope.hostName;
    	$scope.membersNames;
    	$scope.myGame;
    	$scope.chat;
    	
    	// This is a Lobby spring bean
    	$scope.newLobby = {
    		lobbyName: $scope.lobbyName,
    		hostName: $scope.onlineUser,
    		membersNames: [
    			$scope.onlineUser
    		],
    		myGame: null,
    		chat: [""]
    	}
    	console.log("This is our lobby obj: " + $scope.newLobby);
    	
    	// Send the Lobby JSON object to the server
    	console.log("Creating new Lobby...");
        postNewLobbyData($scope.newLobby); 
        getPlayerList();
    }

    $scope.refreshLobbyData = function() {
        console.log("Hello?");

        console.log("Refreshing lobby data... " );
        getNewLobbyData();
        console.log("Refreshing player data...");
        getPlayerList();
    }
    
    function getNewLobbyData(){
    	console.log("Fetching first lobby data...");
        $http({
            method: 'GET',
            url: '/Splice/lobbyCtrl',
            headers: {'Content-Type': 'application/json'}
        }).success(function (data){
            $scope.lobbyList = data.lobbies;
        }).error(function (response){
        	console.log("Something went wrong with creating a new lobby!");
        });
    }
    
    function getPlayerList() {
        console.log("Fetching online users...");
        $http ({
            method: 'GET',
            url: '/Splice/getOnlineUsers',
            headers: {'Content-Type': 'application/json'}
        }).success (function (data){
            console.log("Players Data: " );
            console.log(data);
            $scope.playerList = data.users;
            console.log("PlayerList: " );
            console.log($scope.playerList);
        }).error (function (response) {
            console.log("ERROR: Something went wrong fetching the online users!");
        })
    }

    function postNewLobbyData(lobbyObject){
        $http({
            method: 'POST',
            url: '/Splice/lobbyCtrl',
            headers: {'Content-Type': 'application/json'},
            data: lobbyObject
        }).success(function (data){
            $scope.lobbyList = data.lobbies;
        }).error(function (response){
        	console.log("Something went wrong with creating a new lobby!");
        });
    }
    
    $scope.joinGame = function(index){
        $location.path("/queue");
    }
    
    $scope.deleteGame = function(index){
        $scope.lobbyList.splice(index,1);
    }
    
    $scope.chatlog = [{
        playerName : 'Ric',
        message : 'testing'
    }];
    
    $scope.sendMessage = function(){
        $scope.chatlog.push({playerName:$scope.username,message:$scope.message});
        
        var newMessageData = JSON.stringify({chatlog:$scope.message});
        
        postNewMessage(newMessageData);
        
        console.log(newMessageData); 
        
        $scope.message = "";
    }
    
    function postNewMessage(data){
        $http({
            method: 'POST',
            url: '/Splice/sendMessage',
            headers: {'Content-Type': 'application/json'},
            data: messageData
        }).success(function (output){
            console.log("JSON output: " + JSON.parse(output));
        });
    }

    $scope.logOut = function(){
        $http({
            method: 'POST',
            url: '/Splice/logout',
            headers: {'Content-Type': 'application/json'},
            //data: data
        }).success(function (output){
            console.log("JSON output: " + JSON.parse(output));
            $location.path=("/login");
        });
    }
});