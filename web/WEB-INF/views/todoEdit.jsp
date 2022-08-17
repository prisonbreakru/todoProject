<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container bg-light">
    <div class="row">
        <div class="col-md-6">
            <form action="/api/v1/todo/edit/${todo.id}" method="post">
                <div class="form-group">
                    <label>Todo</label>
                    <input type="text" name="todo" value="${todo.todo}" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Time</label>
                    <input type="time" name= "time" value="${todo.time}" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Date</label>
                    <input type="date" name="date" value="${todo.date}" class="form-control"/>
                </div>
                <input type="hidden" value="${todo.completed}" name="completed">

                <button class="btn btn-success" type="submit">edit student</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>