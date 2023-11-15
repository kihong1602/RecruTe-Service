<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="xlink" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시험 페이지</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="${requestScope.getContextPath}/css/layout.css">
</head>
<body class="bg-gray-100 p-4">
<div class="max-w-xl mx-auto bg-white rounded-lg shadow-lg p-6">
    <h1 class="text-2xl font-bold mb-4">시험 문제</h1>
    <ul>
        <c:forEach items="${requestScope.ExamList}" var="exam" varStatus="status">
            <li class="mb-4">
                <div class="font-bold">${status.index+1}번 문제</div>
                <p>${exam.question}</p>
                <div class="font-bold mt-2"></div>
                <p id="answer${status.index+1}">${exam.answer}</p>
            </li>
        </c:forEach>
    </ul>
    <a
            class="group flex items-center justify-between gap-4 rounded-lg border border-indigo-600 bg-indigo-600 px-5 py-3 transition-colors hover:bg-transparent focus:outline-none focus:ring"
            href="javascript:submit()"
    >
  <span
          class="font-medium text-white transition-colors group-hover:text-indigo-600 group-active:text-indigo-500"
  >
    제출하기
  </span>

        <span
                class="shrink-0 rounded-full border border-current bg-white p-2 text-indigo-600 group-active:text-indigo-500"
        >
    <svg
            class="h-5 w-5 rtl:rotate-180"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
    >
      <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M17 8l4 4m0 0l-4 4m4-4H3"
      />
    </svg>
  </span>
    </a>
</div>
<script>
  function submit() {
    let answerSize = Number('${requestScope.size}');
    let answers = [];

    for (let i = 1; i <= answerSize; i++) {
      let answerId = 'answer' + i;
      console.log(answerId);
      let answerText = document.getElementById(answerId).textContent;
      answers.push({answer: answerText});
    }

    submitExamination(answers);
  }
</script>
<script src="../../js/examination.js"></script>
</body>
</html>
