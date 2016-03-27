var schoolFactory = angular.module('schoolFactory', [])

schoolFactory.factory('loginService', function($http) {
	return {
		login : function(user, callback) {
			$http({
				method : 'POST',
				url : 'rest/loginService/login',
				data : angular.toJson(user, true)
			}).success(callback);
		},
		passwordReset : function(user, callback) {
			$http({
				method : 'POST',
				url : 'rest/admin/passwordReset',
				data : angular.toJson(user, true)
			}).success(callback);
		},
		deleteUser : function(user, callback) {
			$http({
				method : 'POST',
				url : 'rest/admin/deleteUser',
				data : angular.toJson(user, true)
			}).success(callback);
		},
		createUser : function(user, callback) {
			$http({
				method : 'POST',
				url : 'rest/admin/createUser',
				data : angular.toJson(user, true)
			}).success(callback);
		}
	};
});