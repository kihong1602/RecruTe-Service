<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<div class="flow-root rounded-lg border border-gray-100 py-3 shadow-sm">
	<form action="/recrute/apply-process" method="post" id="sendForm">
		<dl class="-my-3 divide-y divide-gray-100 text-sm">
			<input type="hidden" name="id" value="${viewHire.id }" />
			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Title</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.title }</dd>
			</div>

			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Start Date</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.start_date }</dd>
			</div>

			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Expiry Date</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.end_date }</dd>
			</div>

			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Salary</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.salary }</dd>
			</div>

			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Location</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.location }</dd>
			</div>
			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Job Type</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.work_form }</dd>
			</div>
			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Occupation</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.job }</dd>
			</div>
			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Skills</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.skills }</dd>
			</div>
			<div
				class="grid grid-cols-1 gap-1 p-3 even:bg-gray-50 sm:grid-cols-3 sm:gap-4">
				<dt class="font-medium text-gray-900">Career</dt>
				<dd class="text-gray-700 sm:col-span-2">${viewHire.career }</dd>
			</div>
		</dl>

	</form>
	<div>
		<c:choose>
			<c:when test="${empty loggedID }">
				<button id="btnEmptyApply"
					class="inline-flex items-center gap-2 rounded border border-teal-600 bg-teal-600 px-8 py-3 text-white hover:bg-transparent hover:text-teal-600 focus:outline-none focus:ring active:text-teal-500">
					<span class="text-sm font-medium"> Apply </span>
					<svg class="h-5 w-5 rtl:rotate-180"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
						stroke="currentColor">
    <path stroke-linecap="round" stroke-linejoin="round"
							stroke-width="2" d="M17 8l4 4m0 0l-4 4m4-4H3" />
  </svg>
				</button>
			</c:when>
			<c:otherwise>
				<button id="btnApply"
					class="inline-flex items-center gap-2 rounded border border-teal-600 bg-teal-600 px-8 py-3 text-white hover:bg-transparent hover:text-teal-600 focus:outline-none focus:ring active:text-teal-500">
					<span class="text-sm font-medium"> Apply </span>
					<svg class="h-5 w-5 rtl:rotate-180"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
						stroke="currentColor">
    <path stroke-linecap="round" stroke-linejoin="round"
							stroke-width="2" d="M17 8l4 4m0 0l-4 4m4-4H3" />
  </svg>
				</button>
			</c:otherwise>

		</c:choose>

	</div>
</div>
<script>
	$("#btnEmptyApply").on("click", function() {
		alert("you need to sign in first before applying");
		return false;
	});

	$("#btnApply").on("click", function() {
		console.log("log");
		$.ajax({
			url : "/recrute/apply-check",
			method : "get",
			dataType : "json",
			success : function(data) {
				console.log("success");
				console.log(data);
				if (data.count > 0) {
					alert("you have already applied to this company");
				} else {
					$("#sendForm").submit();
				}
			},
			complete : function(data) {
				console.log("complete");
				console.log(data);
			},
		});
		return false;
	});
</script>
<%@ include file="/WEB-INF/include/footer.jsp"%>