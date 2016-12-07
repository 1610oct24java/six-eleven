var app = angular.module("gameApp", ["ngRoute"]); 

app.config(function($routeProvider){
	
	$routeProvider
	.when("/login", {
		templateUrl : "pages/login-box.html",
		controller : "loginController"
	})
	.when("/lobby", {
		templateUrl : "pages/lobby-box.html",
		controller : "lobbyController"
	})
	.when("/queue", {
		templateUrl : "pages/queue-box.html",
		controller : "queueController"
	})
	.when("/game", {
		templateUrl : "game.html",
		controller : "gameController"
	})
	.otherwise({
		redirectTo : "/login"
	})
});

app.controller("loginController", function($scope, $http, $location) {

	$scope.user;
	$scope.pass;

	// this function pulls the login info from the textfields and sends as a http post
	$scope.getUsername = function(){
		// JSON object
		var loginData = JSON.stringify({Command: "Login", Data:{username: this.user, password: this.pass}});
		
		postLoginData(loginData);
		console.log("Username: " + this.user + " Password: " + this.pass);
		console.log(loginData); 
	}
	
	$scope.testLogin = function(){
		$location.path("/lobby");
	}
	
	// postData takes in JSON, sends with HTTP POST to given servlet url
	function postLoginData(data){
		$http({
			method: 'POST',
			url: 'Login.do',
			headers: {'Content-Type': 'application/json'},
			data: data
		}).success(function (response){
			//console.log(JSON.parse(output));
			console.log(response.data);
			$location.path("/lobby");
		}).error(function (response){
			console.log(response.status);
		});
	}
});

app.controller("lobbyController", function($scope, $http) {
	
	$scope.playerCount = '1';
	$scope.username = "Henry";
	
	$scope.playerList = [ {
		playerName : 'Ric'
	}, {
		playerName : 'Henry'
	}];
	
	$scope.gameList = [ {
		playerCount : '1',
		creator : 'Ric',
		gameName : 'noobs only'
	}];
	
	$scope.createGame = function(){
		$scope.products.push({playerCount:$scope.playerCount,creator:$scope.username,gameName:$scope.gameName});
		
		var newGameData = JSON.stringify({playerCount:$scope.playerCount,creator:$scope.username,gameName:$scope.gameName});
		
		postNewGameData(newGameData);
		console.log("Username: " + this.user + " Password: " + this.pass);
		console.log(loginData); 
		$scope.gameName = "";
	}
	
	function postNewGameData(data){
		$http({
			method: 'POST',
			url: 'GameList.do',
			headers: {'Content-Type': 'application/json'},
			data: data
		}).success(function (output){
			console.log("JSON output: " + JSON.parse(output));
		});
	}
	
	$scope.joinGame = function(){
		var queueData = JSON.stringify({});
		
		postQueueData(queueData);
		console.log(queueData);
		
		$location.path("/queue");
	}
	
	$scope.deleteGame = function(index){
		$scope.gameList.splice(index,1);
	}
	
	$scope.chatlog = [];
	$scope.sendMessage = function(){
		$scope.chatlog.push({chatlog:$scope.message});
		
		var newMessageData = JSON.stringify({chatlog:$scope.message});
		
		postNewMessage(newMessageData);
		
		console.log(newMessageData); 
		$scope.gameName = "";
		
		$scope.message = "";
	}
	
	function postNewMessage(data){
		$http({
			method: 'POST',
			url: 'SendMessage.do',
			headers: {'Content-Type': 'application/json'},
			data: messageData
		}).success(function (output){
			console.log("JSON output: " + JSON.parse(output));
		});
	}

	$scope.logOut = function(){
		$http({
			method: 'POST',
			url: 'LogOut.do',
			headers: {'Content-Type': 'application/json'},
			//data: data
		}).success(function (output){
			console.log("JSON output: " + JSON.parse(output));
			$location.path="/login";
		});
		
	}
});
app.directive('playerCount', function(){
	return { template : '{{playerList.length}}'};
});
app.directive('gameCount',function(){
	return { template : '{{gameList.length}}'};
});

app.controller("queueController", function($scope, $http) {
	
});
