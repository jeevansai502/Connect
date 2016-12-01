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
<script
	src="change.js"></script>
</head>
<body>


	<div class="container" style="margin-top: 35px;">
		<div class="page-header page-heading ">
			<h1 class="text-center">
				Status
				<form action="Logout" role="form" method="get">
					<button type="submit" class="btn btn-default pull-right">Logout</button>
				</form>
			</h1>
		</div>


		<div class="tab">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><h4>Room</h4></th>
						<th class="cell-stat text-center"><h4>Bulb</h4></th>
						<th class="cell-stat text-center"><h4>Fan</h4></th>
					</tr>
				</thead>
				<tbody>

					<%
						int var = 0;	
						ArrayList<ArrayList<String>> al = (ArrayList<ArrayList<String>>) request.getAttribute("status");
						for (ArrayList s : al) {
					%>
					<tr id="<%out.print(s.get(0));%>"
								name="<%out.print(s.get(0));%>">
						<td><div>

								<%
									out.print(s.get(0));
								%>
								<br>

							</div></td>
						<td class="text-center"><button class="btn btn-default " id=<% out.print(s.get(0)); %> name=<% out.print(s.get(0)); %> onclick="fun1(this)">
							<%
								if (s.get(1).equals("1")) {
										out.print("ON");
									} else {
										out.print("OFF");
									}
							%>
							</button>
						</td>

						<td class="text-center"><button class="btn btn-default " id=<% out.print(s.get(0)); %> name=<% out.print(s.get(0)); %>  onclick="fun2(this)">
							<%
								if (s.get(2).equals("1")) {
										out.print("ON");
									} else {
										out.print("OFF");
									}
							%>
							</button>
						</td>

					</tr>

					<%
						}
					%>

				</tbody>
			</table>
		</div>

		<button type="button" class="btn btn-default pull-right"
			style="margin-bottom: 20px;">Next</button>
</body>
</html>