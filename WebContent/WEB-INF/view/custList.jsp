<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
  <title> Customer List</title>
</head>
<body>

 <div id="wrapper">
   <div id="header">
    <h2>CRM Customer Relationship Management</h2>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/sample3.css" /> 
   </div>
 </div>
 
  <div id="container">
   <div id="content">
   <input type="button"  value="add Customer"
   onclick="window.location.href='showFormAdd'; return false; " />
   
     <table>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Id</th>
        <th>Actions</th>
      </tr>
      
      <c:forEach var="tempCust" items="${customers}">
      <c:url var="updateLink" value="/customer/showUpdateForm">
       <c:param name="custId" value="${tempCust.id}"></c:param>
      </c:url>
      
      <c:url var="deleteLink" value="/customer/showDeleteForm">
       <c:param name="custId" value="${tempCust.id}"></c:param>
      </c:url>
      
      <tr>
        <td>${tempCust.fname}</td>
        <td>${tempCust.lname}</td>
        <td>${tempCust.email}</td>
        
        <td><a href="${updateLink}">Update</a></td>
        <td><a href="${deleteLink}">Delete</a></td>
        
        
      </tr>
     </c:forEach>
     </table>
  
    </div>
 </div>

  
</body>
</html>
