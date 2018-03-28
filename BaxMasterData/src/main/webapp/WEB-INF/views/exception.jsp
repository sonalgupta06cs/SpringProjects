<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring MVC Exception Handling</title>
</head>
<body>

<h4>There is some problem with the system.Please try after some time.</h4>

<h3>Exception:- ${errorId}</h3>
<h3>Error Message:- ${message}</h3>
<%-- <h3>Exception Name:- ${name}</h3> --%>


<c:forEach items="${exceptionPrintStack}" var="element">
    <c:out value="${element}"/>
</c:forEach>

</body>
</html>