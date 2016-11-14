/**
 * Created by Israj PC on 11/1/2016.
 */
app.controller('dashboardController', function($scope, $http, $location, $routeParams, $cookies) {

    var getCookieAuth = $cookies.get("mapinfo-auth-cookies");

    $scope.initData = function(){
        $http({
            url: baseUrl+"/api/dashboard",
            dataType: 'json',
            method: 'GET',
            data: '',
            headers: {
                "Content-Type": "application/json",
            }

        }).success(function (response) {
            $scope.username = response.userName
        }, function myError(response) {
            console.log("load error response =", response);
        });

    };


    $scope.initData();
});