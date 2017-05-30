<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
  <link rel="stylesheet" href="/styles/main.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/sideBar.css">
  <link rel="stylesheet" href="/styles/bootstrap-theme.css">
  <link rel="stylesheet" href="/styles/bootstrap.css">
  <script src="/js/index.js"></script>
  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>

</head>
<body>

<div id="mySidenav" class="sidenav">
  <div class="form-wrap">
    <div class="tabs">
      <h3 class="signup-tab"><a class="active" href="#signup-tab-content">Sign Up</a></h3>
      <h3 class="login-tab"><a href="#login-tab-content">Login</a></h3>
    </div><!--.tabs-->

    <div class="tabs-content">
      <div id="signup-tab-content" class="active">
        <form class="signup-form" action="" method="post">
          <input type="email" class="input" id="user_email" autocomplete="off" placeholder="Email">
          <input type="text" class="input" id="user_name" autocomplete="off" placeholder="Username">
          <input type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
          <input type="submit" class="button" value="Sign Up">
        </form><!--.login-form-->
        <div class="help-text">
          <p>By signing up, you agree to our</p>
          <p><a href="#">Terms of service</a></p>
        </div><!--.help-text-->
      </div><!--.signup-tab-content-->

      <div id="login-tab-content">
        <form class="login-form" action="" method="post">
          <input type="text" class="input" id="user_login" autocomplete="off" placeholder="Email or Username">
          <input type="password" class="input" id="user_pass" autocomplete="off" placeholder="Password">
          <input type="checkbox" class="checkbox" id="remember_me">
          <label for="remember_me">Remember me</label>

          <input type="submit" class="button" value="Login">
        </form><!--.login-form-->
        <div class="help-text">
          <p><a href="#">Forget your password?</a></p>
        </div><!--.help-text-->
      </div><!--.login-tab-content-->
    </div><!--.tabs-content-->
  </div><!--.form-wrap-->
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>

<div class="container textAlign">
  <div class="row">
    <h1>The name of page</h1>
  </div>
</div>

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

</body>
</html>