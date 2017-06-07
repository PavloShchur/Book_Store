<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/styles/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sideBar.css">
    <link rel="stylesheet" href="/styles/bootstrap-theme.css">
    <link rel="stylesheet" href="/styles/bootstrap.css">
    <script src="/js/index.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="main">
    <div class="navbar navbar-inverse navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle='collapse' data-target='#responsive-menu'>
                    <span class="sr-only">Open navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Logo</a>
            </div>
            <div class="collapse navbar-collapse" id="responsive-menu">
                <ul class="nav navbar-nav">
                    <li><a href="/signup" target="_blank">Sign Up</a></li>
                    <li class="dropdown">
                    <li><a href="/listOfBooks" target="_blank" class="dropdown-toggle" data-toggle='dropdown'>Books</a></li>
                    <ul class="dropdown-menu">
                        <li><a href="#">Option 1</a></li>
                        <li><a href="#">Option 2</a></li>
                        <li><a href="#">Option 3</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Option 4</a></li>
                    </ul>
                    </li>
                    <li><a href="/listOfBooks" target="_blank">Books</a></li>
                    <li><a href="/listOfAuthors" target="_blank">Authors</a></li>
                    <li><a href="${pageContext.request.contextPath}/listOfGenres" target="_blank">Genres</a></li>
                    <li><a href="/registration" target="_blank">Registration</a></li>
                    <li><a href="/country" target="_blank">Country</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<form:form modelAttribute="country" method="post" action="/saveCountry">
    <form:input path="nameOfCountry"/>
    <input type="submit" name="saveCountry" value="SAVE" />
    <input type="reset" value="RESET">
</form:form>

<table class="border">
    <tr>
        <th>Name of country</th>
    </tr>
    <ol>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td style="border: 1px solid black">${country.nameOfCountry}</td>
                <td style="border: 1px solid black"><a
                        href="/deleteCountry/${country.id}">Delete</a></td>
                <td style="border: 1px solid black "><a
                        href="/updateCountry/${country.id}" target="_blank">Update</a></td>
                <br>
            </tr>
        </c:forEach>
    </ol>
</table>
</body>
</html>
