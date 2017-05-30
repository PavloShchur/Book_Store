<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
	<link rel="stylesheet" href="/styles/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sideBar.css">
	<link rel="stylesheet" href="/styles/bootstrap-theme.css">
	<link rel="stylesheet" href="/styles/bootstrap.css">
	<script src="/js/index.js"></script>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="main">
	<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
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

<div style="text-align: center; margin-top: 1%">

	<form:form modelAttribute="book" method="post" action="/saveBook">
		${BookNameException}
		<form:input path="titleOfBook" placeholder="title of book"/>
		<form:input path="priceOfBook" placeholder="priceOfBook"/>
		<form:input path="nameOfAuthor" placeholder="nameOfAuthor"/>
		<form:input path="surnameOfAuthor" placeholder="surnameOfAuthor"/>
		<form:input path="yearOfPublishing" placeholder="yearOfPublishing"/>

		<form:select path="genre" items="${genres}" itemLabel="genreOfBook" itemValue="id"/>

		<input type="submit" name="saveBook" value="SAVE" />
		<input type="reset" value="RESET">
	</form:form>
	</div>
	
	<table style="border: 1px solid black">
		<tr>
			<th style="border: 1px solid black">Title of book</th>
			<th style="border: 1px solid black">Price if book</th>
			<th style="border: 1px solid black">Name of Author</th>
			<th style="border: 1px solid black">Surname of Author</th>
			<th style="border: 1px solid black">Year of Publishing</th>
			<th style="border: 1px solid black">Genre</th>
			<th style="border: 1px solid black">Delete</th>
			<th style="border: 1px solid black">Update</th>	
		</tr>
		
		<c:forEach var="b" items="${books}">
			<tr>
				<td style="border: 1px solid black">${b.titleOfBook}</td>
				<td style="border: 1px solid black">${b.priceOfBook}</td>
				<td style="border: 1px solid black">${b.nameOfAuthor}</td>
				<td style="border: 1px solid black">${b.surnameOfAuthor}</td>
				<td style="border: 1px solid black">${b.yearOfPublishing}</td>
				<td style="border: 1px solid black">${b.genre.genreOfBook}</td>
				<td style="border: 1px solid black"><a href="/deleteBook/${b.id}">Delete</a></td>
				<td style="border: 1px solid black "><a	href="/updateBook/${b.id}" target="_blank">Update</a></td>
					 <br>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>