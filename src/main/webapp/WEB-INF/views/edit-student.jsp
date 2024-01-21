<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>EDIT STUDENT JSP PAGE</h1>

${STUDENT_FROM_DB} 

<form action="updateStudent">
ID <input type="text" name="sid1"value="${STUDENT_FROM_DB.id }  " readonly="readonly"></br></br>
FirstName<input type="text" name="sfname1" value="${STUDENT_FROM_DB.fname }"></br></br>
LastName <input type="text" name="slname1"value="${STUDENT_FROM_DB.lname }"></br></br>
Email <input type="text" name="semail1" value="${STUDENT_FROM_DB.email }"></br></br>
Phone <input type="text" name="sphone1"value="${STUDENT_FROM_DB.phone }"></br></br>
<input type="submit" value="UPDATE_STUDENT">
</form>
</body>
</html>