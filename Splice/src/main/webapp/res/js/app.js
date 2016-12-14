var app = angular.module("gameApp", ["ngRoute"]);

var authUser = null;
/*var sorcerers = [
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
        },
        {
            name: 'Other, the Different',
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
        image: "crag_wasp.png"
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
        image: "wyld_rat.png"
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
        image: "great_mantis.png"
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
        image: "cliffside_stalker.png"
    }
];

var players = [
    {
        username: "aushou",
        mySorc: sorcerers[0],
        researchPool: 0,
        lab: [creatures[3]]
    },
    {
        username: "fishspit",
        mySorc: sorcerers[1],
        researchPool: 0,
        lab: [creatures[2]]
    }
];*/

app.config(function ($routeProvider) {
    
    $routeProvider
        .when("/login", {
            templateUrl : "login-box.html",
            controller : "loginController"
        })
        .when("/lobby", {
            templateUrl : "lobby-box.html",
            controller : "browserController"
        })
        .when("/queue", {
            templateUrl : "queue-box.html",
            controller : "lobbyController"
        })
        .when("/game", {
            templateUrl : "game.html",
            controller : "gameController"
        })
        .otherwise({
            redirectTo : "/login"
        });
});

app.directive('playerCount', function(){
    return { template : '{{playerList.length}}'};
});
app.directive('gameCount',function(){
    return { template : '{{lobbyList.length}}'};
});





