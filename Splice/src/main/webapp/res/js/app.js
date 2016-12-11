var app = angular.module("gameApp", ["ngRoute"]); 

var authUser = null;
var sorcerers = [
     	        {
     	            name: 'Xanitov, Radiant Husk',
     	            vit: 5,
     	            pow: 6,
     	            def: 5,
     	            spd: 6,
     	            int: 7,
     	            flavor: "Power.  It comes at a cost.  Xanitov knew that better than most people knew how to breathe.  He understood the risks, he understood the pain.  But he also understood that it was worth it.",
     	            favStat: 2,
     	            dmpStat: 5,
     	            image: "stickSorc.png"
     	        }
     	    ];
     	    
     	    var creatures = [
     	        {
     	            name: 'Grand Hart',
     	            vit: 5,
     	            pow: 2,
     	            def: 2,
     	            spd: 2,
     	            int: 0,
     	            flavor: "A noble creature with a savage secret: A hart's horns will only grow a new point the next season if they spill hot blood.",
     	            favStat: 2,
     	            dmpStat: 5,
     	            image: "grand_hart.png"
     	        },
     	        {
     	            name: 'Crag Wasp',
     	            vit: 4,
     	            pow: 3,
     	            def: 2,
     	            spd: 2,
     	            int: 1,
     	            flavor: "Their hives keep the drakes from moving to the warmer southern peaks.",
     	            favStat: 4,
     	            dmpStat: 1,
     	            image: "stickSorc.png"
     	        },
     	        {
     	            name: 'Wyld Rat',
     	            vit: 5,
     	            pow: 2,
     	            def: 2,
     	            spd: 2,
     	            int: 0,
     	            flavor: "A noble creature with a savage secret: A hart's horns will only grow a new point the next season if they spill hot blood.",
     	            favStat: 2,
     	            dmpStat: 5,
     	            image: "grand_hart.png"
     	        },
     	        {
     	            name: 'Great Mantis',
     	            vit: 5,
     	            pow: 2,
     	            def: 2,
     	            spd: 2,
     	            int: 0,
     	            flavor: "A noble creature with a savage secret: A hart's horns will only grow a new point the next season if they spill hot blood.",
     	            favStat: 2,
     	            dmpStat: 5,
     	            image: "grand_hart.png"
     	        },
     	        {
     	            name: 'Cliffside Stalker',
     	            vit: 5,
     	            pow: 2,
     	            def: 2,
     	            spd: 2,
     	            int: 0,
     	            flavor: "A noble creature with a savage secret: A hart's horns will only grow a new point the next season if they spill hot blood.",
     	            favStat: 2,
     	            dmpStat: 5,
     	            image: "grand_hart.png"
     	        }
     	    ];
     	    
     	    var game = {
     	        players: [],
     	        wylds: [],
     	        deck: [],
     	        state: {
     	            round: 1,
     	            turn: 0,
     	            phase: 1,
     	        }
     	    }
     	    
     	    game.deck = creatures;

app.config(function($routeProvider){
	
	$routeProvider
	.when("/login", {
		templateUrl : "login-box.html",
		controller : "loginController"
	})
	.when("/lobby", {
		templateUrl : "lobby-box.html",
		controller : "lobbyController"
	})
	.when("/queue", {
		templateUrl : "queue-box.html",
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
	$scope.doLogin = function(){
		// JSON object
		var loginData = {username:this.user,password:this.pass};
		
		postLoginData(loginData, this.user);
		
		console.log("Username: " + this.user + " Password: " + this.pass);
		console.log("login data: " + loginData); 
	}
	
	// postData takes in JSON, sends with HTTP POST to Spring LoginController
	function postLoginData(data, username)
	{
		$http({
			method: 'POST',
			url: '/Splice/login',
			headers: {'Content-Type': 'application/json'},
			data: data
		}).success(function (data){
			console.log(data);
			if(data.success == "ok")
			{
				authUser = username;
				$location.path("/lobby");
			}else {
				//display failed login message
				console.log("Your username or password was wrong!")
			}
			
		}).error(function (response){
			
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
			url: '/Splice/gameList',
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

app.controller('WyldsController', function () {
    this.creatures = [creatures[0], creatures[1], creatures[2], creatures[3]];
});

app.controller('PlayerController', function () {
    this.sorcerer = sorcerers[0];
});

app.controller("gameController", function($scope, $http, $location) {
	
	
});


