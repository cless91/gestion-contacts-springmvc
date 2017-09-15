var app = angular.module('myApp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap', 'contactsList']);

app.controller('CreateUserController', function ($scope, $uibModal, $log, $document) {
	var $ctrl = this;

	$ctrl.animationsEnabled = true;

	$ctrl.open = function (size, parentSelector) {
		var parentElem = parentSelector ? 
				angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
				var modalInstance = $uibModal.open({
					animation: $ctrl.animationsEnabled,
					ariaLabelledBy: 'modal-title',
					ariaDescribedBy: 'modal-body',
					templateUrl: 'myModalContent.html',
					controller: 'ModalInstanceCtrl',
					controllerAs: '$ctrl',
					size: size,
					appendTo: parentElem
				});

				modalInstance.result.then(function (selected) {
				}, function () {
					$log.info('Modal dismissed at: ' + new Date());
				});
	};

	$ctrl.openComponentModal = function () {
		var modalInstance = $uibModal.open({
			animation: $ctrl.animationsEnabled,
			component: 'modalComponent'
		});

		modalInstance.result.then( function () {
			$log.info('modal-component dismissed at: ' + new Date());
		});
	};

	$ctrl.openMultipleModals = function () {
		$uibModal.open({
			animation: $ctrl.animationsEnabled,
			ariaLabelledBy: 'modal-title-bottom',
			ariaDescribedBy: 'modal-body-bottom',
			templateUrl: 'stackedModal.html',
			size: 'sm',
			controller: function($scope) {
				$scope.name = 'bottom';  
			}
		});

		$uibModal.open({
			animation: $ctrl.animationsEnabled,
			ariaLabelledBy: 'modal-title-top',
			ariaDescribedBy: 'modal-body-top',
			templateUrl: 'stackedModal.html',
			size: 'sm',
			controller: function($scope) {
				$scope.name = 'top';  
			}
		});
	};

	$ctrl.toggleAnimation = function () {
		$ctrl.animationsEnabled = !$ctrl.animationsEnabled;
	};
});

//Please note that $uibModalInstance represents a modal window (instance) dependency.
//It is not the same as the $uibModal service used above.

angular.module('myApp').controller('ModalInstanceCtrl', function ($http, $scope, $uibModalInstance) {
	var $ctrl = this;

	$ctrl.toto = function(){
		console.log("plouf");
	};

	$ctrl.ok = function () {
		console.log($scope.nomValue);
		var data = {
				"userId" : 1, 
				"nom":$scope.nomValue, 
				"prenom":$scope.prenomValue, 
				"mail":$scope.mailValue, 
				"telephone":$scope.telephoneValue};

		$http.post('http://localhost:8080/webapp-test-maven/rest/createContact',data).then(function(response) {
			$scope.contacts = response.data.contacts;
		});

		$uibModalInstance.close('toto');
	};

	$ctrl.cancel = function () {
		$uibModalInstance.dismiss('cancel');
	};
});

//Please note that the close and dismiss bindings are from $uibModalInstance.

angular.module('myApp').component('modalComponent', {
	templateUrl: 'myModalContent.html',
	bindings: {
		resolve: '<',
		close: '&',
		dismiss: '&'
	},
	controller: function () {
		var $ctrl = this;

		$ctrl.ok = function () {
			$ctrl.close({$value: 'toto'});
		};

		$ctrl.cancel = function () {
			$ctrl.dismiss({$value: 'cancel'});
		};
	}
});
