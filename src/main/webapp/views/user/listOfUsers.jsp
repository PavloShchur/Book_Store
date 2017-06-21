
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery-3.2.1.min.js"></script>

<%@ page errorPage="/views/error/error403.jsp" %>


<div class="container">
    <div class="panel">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody id="result">
            </tbody>
        </table>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="/js/user.js"></script>
