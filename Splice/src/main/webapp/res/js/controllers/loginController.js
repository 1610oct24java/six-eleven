app.controller("loginController", function ($scope, $http, $location) {

    $scope.user;
    $scope.pass;
    $scope.registerUser;
    $scope.registerPass;

    // this function pulls the login info from the textfields and sends as a http post
    $scope.doLogin = function() {
        // JSON object
        var loginData = {username: this.user, password: this.pass};
        
        postLoginData(loginData, this.user);
        console.log("login data object: ");
        console.log(loginData)
    }
    
    // this function pulls the register info from the textfields and sends as a http post
    $scope.doRegister = function(){
        // JSON object
        var registerData = {username:this.registerUser,password:this.registerPass};
        
        postRegisterData(registerData, this.registerUser);
        
        console.log("Username: " + this.registerUser + " Password: " + this.registerPass);
        console.log("register data: " + registerData); 
    }
    
    // postData takes in JSON, sends with HTTP POST to Spring LoginController
    function postLoginData(data, username){
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
                console.log("Your username or password was wrong!");
            }
        }).error(function (response){
            console.log("login error");
        });
    }
    
    // postData takes in JSON, sends with HTTP POST to Spring LoginController
    function postRegisterData(data, username){
        $http({
            method: 'POST',
            url: '/Splice/register',
            headers: {'Content-Type': 'application/json'},
            data: data
        }).success(function (data){
            console.log(data);
            if(data.success == "ok")
            {
                console.log("OK! received successful register");
            }else {
                //display failed login message
                console.log("Bad! received failed register");
            }
        }).error(function (response){
            console.log("received error while registering");
        });
    }
});