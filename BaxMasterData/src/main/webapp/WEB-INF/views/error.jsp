<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring MVC Exception Handling</title>
</head>
<body>

<h4>There is some problem with the system.Please try after some time.</h4>

<h3>Exception:- ${exception.exceptionName}</h3>
<h3>Error Message:- ${exception.exceptionMsg}</h3>


<%-- <c:if test="${exception.exceptionPrintStack != null}">
<h4><b>Technical Error Msg:-</b></h4>
<p>${exception.exceptionPrintStack} }</p>
</c:if> --%>

</body>
</html>