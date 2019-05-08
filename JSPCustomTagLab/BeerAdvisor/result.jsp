<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

<html>
    <body>
        <h1 align="center">Beer Recommendations JSP</h1>
        <p>
            
        <c:forEach var="style" items="${styles}">
            <br>try: ${style}
        </c:forEach>
    </body>
</html>
