var app = angular.module('myApp', []);
app.
  component('contactsList', {
    templateUrl: 'contactsList.template.html',
    controller: function GreetUserController($scope, $http) {
    	$http.get('http://localhost:8080/webapp-test-maven/rest/hello/contacts').then(function(response) {
    		$scope.contacts = response.data;
          });
    }
  });