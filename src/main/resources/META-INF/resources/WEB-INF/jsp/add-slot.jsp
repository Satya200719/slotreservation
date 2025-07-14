<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Add Parking Slot</title>
<link href="/webjars/bootstrap/5.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4">Add New Parking Slot</h2>

		<form:form method="post" modelAttribute="slot"
			action="/admin/slots/add">
			<div class="mb-3">
				<label class="form-label">Slot Number:</label>
				<form:input path="slotNumber" cssClass="form-control" />
			</div>

			<div class="mb-3">
				<label class="form-label">Location:</label>
				<form:input path="location" cssClass="form-control" />
			</div>

			<div class="mb-3 form-check">
				<form:checkbox path="active" cssClass="form-check-input" />
				<label class="form-check-label">Is Active</label>
			</div>

			<button type="submit" class="btn btn-success">Add Slot</button>
		</form:form>

		<br /> <a href="/admin/slots" class="btn btn-link mt-3">Back to
			Slot List</a>
	</div>

	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.3.7/js/bootstrap.bundle.min.js"></script>
</body>
</html>
