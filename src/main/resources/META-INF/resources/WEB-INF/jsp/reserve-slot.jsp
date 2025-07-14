<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<html>
<head>
<title>Reserve Slot</title>
<link href="/webjars/bootstrap/5.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">


		<div>
			<h4 class="mt-5">My Reservations</h4>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Slot</th>
						<th>Location</th>
						<th>Start</th>
						<th>End</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${reservations}">
						<tr>
							<td>${r.parkingSlot.slotNumber}</td>
							<td>${r.parkingSlot.location}</td>
							<td>${r.startTime}</td>
							<td>${r.endTime}</td>
							<td>${r.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<h2>Reserve Parking Slot</h2>

		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<form:form method="post" action="/user/reserve"
			modelAttribute="reservation">

			<input type="hidden" name="parkingSlot.id"
				value="${reservation.parkingSlot.id}" />

			<div class="mb-3">
				<label class="form-label">Slot Number:</label> <input
					class="form-control" readonly
					value="${reservation.parkingSlot.slotNumber}" />
			</div>

			<div class="mb-3">
				<label class="form-label">Start Date:</label>
				<form:input path="startTime" cssClass="form-control" type="date" />
			</div>

			<div class="mb-3">
				<label class="form-label">End Date:</label>
				<form:input path="endTime" cssClass="form-control" type="date" />
			</div>

			<button type="submit" class="btn btn-primary">Reserve</button>
		</form:form>

		<br /> <a href="/user/dashboard" class="btn btn-link">Back</a>
	</div>
</body>
</html>
