<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Hangman Game</h1>
            <hr/>
            
            <h2>Hang Man</h2>
            <form class="form-horizontal"
                  role="form" method="POST" 
                  action="word"> 

             <input type="submit" value="Play Game" >
            </form>
            <c:forEach var="indChar" items="${word}">
                <c:out value="${indChar} "/>
            </c:forEach>
            <p> Here are your wrong guesses</p>
            <c:forEach var="indChar" items="${lettersGuessed}">
                <c:out value="${indChar} "/>
            </c:forEach>
            </br>
            <c:out value="${loserMessage}"/>
            <hr>
            <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="sendLetter">
                <label for="input"> Choose a Letter</label>
                <input type="text" name="input">
                <input type="submit" value="Submit Guess">
               
      
                
                
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

