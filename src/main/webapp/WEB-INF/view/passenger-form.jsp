<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Passenger</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-passenger-style.css">
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>Passenger Management</h2>
	</div>
</div>

<div id="container">
	<h3>Save Passenger</h3>

	<!--
        By clicking on submit button on the form method with @PostMapping("/savePassenger") in controller will be called
        Moreover, these fields will be saved as and object. This object will be added to Model object HashMap
        attribute by "passenger" key,

            @PostMapping("/savePassenger")
            public String savePassenger(@ModelAttribute("passenger") Passenger thePassenger)

        so savePassenger method will receive it as an argument and will cast it to Passenger object
    -->
	<form:form action="savePassenger" modelAttribute="passenger" method="POST">

		<!-- need to associate this data with passenger id -->
		<form:hidden path="id"/>

		<table>
			<tbody>
			<tr>
				<td><label>First name:</label></td>
				<td><form:input path="firstName"/></td>
			</tr>

			<tr>
				<td><label>Last name:</label></td>
				<td><form:input path="lastName"/></td>
			</tr>

			<tr>
				<td><label>Birthdate:</label></td>
				<td><form:input path="birthdate"/></td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><form:input path="email"/></td>
			</tr>

			<tr>
				<td><label>Phone:</label></td>
				<td><form:input path="phone"/></td>
			</tr>

			<tr>
				<td><label>Gender:</label></td>
				<td><form:input path="gender"/></td>
			</tr>

			<tr>
				<td><label>Number:</label></td>
				<td><form:input path="number"/></td>
			</tr>

			<tr>
				<td><label>Street Address:</label></td>
				<td><form:input path="streetAddress"/></td>
			</tr>

			<tr>
				<td><label>City:</label></td>
				<td><form:input path="city"/></td>
			</tr>

			<tr>
				<td><label>State:</label></td>
				<td><form:input path="state"/></td>
			</tr>

			<tr>
				<td><label>Country:</label></td>
				<td><form:input path="country"/></td>
			</tr>

			<tr>
				<td><label>Zip Code:</label></td>
				<td><form:input path="zipCode"/></td>
			</tr>

			<tr>
				<td><label>From City:</label></td>
				<td><form:input path="fromCity"/></td>
			</tr>

			<tr>
				<td><label>Departure Date:</label></td>
				<td><form:input path="departureDate"/></td>
			</tr>

			<tr>
				<td><label>Departure Time:</label></td>
				<td><form:input path="departureTime"/></td>
			</tr>

			<tr>
				<td><label>To City:</label></td>
				<td><form:input path="toCity"/></td>
			</tr>

			<tr>
				<td><label>Destination Date:</label></td>
				<td><form:input path="destinationDate"/></td>
			</tr>

			<tr>
				<td><label>Destination Time:</label></td>
				<td><form:input path="destinationTime"/></td>
			</tr>


			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save"/></td>
			</tr>


			</tbody>
		</table>


	</form:form>

	<div style="clear; both;"></div>

	<p>
		<a href="${pageContext.request.contextPath}/passenger/list">Back to List</a>
	</p>

</div>

</body>

</html>