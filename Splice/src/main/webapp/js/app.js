var app = angular.module("gameApp", []); 
app.controller("myCtrl", function($scope, $http) {

	$scope.user;
	$scope.pass;
	
	// this function pulls the login info from the textfields and sends as a http post
	$scope.getUsername = function(){
		// JSON object
		var loginData = JSON.stringify({user: {userId: -1, username: $scope.user, password: $scope.pass}});
		
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
