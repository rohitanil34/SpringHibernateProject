<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer Details</title>
</head>

<body>
 
 <form:form action="saveForm" modelAttribute="customer" methos="POST">
 <form:hidden path="id"/>
 
  <label>First name: </label>
  <form:input path="fname" />
  <br><br>
  <label>Last name:</label>
   <form:input path="lname" />
  
<br><br>
 <label>email:</label>
  <form:input path="email" />
  <br><br>
  
<br>
  <input type="submit" value="Submit">
  
  </form:form> 
 
 <p>
  <a href="${pageContext.request.contextPath}/customer/getcust" >Back</a>
 
 </p>
 
</body>
</html>  