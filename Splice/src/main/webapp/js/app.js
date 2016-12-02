var app = angular.module("spliceGame", []);

app.controller('GetUserCtrl', ['$scope', '$http', function ($scope, $http) 
{
	function getUserData() {
        $http({
            method: 'POST',
            url: 'GameServlet',
            headers: {'Content-Type': 'application/json'},
            data: data
        }).success(function (data, status, headers, config) {
            $scope.user = data;
        }).error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };
}]);
