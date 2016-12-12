var app = angular.module("gameApp", [ngRoute]); 

app.config(function($routeProvider){
	$routeProvider
	.when("/", {
		templateUrl : "login-box.html",
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
});

app.controller("loginController", function($scope, $http) {

	$scope.user;
	$scope.pass;
	
	// this function pulls the login info from the textfields and sends as a http post
	$scope.getUsername = function(){
		// JSON object
		var loginData = JSON.stringify({username: $scope.user, password: $scope.pass});
		
		postData(loginData);
		console.log("Username: " + $scope.user + " Password: " + $scope.pass);
		console.log(loginData); 
	}
	
	// postData takes in JSON, sends with HTTP POST to given servlet url
	function postData(data){
		$http({
			method: 'POST',
			url: 'Login.do',
			headers: {'Content-Type': 'application/json'},
			data: data
		}).success(function (output){
			console.log(JSON.parse(output));
		});
	}
});

app.controller("lobbyController", function($scope, $http) {
	
})

app.controller("queueController", function($scope, $http) {
	
})