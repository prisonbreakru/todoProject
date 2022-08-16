<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Todo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<h1></h1>

<body>
<div class="row">
    <div class="col-md-8 offset-2">
        <h1>Todo`s List</h1>
        <a href="/api/v1/todo/add" style="margin-left: 70%" type="button" class="btn btn-success">ADD NEW</a>

        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>name</th>
                <th>time</th>
                <th>date</th>
                <th>status</th>
                <th>action</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todoList}" var="todo" varStatus="cnt">
                <tr>
                    <td>${cnt.count}</td>
                    <td>${todo.todo}</td>
                    <td>${todo.time}</td>
                    <td>${todo.date}</td>
                    <c:if test="${todo.completed==false}">
                    <td>Not Done</td>
                    </c:if>
                    <c:if test="${todo.completed==true}">
                    <td>Done</td>
                    </c:if>
                    <td>
                        <a href="/api/v1/todo/completed/${todo.id}" type="button" class="btn btn-primary">completed</a>
                        <a href="/api/v1/todo/edit/${todo.id}" type="button" class="btn btn-warning">edit</a>
                        <a href="/api/v1/todo/delete/${todo.id}" type="button" class="btn btn-danger">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>

</body>
</html>