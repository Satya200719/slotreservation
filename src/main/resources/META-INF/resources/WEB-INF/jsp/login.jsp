<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Login</title>
<link href="/webjars/bootstrap/5.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2>Login</h2>

		<form method="post" action="/login">
			<div class="mb-3">
				<label class="form-label">Username</label> <input
					class="form-control" type="text" name="username" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label> <input
					class="form-control" type="password" name="password" required>
			</div>

			<button type="submit" class="btn btn-primary">Login</button>

			<c:if test="${param.error != null}">
				<div class="alert alert-danger mt-3">Invalid credentials</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-info mt-3">You have been logged out</div>
			</c:if>
		</form>
	</div>
</body>
</html>
