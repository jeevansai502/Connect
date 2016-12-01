<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
body {
	background-image: url("tree.png");
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
	background-attachment: fixed;
	color: white;
}

#profile_div{
margin-left: 10%;
width: 500px;
margin-top: 10%;
    background-color: Brown !important;
}

</style>
</head>
<body>

	<div class="panel panel-default" align="center" id="profile_div">
		<div class="panel-heading">
			<h1 class="panel-title">Profile</h1>
		</div>
		<div class="panel-body">

			<table class="table">
				<tbody>
					<%
						ArrayList<ArrayList<String>> al = (ArrayList<ArrayList<String>>) request.getAttribute("profile");
						for (ArrayList s : al) {
					%>
					<tr>
						<th style="color: red;">
							<%
								out.println(s.get(0));
							%>
						</th>
						<td>
							<%
								out.println(s.get(1));
							%>
						</td>
					</tr>
					<br>
					<%
						}
					%>

				</tbody>
			</table>

		</div>
	</div>

</body>
</html>