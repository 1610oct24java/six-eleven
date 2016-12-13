app.controller("lobbyController", function($scope, $http, $location) {
    
    $scope.playerCount = 0;
    $scope.onlineUser = authUser;
    
    $scope.playerList = [ {
        playerName : authUser
    }];
    
    $scope.gameList = [ {
        playerCount : '0',
        creator : 'Ric',
        gameName : 'beginners only'
    }];
    
    $scope.createGame = function(){
        $scope.gameList.push({playerCount:$scope.playerCount,creator:$scope.username,gameName:$scope.gameName});
        
        //var newGameData = {playerCount:$scope.playerCount,creator:$scope.username,gameName:$scope.gameName});
        
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
    }
});
