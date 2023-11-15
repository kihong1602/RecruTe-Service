<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jujuri's Web Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
		<div class="mx-auto max-w-lg text-center">
			<h1 class="text-2xl font-bold sm:text-3xl">Exam Page</h1>
		</div>

		<div class="mx-auto mb-0 mt-8 max-w-md space-y-4">
			<%-- <div>
				<div class="relative">
					<c:forEach items="${examList}" var="exam" varStatus="status">
						<h2>${status.index+1}번:${exam.question }</h2>
						<p>정답: ${exam.answer }</p>
					</c:forEach>

				</div>

			</div> --%>
			<c:forEach items="${examList}" var="exam" varStatus="status">
			<div class="exam">
				<ul> 
					<h1>${status.index+1}번: ${exam.question } </h1>
					<li>정답: ${exam.answer }</li>
				</ul>
			</div>
			</c:forEach>
			<div class="flex items-center justify-between">
				<button type="submit"
					class="inline-block rounded-lg bg-teal-500 px-5 py-3 text-sm font-medium text-white"
					id="btnSubmit">submit</button>
			</div>
		</div>
	</div>
</body>
</html>

<%@ include file="/WEB-INF/include/footer.jsp"%>