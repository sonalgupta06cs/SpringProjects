<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List Being added to SOAP</title>
</head>
<body>

<h2>PRODUCTS LIST BEING ADDED TO IRIS:-</h2>

<form:form method="post" action="/" modelAttribute="productList">
<table>
			<thead>
                 <tr>
                 <th>S.No.</th>
                 <th></th>
                 <th></th>
                 <th>P.Code:- </th>
                 <th>Drug:- </th>
                 <th>Manufacturer:- </th>
                 <th>D.Form:- </th>
                 <th>D.Strength:- </th>
                 <th>S.Item No.:- </th>
                 <th>L.Item No.:- </th>
                 </tr>
             </thead>
			 <c:forEach var="products" items="${productList}" varStatus="counter">
			    <%--  <h2>${counter.count}  	.)  ${products.shortItemNumber}</h2> --%>
                 
             <tbody>
                 <tr>
                 <td>${counter.count} ).</td>
                 <td>${products.shortItemNumber} --></td>
                 <td></td>
                  <td><input type="text" value="${products.productCode}"></td>
                  <td> <input type="text" value="${products.drugName}"> </td>
                  <td><input type="text" value="${products.manufacturer}"></td>
                  <td><input type="text" value="${products.dosageForm}"> </td>
                  <td><input type="text" value="${products.strength}"> </td>
                  <td><input type="text" value="${products.shortItemNumber}"></td> 
                  <td><input type="text" value="${products.longItemNumber}"></td>    
                  </tr>
             </tbody> 
                  <p>                
              </c:forEach>      
</table>		
<p>
<center><input type="submit" value="Add Products"></center>
</form:form>
</body>
</html>