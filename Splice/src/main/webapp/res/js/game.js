(function () {
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
            phase: 1
        }
    };
    
    game.deck = creatures;
    
    var app = angular.module('spliceGame', []);
    
    app.controller('WyldsController', function () {
        this.creatures = [creatures[0], creatures[1], creatures[2], creatures[3]];
    });
    
    app.controller('PlayerController', function () {
        this.sorcerer = sorcerers[0];
    });
})();
