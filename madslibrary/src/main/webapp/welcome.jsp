<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>MadsLibrary</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<h1 style="text-align: center; vertical-align: middle">Welcome to
		Mads Library !!!</h1>

	<form method="post">
		<table class="table table-bordered table-hover">

			<tr>
				<td style="text-align: center; vertical-align: middle;"><a
					href="<%=request.getContextPath() %>/home?id=showBooks">Display all Books....</a></td>
			</tr>

			<tr>

				<td style="text-align: center; vertical-align: middle;"><a
				 href="addbook.jsp">Add a Book....</a></td>
			</tr>

			<tr>

				<td style="text-align: center; vertical-align: middle;"><a
				 href="adduser.jsp">Add a User....</a></td>
			</tr>

			<tr>
				<td style="text-align: center; vertical-align: middle;"><a
		         href="<%=request.getContextPath() %>/home?id=users">Display all Users....</a></td>
			</tr>

			<tr>

				<td style="text-align: center; vertical-align: middle;"><a
					href="displayuserbooks.jsp">Display Books Issued to a User....</a></td>
			</tr>

			<tr>

				<td style="text-align: center; vertical-align: middle;"><a
					href="checkoutbook.jsp" >Check-out
						a Book....</a></td>
			</tr>

			<tr>

				<td style="text-align: center; vertical-align: middle;"><a
					href="checkinbook.jsp">Check-in a Book....</a></td>
			</tr>

		</table>

	</form>
</body>
</html>