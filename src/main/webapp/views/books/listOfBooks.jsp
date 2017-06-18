<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>


<title>Books</title>
<div style="text-align: center; margin-top: 1%">
    <form:form modelAttribute="book" method="post"
               action="/saveBook?${_csrf.parameterName}=${_csrf.token}"
               enctype="multipart/form-data">
        ${BookNameException}
        <form:input path="titleOfBook" placeholder="title of book"/>
        ${BookPriceException}
        <form:input path="priceOfBook" placeholder="priceOfBook" type="number" name="quantity" min="1"
                    required="required"/>
        <form:input path="nameOfAuthor" placeholder="nameOfAuthor" required="required"/>
        <form:input path="surnameOfAuthor" placeholder="surnameOfAuthor" required="required"/>
        <form:input path="yearOfPublishing" placeholder="yearOfPublishing" required="required"/>

        <form:select path="genre" items="${genres}" itemLabel="genreOfBook" itemValue="id"/>

        <div class="form-group">
            <input name="image" type="file" class="form-control"/>
        </div>

        <input type="submit" name="saveBook" value="SAVE"/>
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
        <th style="border: 1px solid black">Image</th>
        <th style="border: 1px solid black">Delete</th>
        <th style="border: 1px solid black">Update</th>
        <th style="border: 1px solid black">Basket</th>
        <th style="border: 1px solid black">Like</th>
    </tr>

    <c:forEach var="book" items="${books.content}">
        <tr>
            <td style="border: 1px solid black">${book.titleOfBook}</td>
            <td style="border: 1px solid black">${book.priceOfBook}</td>
            <td style="border: 1px solid black">${book.nameOfAuthor}</td>
            <td style="border: 1px solid black">${book.surnameOfAuthor}</td>
            <td style="border: 1px solid black">${book.yearOfPublishing}</td>
            <td style="border: 1px solid black">${book.genre.genreOfBook}</td>
            <td>
                <img src="${book.pathImage}" alt="NO IMAGE" width="20%" height="20%">
            </td>
            <td style="border: 1px solid black"><a href="/deleteBook/${book.id}">Delete</a></td>
            <td style="border: 1px solid black "><a href="/updateBook/${book.id}" target="_blank">Update</a></td>
            <sec:authorize access="isAuthenticated() && hasRole('ROLE_USER')">
                <td style="border: 1px solid black ">
                    <a href="/addIntoBasket/${book.id}">Basket</a>
                </td>

                <td style="border: 1px solid black ">
                    <a href="/like/${book.id}">Like</a>
                </td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>

<div style="display: flex; justify-content: center;text-align: center">

    <div class="col-md-12 col-xs-12">
        <div class="row">
            <div class="col-md-2 col-xs-6">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort<span
                            class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="Name asc" paramValue="titleOfBook"/>
                        <custom:sort innerHtml="Name desc" paramValue="titleOfBook,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-10 col-xs-12 text-center">
                <custom:pageable page="${books}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,5,10" size="${books.size}"/>
            </div>
        </div>
    </div>
</div>

