<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
<title>User Dashboard</title>
<link href="/webjars/bootstrap/5.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">

		<h2>Welcome to Your Dashboard</h2>

		<h4 class="mt-4">Available Parking Slots</h4>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Slot Number</th>
					<th>Location</th>
					<th>Active</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="slot" items="${availableSlots}">
					<tr>
						<td>${slot.slotNumber}</td>
						<td>${slot.location}</td>
						<td><c:choose>
								<c:when test="${slot.active}">Yes</c:when>
								<c:otherwise>No</c:otherwise>
							</c:choose></td>
						<td><a class="btn btn-sm btn-success"
							href="/user/reserve/${slot.id}">Reserve</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.3.7/js/bootstrap.bundle.min.js"></script>
</body>
</html>
