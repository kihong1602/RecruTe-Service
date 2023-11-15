<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<title>문제입니다.</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
    }
    h1 {
        text-align: center;
        background-color: #3498db;
        color: #fff;
        padding: 10px;
    }
    form {
        max-width: 600px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    .question {
        font-size: 18px;
    }
    .radio-group {
        margin: 10px 0;
    }
    input[type="radio"] {
        margin-right: 5px;
    }
    label {
        font-size: 16px;
        cursor: pointer;
    }
    input[type="submit"] {
        background-color: #3498db;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #2980b9;
    }
</style>


<body>
    <form>
    	<!-- 문제 풀기 -->

        <div class="question">
            <strong>1. ${examQuestion.question}</strong>
        </div>
        <div class="radio-group">
            <input type="radio" 
		            name="question1" 
		            value="" 
		            id="q1a">
            <label for="q1a">1. 볼드모트 영혼 아마도 많이 쪼개짐</label>
            <br>
            
            <input type="radio" 
		            name="question1" 
		            value="" 
		            id="q1a">
            <label for="q1a">2. 아무도 안알려줌</label>
            <br>
            
            <input type="radio" 
		            name="question1" 
		            value="" 
		            id="q1a">

            <label for="q1a">3. 7개</label>
            <br>
            
            <input type="radio" 
		            name="question1" 
		            value="" 
		            id="q1a">

            <label for="q1a">4. 배고파</label>
            <br>

        </div>

		<!-- 정답 제출 -->
        <input type="submit" value="제출">

    </form>
</body>


<%@ include file="../layout/footer.jsp"%>