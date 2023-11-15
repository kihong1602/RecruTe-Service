<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jujuri's Web Page</title>
<script src="../../js/jquery-3.7.1.min.js"></script>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<form action="/recrute/exam" method="post" class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
		<div class="mx-auto max-w-lg">
			<h1
				class="text-center text-2xl font-bold text-pink-500 sm:text-3xl">
				write down your applicant number!</h1>



			<div
				class="mb-0 mt-6 space-y-4 rounded-lg p-4 shadow-lg sm:p-6 lg:p-8">
				<!-- <p class="text-center text-lg font-medium">Sign in to your account</p> -->
				<div>
					<label for="text" class="sr-only">Password</label>

					<div class="relative">
						<input type="hidden" name="examId" value="${examId}">
						<input type="text" name="aptId"
							class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
							placeholder="ex) RCT12345678"> <span
							class="absolute inset-y-0 end-0 grid place-content-center px-4">
							<svg xmlns="http://www.w3.org/2000/svg"
								class="h-4 w-4 text-gray-400" fill="none" viewBox="0 0 24 24"
								stroke="currentColor">
              <path stroke-linecap="round" stroke-linejoin="round"
									stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path>
              <path stroke-linecap="round" stroke-linejoin="round"
									stroke-width="2"
									d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"></path>
            </svg>
						</span>
					</div>
				</div>

				<button id="btnVerify"
					class="block w-full rounded-lg bg-pink-300 px-5 py-3 text-sm font-medium text-white">
					Verify</button>


			</div>
		</div>
	</form>
	<!-- <script>
	$("#btnVerify").on("click", function() {
		$.ajax({
			url : "/recrute/exam/${examId}/auth-process",
			//dataType : "json",
			data : {
				examId : ${examId},
				aptId : $("#aptId").val(),	
			},
			method : "post",
			/* success : function(data) {
				if (data.id !== null && data.pw !== null) {
					location.href = "/recrute/exam";
				}
			},
			error:function() {
				alert("write down your apt number before moving on to the next page");
			}, */
			complete : function(data) {
				console.log("complete");
				console.log(data);
			},
		});
		return false;
	});
	</script> -->
</body>
</html>
