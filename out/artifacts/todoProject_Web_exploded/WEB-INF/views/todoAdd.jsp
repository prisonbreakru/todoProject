<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Add Todo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container bg-light">
    <div class="row">
        <div class="col-md-6">
            <form action="/api/v1/todo/add" method="post">
                <div class="form-group">
                    <label>Todo</label>
                    <input type="text" name="todo" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="time">Select a time:</label>
                    <input type="time" id="time" name="time">
                </div>
                <div class="form-group">
                    <label for="date">Select a date:</label>
                    <input type="date" id="date" name="date">
                </div>
                <input type="hidden" name="completed" value="${false}"/>
                <button class="btn btn-success" type="submit">add todo</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>