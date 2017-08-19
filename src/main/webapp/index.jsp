<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<nav class="nav topnavPanel">

		<a class="navbar-brand nav-link" href="#">HTML</a> <a class="nav-link"
			href="#">CSS</a> <a class="nav-link" href="#">JavaScript</a> <a
			class="nav-link" href="#">Preview</a>

	</nav>

	<div class="contentPanel container-fluid">

		<div class="row">
			<div class="leftPane col-sm-3">
				<div class="card">
					<div class="card-header">
						<div class="card-title">navigation</div>
					</div>
					<div class="card-content list-group list-group-flush">
						<a class="list-group-item" href="#">contacts</a> <a
							class="list-group-item" href="#">paramètres</a>
					</div>
				</div>
			</div>

			<div class="middlePane col-sm-9">
				<!-- 			élément à répéter plusieurs fois -->

				<div class="row contact">
					<div class="col-md-2">
						<img src="images/contact_head.png" class="img"
							alt="Responsive image">
					</div>
					<div class="col-md-4">nom</div>
					<div class="col-md-4">prénom</div>
					<div class="col-md-2">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								id="about-us" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">About Us</button>
							<div class="dropdown-menu" aria-labelledby="about-us">
								<a class="dropdown-item" href="#">Our Story</a> <a
									class="dropdown-item" href="#">Our Team</a> <a
									class="dropdown-item" href="#">Contact Us</a> <a
									class="dropdown-item" href="#">Contact Us</a> <a
									class="dropdown-item" href="#">Contact Us</a> <a
									class="dropdown-item" href="#">Contact Us</a>
							</div>
						</div>
					</div>
				</div>

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


	<script type="text/javascript" src="js/angular.js"></script>
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<!-- Popper -->
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
