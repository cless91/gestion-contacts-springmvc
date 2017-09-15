/**
 * 
 */
angular.module('contactsList').component('contactsList', {
	templateUrl: 'contactsList.template.html',
	controller: function GreetUserController($scope, $http) {
		$http.get('http://localhost:8080/webapp-test-maven/rest/getContacts').then(function(response) {
			$scope.contacts = response.data;
		});
		
		$scope.ctrlClickHandler = function(id){
			console.log("contact "+id+" to be deleted")
			$http.delete('http://localhost:8080/webapp-test-maven/rest/deleteContact/'+id).then(function(response) {
				console.log("contact "+id+" deleted");
				$scope.contacts = response.data.contacts;
			});
		}
	}
});