app.controller("gameController", function($scope, $http, $location) {
    this.wylds = [creatures[0], creatures[1], creatures[4], creatures[2]];
    this.players = [players[0], players[1]];
    this.state = {
        round: 1,
        turn: 0,
        phase: 1
    };
    
    this.getTurn = function () {
        return players[this.state.turn].username;
    };
    
    this.getPhase = function () {
        if (this.state.phase == 0) {
            return "Environment";
        }
        if (this.state.phase == 1) {
            return "Research";
        }
        if (this.state.phase == 2) { 
            return "Combat";
        }
    };
    
    $scope.attack = function (input) {
        console.log("Attack called");
        
        var inputData = input;
        
        var packet = {
            command: "attack",
            data: input,
            from: ""
        };
        
        packet.data = input;
        
        console.log("Attack: " + inputData);
        console.log("    Command: " + packet.command);
        console.log("    Data: " + packet.data);
        console.log("    From: " + packet.from);
    };
    
    $scope.research = function (input) {
        console.log("Research called");
        
        var inputData = input;
        
        var packet = {
            command: "research",
            data: input,
            from: ""
        };
        
        console.log("Research: " + input);
        console.log("    Command: " + packet.command);
        console.log("    Data: " + packet.data);
        console.log("    From: " + packet.from);
    };
    
});