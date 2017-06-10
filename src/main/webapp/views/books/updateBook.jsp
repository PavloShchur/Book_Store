<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<title>Book update</title>

<c:url var="saveUrl" value="/updateBook/${bookAttribute.id}"/>
<form:form modelAttribute="bookAttribute" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" disabled="true"/></td>
        </tr>

        <tr>
            <td><form:label path="titleOfBook">Title of book</form:label></td>
            <td><form:input path="titleOfBook"/></td>
        </tr>

        <tr>
            <td><form:label path="priceOfBook">Price of book</form:label></td>
            <td><form:input path="priceOfBook"/></td>
        </tr>

        <tr>
            <td><form:label path="nameOfAuthor">Name of author</form:label></td>
            <td><form:input path="nameOfAuthor"/></td>
        </tr>
        <tr>
            <td><form:label path="surnameOfAuthor">Surname of author</form:label></td>
            <td><form:input path="surnameOfAuthor"/></td>
        </tr>
        <tr>
            <td><form:label path="yearOfPublishing">Year of publishing</form:label></td>
            <td><form:input path="yearOfPublishing"/></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form:form>
