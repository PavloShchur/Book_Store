<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/signUp" target="_blank">Sign Up</a></li>
                </sec:authorize>

                <li><a href="/listOfBooks" target="_blank">Books</a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/listOfAuthors" target="_blank">Authors</a></li>
                    <li><a href="${pageContext.request.contextPath}/listOfGenres" target="_blank">Genres</a></li>
                    <li><a href="/country" target="_blank">Country</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li>
                    <li><a href="/profile" target="_blank">Profile</a></li>
                    </li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form:form action="/logout" method="post">
                            <button class="btn btn-default">logout</button>
                        </form:form>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8 col-md-8 col-sm-6 col-xs-4">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 col-sm-6 hidden-sx"></div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<br>
<br>
<br>
<br>
<br>
