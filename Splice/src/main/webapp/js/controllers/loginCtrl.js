//angular.module('gameApp')
//
//	.controller('LoginController', ['$rootScope', '$http', function($rootScope, $http){
//		
//		// this function pulls the login info from the textfields and sends as a http post
//		this.getUsername = function(){
//			var usernameIn = document.getElementById("username").value;
//			var passwordIn = document.getElementyById("password").value;
//			// JSON object creation
//			var loginData = JSON.stringify({Command: "Login", Data: {Username: usernameIn, Password: passwordIn}});
//			
//			postData(loginData);
//			console.log("Username: " + usernameIn + " Password: " + passwordIn);
//			console.log(loginData);
//		}
//		
////		function getUserController($scope, $http) {
////			$scope.getUserFromServer = function() {
////				$http({
////					method : 'POST',
////					url : 'GetUser.do'
////				}).success(function(data, status, hearders, config) {
////					$scope.user = data;
////				}).error(function(data, status, headers, config){
////					//error stuff goes here
////				})
////			}
////		}
//		
//		// postData takes in JSON, sends with HTTP POST to given servlet url
//		function postData(data){
//			$http({
//				method: 'POST',
//				url: 'Login.do',
//				headers: {'Content-Type': 'application/json'},
//				data: data
//			}).success(function (output){
//				console.log(JSON.parse(output));
//			});
//		}
//}]);