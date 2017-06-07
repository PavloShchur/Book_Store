<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.05.2017
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


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
                        <li><a href="/listOfBooks" target="_blank">Books</a></li>
                        <li><a href="/listOfAuthors" target="_blank">Authors</a></li>
                        <li><a href="${pageContext.request.contextPath}/listOfGenres" target="_blank">Genres</a></li>
                        <li><a href="/registration" target="_blank">Registration</a></li>
                        <li><a href="/country" target="_blank">Country</a></li>
                        <li>
                            <form:form action="/logout" method="post">

                                <button class="btn btn-default">logout</button>

                            </form:form>
                        </li>
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
