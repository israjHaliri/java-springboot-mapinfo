var front = angular.module('frontApp', ['ngRoute']);
front.config(['$routeProvider', function ($routeProvider) { $routeProvider
    .when('/', {templateUrl: 'pages/login.html', controller: 'loginController'})
    .otherwise({redirectTo: '/'});
}]);


var app = angular.module('myApp', ['ngRoute', 'leaflet-directive']);
app.config(['$routeProvider', function ($routeProvider) { $routeProvider
    .when('/dashboard', {templateUrl: 'pages/dashboard.html', controller: 'dashboardController'})
    .when('/show_map', {templateUrl: 'pages/show-map.html',controller: 'showMapController'})
    .when('/manage_map', {templateUrl: 'pages/manage-map.html',controller: 'manageMapController'})
    .otherwise({redirectTo: '/'});
}]);
