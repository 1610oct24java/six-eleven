var app = angular.module("spliceGame", []);

app.controller("loginCtrl", function loginCtrl($scope){
	
	//$scope.
	
});

app.controller("logoutCtrl", function logoutCtrl($scope){
	
});

app.directive("loginBox", function() {
	return{
		templateURL:"login-box.html"
	};
});

app.directive("logoutBox", function() {
	return{
		templateURL:"logout-box.html"
	};
});

//html
// <login-box></login-box>

//login-box.html
// <div> form </div>