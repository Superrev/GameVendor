<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View All Vendors</title>
</head>
<body>
<h1>View All Vendors</h1>
<br><br>
<table>
    <tr>
        <th>Vendor Id</th>
        <th>Vendor Title</th>
        <th>Vendor Description</th>
    <c:forEach items="${vendors}" var="vendor">
        <tr>
            <td><a href="/vendors/viewVendor?vendorId=${vendor.vendorId}"><c:out value="${vendor.vendorId}" /></a></td>
            <td><c:out value="${vendor.vendorTitle}" /></td>
            <td><c:out value="${vendor.vendorDescription}" /></td>
    </c:forEach>
</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/vendors/addVendor">Add New Vendor</a>
</body>
</body>
</html>