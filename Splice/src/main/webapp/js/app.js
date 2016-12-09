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

app.controller("lobbyController", function($scope, $http, $location) {
	
	$scope.playerCount = '1';
	$scope.username = "Connor";
	
	$scope.playerList = [ {
		playerName : 'Ric'
	}, {
		playerName : 'Connor'
	}];
	
	$scope.gameList = [ {
		playerCount : '1',
		creator : 'Ric',
		gameName : 'noobs only'
	}];
	
	$scope.createGame = function(){
		$scope.gameList.push({playerCount:$scope.playerCount,creator:$scope.username,gameName:$scope.gameName});
		
		var newGameData = JSON.stringify({playerCount:$scope.playerCount,creator:$scope.username,gameName:$scope.gameName});
		
		postNewGameData(newGameData);
		console.log(newGameData); 
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
	
	$scope.joinGame = function(index){
		$location.path("/queue");
	}
	
	$scope.deleteGame = function(index){
		$scope.gameList.splice(index,1);
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
			$location.path=("/login");
		});
		$location.path("/login");
	}
});
app.directive('playerCount', function(){
	return { template : '{{playerList.length}}'};
});
app.directive('gameCount',function(){
	return { template : '{{gameList.length}}'};
});

app.controller("queueController", function($scope, $http, $location) {
	
	$scope.startGame = function(){
//		$http({
//			method: 'POST',
//			url: 'StartGame.do',
//			headers: {'Content-Type': 'application/json'},
//			//data: data
//		}).success(function (output){
//			//console.log("JSON output: " + JSON.parse(output));
//			$location.path="/game";
//		});
		$location.path("/game");
	}
	
	$scope.leaveGame = function(){
//		$http({
//			method: 'POST',
//			url: 'LeaveGame.do',
//			headers: {'Content-Type': 'application/json'},
//			//data: data
//		}).success(function (output){
//			//console.log("JSON output: " + JSON.parse(output));
//			//$location.path="/lobby";
//		});
		$location.path("/lobby");
	}
	
	$scope.playerCount = '1';
	$scope.username = "Connor";
	
	$scope.playerList = [ {
		playerName : 'Ric'
	}, {
		playerName : 'Connor'
	}];
	
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
	
});

app.controller("gameController", function($scope, $http, $location) {
	
});
