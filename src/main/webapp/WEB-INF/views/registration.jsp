<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>

    <link href="/css/main.css" rel="stylesheet"/>
</head>
<body>
<ul>
    <li><a href="/signup" target="_blank">Sign Up</a></li>
    <li><a href="/listOfBooks" target="_blank">Books</a></li>
    <li><a href="/listOfAuthors" target="_blank">Authors</a></li>
    <li><a href="/listOfGenres" target="_blank">Genres</a></li>
    <li><a href="/registration" target="_blank">Registration</a></li>

    <li style="float:right"><a class="active" href="#about">About</a></li>
</ul>
<form:form modelAttribute="user" method="post" action="/saveUser">
    ${UserNameException}
    <form:input path="name"/>
    <form:input path="email"/>
    <form:input path="password"/>
    <button>save User</button>
</form:form>

<table class="border">
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Password</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
<ol>
    <c:forEach var="user" items="${users}">
        <tr>

            <td style="border: 1px solid black">${user.name}</td>
            <td style="border: 1px solid black">${user.email}</td>
            <td style="border: 1px solid black">${user.password}</td>
            <td style="border: 1px solid black"><a
                    href="/deleteUser/${user.id}">Delete</a></td>
            <td style="border: 1px solid black "><a
                    href="/updateUser/${user.id}" target="_blank">Update</a></td>
            <br>
        </tr>
    </c:forEach>
</ol>

</table>

</body>
</html>