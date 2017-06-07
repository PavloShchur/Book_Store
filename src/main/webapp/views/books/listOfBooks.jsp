<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
	<link rel="stylesheet" href="/styles/main.css">
	<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sideBar.css">--%>
	<link rel="stylesheet" href="/styles/bootstrap-theme.css">
	<link rel="stylesheet" href="/styles/bootstrap.css">
	<script src="/js/index.js"></script>
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<div style="text-align: center; margin-top: 1%">

	<form:form modelAttribute="book" method="post" action="/saveBook">
		${BookNameException}
		${BookPriceException}
		<form:input path="titleOfBook" placeholder="title of book"/>
		<form:input path="priceOfBook" placeholder="priceOfBook" type="number" name="quantity" min="1" required="required"/>
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