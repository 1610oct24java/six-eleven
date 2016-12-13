app.controller("loginController", function ($rootScope, $scope, $http, $location) {

    $scope.user;
    $scope.pass;
    $scope.registerUser;
    $scope.registerPass;
    $rootScope.invalidLoginCredntialsRetrievedFromDatabase;
    $rootScope.theUsernameYouEnteredHasBeenTakenBySomeoneElse;
    $rootScope.youHaveSuccessfullyRegisteredWithSplice;
    $rootScope.loadingGIFvisible;

    // this function pulls the login info from the textfields and sends as a http post
    $scope.doLogin = function() {
        // JSON object
        var loginData = {username: this.user, password: this.pass};
        
        $rootScope.loadingGIFvisible = true;
        postLoginData(loginData, this.user);
        
        console.log("Username: " + this.user + " Password: " + this.pass);
        console.log("login data: " + loginData); 
    }
    
    // this function pulls the register info from the textfields and sends as a http post
    $scope.doRegister = function(){
        // JSON object
        var registerData = {username:this.registerUser,password:this.registerPass};
        
        $rootScope.loadingGIFvisible = true;
        postRegisterData(registerData, this.registerUser);
        
        console.log("Username: " + this.registerUser + " Password: " + this.registerPass);
        console.log("register data: " + registerData); 
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
            	$rootScope.invalidLoginCredntialsRetrievedFromDatabase = true;
            	$rootScope.loadingGIFvisible = false;
            }
        }).error(function (response){
            console.log("login error");
        });
    }
    
    // postData takes in JSON, sends with HTTP POST to Spring LoginController
    function postRegisterData(data, username)
    {
        $http({
            method: 'POST',
            url: '/Splice/register',
            headers: {'Content-Type': 'application/json'},
            data: data
        }).success(function (data){
            console.log(data);
            if(data.success == "ok")
            {
            	$rootScope.youHaveSuccessfullyRegisteredWithSplice = true;
            	$rootScope.loadingGIFvisible = false;
                console.log("OK! received successful register");
            }else {
                //display failed login message
            	$rootScope.theUsernameYouEnteredHasBeenTakenBySomeoneElse = true;
            	$rootScope.loadingGIFvisible = false;
                console.log("Bad! received failed register");
            }
        }).error(function (response){
            console.log("received error while registering");
        });
    }
});

