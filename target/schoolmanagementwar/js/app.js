var schoolApp = angular.module('schoolApp', [ 'ngRoute', 'ngCookies',
		'schoolControllers', 'schoolFactory' ]);
schoolApp.config(function($routeProvider) {
	$routeProvider.when('/passwordReset', {
		templateUrl : 'partials/changepassword.html',
	}).when('/deleteLogin', {
		templateUrl : 'partials/deleteUser.html',
	}).when('/createLogin', {
		templateUrl : 'partials/createLogin.html',
	}).otherwise({
		redirectTo: '/'
	});
});
