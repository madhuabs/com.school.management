var schoolApp = angular.module('schoolApp', [ 'ngRoute', 'ngCookies',
		'schoolControllers', 'schoolFactory' ]);
schoolApp.config(function($routeProvider) {
	$routeProvider.when('/passwordReset', {
		templateUrl : 'partials/admin/changepassword.html',
	}).when('/deleteLogin', {
		templateUrl : 'partials/admin/deleteUser.html',
	}).when('/createLogin', {
		templateUrl : 'partials/admin/createLogin.html',
	}).otherwise({
		redirectTo: '/'
	});
});
