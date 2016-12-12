var app = angular.module('mapinfo', ['ngRoute','ngCookies','leaflet-directive', 'angularUtils.directives.dirPagination']);

app.config(function ($routeProvider,$httpProvider) {

	$routeProvider
	.when('/', {templateUrl: 'pages/dashboard.html', controller: 'dashboardController'})
	.when('/show_map', {templateUrl: 'pages/show-map.html',controller: 'showMapController'})
	.when('/manage_map', {templateUrl: 'pages/manage-map.html',controller: 'manageMapController'})
	.otherwise({redirectTo: '/'});

	$httpProvider.interceptors.push(['$q', '$location', function ($q, $location) {

		return {
			'responseError': function(response) {

				if(response.status === 401 || response.status === 403) {
					window.location = baseUrl+"/login"
				}
				return $q.reject(response);
			}
		};
	}]);

});


app.run(function($rootScope,$http) {

	$rootScope.logout = function(){

		$http({
			url: baseUrl+'/logout',
			dataType: 'json',
			method: 'POST'
		}).success(function(response){
			location.reload();
		}, function myError(response) {
			console.log("error logout =",response);
		});
	};
});