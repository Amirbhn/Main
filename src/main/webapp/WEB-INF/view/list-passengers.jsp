<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Passengers</title>
    <!-- reference our style sheet -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Passenger Management</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Passenger"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />
        <!--  add our html table here -->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Birthdate</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Gender</th>
                <th>Number</th>
                <th>Street Address</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>Zip Code</th>
                <th>From City</th>
                <th>Departure Date</th>
                <th>Departure Time</th>
                <th>To City</th>
                <th>Destination Date</th>
                <th>Destination Time</th>
                <th>Action</th>
            </tr>
            <!-- loop over and print our passengers -->
            <c:forEach var="tempPassenger" items="${passengers}">


                <!--
                construct an "update" link with passenger id
                http://localhost:8080/00-Spring-Hibernate-CRUD-Final/passenger/showFormForUpdate?passengerId=5
                -->
                <c:url var="updateLink" value="/passenger/showFormForUpdate">
                    <c:param name="passengerId" value="${tempPassenger.id}"/>
                </c:url>

                <!--
                Construct an "delete" link with passenger id
                http://localhost:8080/00-Spring-Hibernate-CRUD-Final/customer/delete?customerId=5
                -->
                <c:url var="deleteLink" value="/passenger/delete">
                    <c:param name="passengerId" value="${tempPassenger.id}"/>
                </c:url>

                <tr>
                    <td>${tempPassenger.firstName}</td>
                    <td>${tempPassenger.lastName}</td>
                    <td>${tempPassenger.birthdate}</td>
                    <td>${tempPassenger.email}</td>
                    <td>${tempPassenger.phone}</td>
                    <td>${tempPassenger.gender}</td>
                    <td>${tempPassenger.number}</td>
                    <td>${tempPassenger.streetAddress}</td>
                    <td>${tempPassenger.city}</td>
                    <td>${tempPassenger.state}</td>
                    <td>${tempPassenger.country}</td>
                    <td>${tempPassenger.zipCode}</td>
                    <td>${tempPassenger.fromCity}</td>
                    <td>${tempPassenger.departureDate}</td>
                    <td>${tempPassenger.departureTime}</td>
                    <td>${tempPassenger.toCity}</td>
                    <td>${tempPassenger.departureDate}</td>
                    <td>${tempPassenger.destinationTime}</td>


                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this passenger?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>