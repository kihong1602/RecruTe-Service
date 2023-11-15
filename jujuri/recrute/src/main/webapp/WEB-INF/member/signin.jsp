<%@ include file="/WEB-INF/include/header.jsp"%>
<!--
  Heads up! 👋

  Plugins:
    - @tailwindcss/forms
-->

<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
	<div class="mx-auto max-w-lg text-center">
		<h1 class="text-2xl font-bold sm:text-3xl">Login Page</h1>
	</div>

	<div class="mx-auto mb-0 mt-8 max-w-md space-y-4">
		<div>
			<label for="id" class="sr-only">ID</label>

			<div class="relative">
				<input type="text"
					class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
					id="userId" name="userId" value="${cookie.saveIDCookie.value }" placeholder="Enter your id" />
			</div>
		</div>

		<div>
			<label for="password" class="sr-only">Password</label>
			<div class="relative">
				<input type="password"
					class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
					id="pw" name="pw" placeholder="Enter your password" />
			</div>
		</div>
		<div class="col-span-6">
            <label for="MarketingAccept" class="flex gap-4">
              <input
                type="checkbox"
                id="saveID"
                class="h-5 w-5 rounded-md border-gray-200 bg-white shadow-sm" name="saveID" <c:if test="${not empty cookie.saveIDCookie }">checked</c:if>
              />

              <span class="text-sm text-gray-700">
                remember Me?
              </span>
            </label>
          </div>






		<div class="flex items-center justify-between">
			<!-- <p class="text-sm text-gray-500">
        No account?
        <a class="underline" href="">Sign up</a>
      </p> -->

			<button type="submit"
				class="inline-block rounded-lg bg-teal-500 px-5 py-3 text-sm font-medium text-white"
				id="btnSubmit">Log In</button>
		</div>
	</div>
</div>

<script>
	$("#btnSubmit").on("click", function() {
		//console.log($("#saveID").val());
		if ($("#saveID").is(":checked")) {
			 $("#saveID").val("rememberMe");
		} else {
			$("#saveID").val(null);
		}
		$.ajax({
			url : "/recrute/signin-process",
			dataType : "json",
			data : {
				userId : $("#userId").val(),
				pw : $("#pw").val(),
				saveID : $("#saveID").val(),
			},
			method : "post",
			success : function(data) {
				//console.log("success");
				console.log(data.id);
				//{pw: '0612', id: 'jujuri'}
				if (data.id !== null && data.pw !== null) {
					//sendRedirect("/recrute/signup")
					location.href = "/recrute/index";
				}
			},
			error:function() {
				alert("Please check your id and password again.");
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