<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" -->
<!-- 	crossorigin="anonymous"> -->
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
</head>
<body ng-app="myApp">



	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Page 1</a></li>
				<li><a href="#">Page 2</a></li>
				<li><a href="#">Page 3</a></li>
			</ul>
		</div>
	</nav>

	<div class="contentPanel container-fluid">

		<div class="row">
			<div class="leftPane col-sm-3 sidenav">
				<h4>navigation</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#section1">contacts</a></li>
					<li><a href="#section2">paramètres</a></li>
					<li><a href="#section3">Family</a></li>
					<li><a href="#section3">Photos</a></li>
				</ul>
			</div>

			<div class="middlePane col-sm-9">
				<div ng-controller="CreateUserController as $ctrl" class="modal-demo">
					<script type="text/ng-template" id="myModalContent.html"/>
		<div class="modal-header">
			<h3 class="modal-title" id="modal-title">I'm a modal!</h3>
		</div>
		<div class="modal-body" id="modal-body">
			<form>
				<div class="form-group">
					<label for="recipient-name" class="form-control-label">nom:</label>
					<input type="text" class="form-control" ng-model="nomValue" id="nom-field">
				</div>

				<div class="form-group">
					<label for="recipient-name" class="form-control-label">prénom:</label>
					<input type="text" class="form-control" ng-model="prenomValue" id="prenom-field">
				</div>

				<div class="form-group">
					<label for="recipient-name" class="form-control-label">mail:</label>
					<input type="text" class="form-control" ng-model="mailValue" id="mail-field">
				</div>

				<div class="form-group">
					<label for="recipient-name" class="form-control-label">téléphone:</label>
					<input type="text" class="form-control" ng-model="telephoneValue" id="telephone-field">
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" type="button" ng-click="$ctrl.ok()">OK</button>
			<button class="btn btn-warning" type="button"
				ng-click="$ctrl.cancel()">Cancel</button>
		</div>
		</script>
					<script type="text/ng-template" id="stackedModal.html">
        <div class="modal-header">
            <h3 class="modal-title" id="modal-title-{{name}}">The {{name}} modal!</h3>
        </div>
        <div class="modal-body" id="modal-body-{{name}}">
            Having multiple modals open at once is probably bad UX but it's technically possible.
        </div>
    </script>

					<button type="button" class="btn btn-default"
						ng-click="$ctrl.open('sm')">Nouveau Contact</button>
					<div class="modal-parent"></div>
				</div>
				<contacts-list></contacts-list>
			</div>

		</div>
	</div>


	<footer>
		<div>
			<div class="container-fluid">
				<p>
					<a href="#">Terms &amp; Conditions</a> | <a href="#">Privacy
						Policy</a> | <a href="#">Contact</a>
				</p>
				<p>Copyright &copy; Example.com 2015</p>
			</div>
		</div>
	</footer>


	<script
		src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-sanitize.js"></script>
	<script
		src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>
	
	<script type="text/javascript" src="app/app.module.js"></script>
	<script type="text/javascript" src="app/contacts-list/contacts-list.module.js"></script>
	<script type="text/javascript" src="app/contacts-list/contacts-list.component.js"></script>

	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>
</html>
