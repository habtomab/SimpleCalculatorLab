<%@ page import="lab.quizzes.model.entities.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: pogoromuald
  Date: 2019-08-07
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- saved from url=(0074)http://mumstudents.org/cs472/2018-09-RS/Homework/2/resources/skeleton.html -->
<html lang="en">

<%@ include file="/WEB-INF/jsp/template/header.jsp" %>
<%
  HttpSession ses = request.getSession(false);
  Object[][] tQuiz = (Object[][]) ses.getAttribute("tQuiz");
  Integer curQ = (Integer) ses.getAttribute("numQuiz");
  System.out.println("current Quiz : "+curQ);
  Quiz quiz = (Quiz)tQuiz[curQ][0];
%>
<body class="grid-container">
<div class="item1">Week 3 Lab Assignment 4 : Quiz
  By <%=(String) ses.getAttribute("firstName") + " " + (String) ses.getAttribute("lastName")%>
</div>

<div class="item2">
  <span>Quizzes : </span>
  <ul>
    <% String output = "";
      int score=0;
      for (int i = 0; i < tQuiz.length; i++) {
        Integer j = (Integer) tQuiz[i][1];
        String css = "";
        String pass = "";
        if (j == 1) {
          css = "quizPass";
          pass = " : Good";
          score++;
        }
        if (j == 2) {
          css = "quizFail";
          pass = " : Wrong";
        }
        output += "<li class=" + css + ">Q[" + (i + 1) + "] " + pass + "</li>";
      }
    %>
    <%=output %>

  </ul>
</div>
<div class="item4">
  <span>Here is your Score : <span><%=score+"/"+(curQ)%></span></span><br/>
  <form method="post" action="quizOnGoing">
    <span>Question : <%=(curQ+1)%> </span>
    <p><%=quiz.getQuestion() %></p>
    <br/>
    <span>Choices : </span>
    <p><%=quiz.getChoises() %></p>
    <br/>
    <label for="answer">Answer : </label>
    <input type="text" id="answer" name="answer" placeholder=""/>
    <br>

    <input type="submit" value="Submit"/>

  </form>
</div>
<!--<div class="item3"></div>-->
<div class="item6">

</div>

</body>

</html>
