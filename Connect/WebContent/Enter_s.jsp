
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css">
<script src="jquery.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>

<link type="text/css" rel="stylesheet" href="sidebar.css">
<link type="text/css" rel="stylesheet" href="Enter_s.css">
<script src="create_class.js"></script>

</head>
<body>

	<div id="wrapper">

		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">

				<li><a href="" data-toggle="modal" data-target="#light">Light</a></li>
				<li><a href="" data-toggle="modal" data-target="#fan">Fan</a></li>
				<li><a href="Profile">Profile</a></li>
				<li><a href="Logout">Logout</a></li>
			</ul>
		</div>

		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div>
							<img id="menu-toggle" src="button-1.png" width="30px"
								height="30px">
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="light" role="dialog">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Light</h4>
					</div>

					<div class="modal-body">

						<form action="#" role="form" method="post">

							<button type="button" class="btn btn-default" id="light_btn">check</button>
						</form>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
					</div>

				</div>

			</div>
		</div>

		<div class="modal fade" id="fan" role="dialog">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Fan</h4>
					</div>

					<div class="modal-body">

						<form action="#" role="form" method="post">

							<button type="button" class="btn btn-default" id="fan_btn">check</button>

						</form>

					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
					</div>

				</div>

			</div>
		</div>




	</div>

</body>
</html>