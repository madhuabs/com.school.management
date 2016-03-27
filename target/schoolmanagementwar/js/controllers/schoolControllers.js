var countryControllers = angular.module('schoolControllers', []);

countryControllers.controller('schoolLoginCtrl', function($scope, $rootScope,
		loginService, $cookies) {
	/* Login Function */
	$scope.login = function() {
		$rootScope.initialized = true;
		$scope.errorMsg = "";
		loginService.login($scope.user, loginResponse);
	};
	/* Login Response Callback */
	loginResponse = function(data, status, headers, config) {
		$rootScope.initialized = false;
		if (data.statuscd === '1') {
			$rootScope.showLogin = false;
			console.log("Login Success cookie");
			$cookies.put('showLogin', false);
			// Add User Role also to Cookie.
		} else {
			$scope.errorMsg = data.errorDesc;
		}
	};
});

countryControllers.controller('mainController', function($scope, $rootScope,
		$location, $cookies) {
	onPageLoad = function() {
		/* Add Login URL to Cookies */
		if ($cookies.get('showLogin') !== undefined) {
			console.log("update cookie");
			$rootScope.showLogin = $cookies.get('showLogin');
			$cookies.put('showLogin', $cookies.get('showLogin'));
		} else {
			$rootScope.showLogin = true;
			console.log("add cookie");
			$cookies.put('showLogin', true);
		}
		$rootScope.initialized = false;
	};
	$scope.isActive = function(viewLocation) {
		return viewLocation === $location.path();
	};

});

countryControllers.controller('passwordResetCtrl', function($scope, $rootScope,
		$location, loginService) {
	
	$scope.deleteUser= function() {
		$scope.sucessMsg = "";
		$scope.errorMsg = "";
			loginService.deleteUser($scope.user, deleteUserResponse);
	};
	$scope.passwordReset = function() {
		$scope.sucessMsg = "";
		$scope.errorMsg = "";
		if ($scope.user.password === $scope.confirmPassword) {
			loginService.passwordReset($scope.user, pwdResetResponse);
		} else {
			$scope.errorMsg = "Password and confirm password are not same.";
		}
	};
	$scope.createUser = function() {
		$scope.sucessMsg = "";
		$scope.errorMsg = "";
		$scope.user.active = true;
		loginService.createUser($scope.user, createUserResponse);
	};
	createUserResponse = function(data, status, headers, config) {
		if (data.statuscd === '1') {
			$scope.sucessMsg = "Create User Sucessfull.";
			$scope.user = {};
		} else {
			$scope.errorMsg = data.errorDesc;
		}
	};

	pwdResetResponse = function(data, status, headers, config) {
		if (data.statuscd === '1') {
			$scope.sucessMsg = "Password Reset Sucessfull.";
			$scope.user = {};
			$scope.confirmPassword = "";
		} else {
			$scope.errorMsg = data.errorDesc;
		}
	};
	
	deleteUserResponse=function(data, status, headers, config) {
		if (data.statuscd === '1') {
			$scope.sucessMsg = "Delete User Sucessfull.";
			$scope.user = {};
		} else {
			$scope.errorMsg = data.errorDesc;
		}
	};
});
