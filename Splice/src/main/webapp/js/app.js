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
	$scope.registerUser;
	$scope.registerPass;
	
	// this function pulls the login info from the textfields and sends as a http post
	$scope.getUsername = function(){
		// JSON object
		var loginData = JSON.stringify({username: this.user, password: this.pass});
		
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
		}).success(function (output){
			//console.log(JSON.parse(output));
			$location.path("/lobby");
		});
	}
});

app.controller("lobbyController", function($scope, $http) {
	
	
	$scope.joinGame = function(){
		var loginData = JSON.stringify({});
		
		postGameListData(loginData);
		console.log(loginData);
	}
	
	function postGameListData(data){
		$http({
			method: 'POST',
			url: 'Login.do',
			headers: {'Content-Type': 'application/json'},
			data: data
		}).success(function (output){
			//console.log(JSON.parse(output));
			$location.path("/lobby");
		});
	}
	
	$http.get("some url")
	.then(function (response) {$scope.games = response.data.games;});

	$scope.chatlog = [];
	$scope.sendMessage = function(){
		$scope.chatlog.push($scope.message);
	}
})

app.controller("queueController", function($scope, $http) {
	
})
