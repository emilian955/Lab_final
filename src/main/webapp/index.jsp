<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<form action="hello-servlet">
    <label for="key">Key:</label><br>
    <input type="text" id="key" name="key"><br>
    <label for="value">Value:</label><br>
    <input type="number" id="value" name="value"><br>
    <label for="mock">Mock:</label><br>
    <input type="number" id="mock" name="mock"><br>
    <label for="sync">Sync:</label><br>
    <input type="number" id="sync" name="sync"><br>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>