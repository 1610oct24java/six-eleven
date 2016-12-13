app.controller("queueController", function($scope, $http, $location) {
    
    $scope.startGame = function(){
//      $http({
//          method: 'POST',
//          url: 'StartGame.do',
//          headers: {'Content-Type': 'application/json'},
//          //data: data
//      }).success(function (output){
//          //console.log("JSON output: " + JSON.parse(output));
//          $location.path="/game";
//      });
        $location.path("/game");
    }
    
    $scope.leaveGame = function(){
//      $http({
//          method: 'POST',
//          url: 'LeaveGame.do',
//          headers: {'Content-Type': 'application/json'},
//          //data: data
//      }).success(function (output){
//          //console.log("JSON output: " + JSON.parse(output));
//          //$location.path="/lobby";
//      });
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