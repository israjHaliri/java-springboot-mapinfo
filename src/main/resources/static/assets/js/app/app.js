var app = angular.module('myApp', ['ngRoute','ngCookies','leaflet-directive', 'angularUtils.directives.dirPagination']);

app.config(['$routeProvider', function ($routeProvider) {

	$routeProvider
	.when('/', {templateUrl: 'pages/dashboard.html', controller: 'dashboardController'})
	.when('/show_map', {templateUrl: 'pages/show-map.html',controller: 'showMapController'})
	.when('/manage_map', {templateUrl: 'pages/manage-map.html',controller: 'manageMapController'})
	.otherwise({redirectTo: '/'});

}]);

app.run(function($rootScope,$location,$http) {
	$rootScope.logout = function(){

	};
});