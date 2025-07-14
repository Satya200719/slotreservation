<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<html>
<head>
<title>Admin - Parking Slots</title>
<link href="/webjars/bootstrap/5.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<h2 class="mb-4">All Parking Slots</h2>

		<a class="btn btn-primary mb-3" href="/admin/slots/add">Add New
			Slot</a>

		<table class="table table-bordered table-hover">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Slot Number</th>
					<th>Location</th>
					<th>Active?</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="slot" items="${slots}">
					<tr>
						<td>${slot.id}</td>
						<td>${slot.slotNumber}</td>
						<td>${slot.location}</td>
						<td><c:choose>
								<c:when test="${slot.active}">Yes</c:when>
								<c:otherwise>No</c:otherwise>
							</c:choose></td>
						<td><a class="btn btn-sm btn-danger"
							href="/admin/slots/delete/${slot.id}"
							onclick="return confirm('Delete this slot?');">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.3.7/js/bootstrap.bundle.min.js"></script>
</body>
</html>
