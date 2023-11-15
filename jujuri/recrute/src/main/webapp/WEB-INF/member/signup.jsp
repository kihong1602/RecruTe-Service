<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<!--
  Heads up! 👋

  Plugins:
    - @tailwindcss/forms
-->

<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
	<div class="mx-auto max-w-lg text-center">
		<h1 class="text-2xl font-bold sm:text-3xl">Create Account</h1>
	</div>

	<form action="/recrute/signup-process"
		class="mx-auto mb-0 mt-8 max-w-md space-y-4" method="post">
		<div>
			<label for="id" class="sr-only">ID</label>

			<div class="relative">
				<input type="text"
					class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
					name="userId" id="userId" placeholder="Enter your id" />
			</div>
			<div>
				<button id="btnIdCheck"
					class="inline-block rounded bg-teal-600 px-6 py-2 text-sm font-medium text-white transition hover:scale-110 hover:shadow-xl focus:outline-none focus:ring active:bg-teal-500">id
					availablity check</button>
			</div>

			<div>
				<label for="password" class="sr-only">Password</label>
				<div class="relative">
					<input type="password"
						class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
						name="pw" id="pw" placeholder="Enter your password" />
				</div>
			</div>

			<div>
				<label for="passwordconfirm" class="sr-only">Password
					Confirm</label>
				<div class="relative">
					<input type="password"
						class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
						name="pwConfirm" id="pwConfirm" placeholder="Password confirm" />
				</div>
				<div class="invalid-feedback"></div>
			</div>
			<div>
				<label for="name" class="sr-only">Name</label>
				<div class="relative">
					<input type="text"
						class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
						name="username" id="username" placeholder="Enter your name" />
				</div>
			</div>
			<div>
				<label for="birthdate" class="sr-only">BirthDate</label>
				<div class="relative">
					<input type="date"
						class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
						name="birth" id="birth" placeholder="Enter your birth date" />
				</div>
			</div>
			<div>
				<label for="tel" class="sr-only">PhoneNumber</label>
				<div class="relative">
					<input type="tel"
						class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
						name="phoneNum" id="phoneNum" placeholder="01012345678" />
				</div>
			</div>
		</div>
		<!-- <div>
      <label for="gender" class="sr-only">Gender</label>
      <div class="relative">
        <input
          type=text
          class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
          placeholder="Choose your gender"
        />
        
      </div>
    </div> -->

		<fieldset class="grid grid-cols-2 gap-4">
			<legend class="sr-only">Delivery</legend>

			<div>
				<input type="radio" name="gender" value="0" id="DeliveryStandard"
					class="peer hidden [&:checked_+_label_svg]:block" checked /> <label
					for="DeliveryStandard"
					class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 peer-checked:border-teal-500 peer-checked:ring-1 peer-checked:ring-teal-500">
					<div class="flex items-center justify-between">
						<p class="text-gray-700">Male</p>

						<svg class="hidden h-5 w-5 text-teal-600"
							xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
							fill="currentColor">
          <path fill-rule="evenodd"
								d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z"
								clip-rule="evenodd" />
        </svg>
					</div>

				</label>
			</div>

			<div>
				<input type="radio" name="gender" value="1" id="DeliveryPriority"
					class="peer hidden [&:checked_+_label_svg]:block" /> <label
					for="DeliveryPriority"
					class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 peer-checked:border-teal-500 peer-checked:ring-1 peer-checked:ring-teal-500">
					<div class="flex items-center justify-between">
						<p class="text-gray-700">Female</p>

						<svg class="hidden h-5 w-5 text-teal-600"
							xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"
							fill="currentColor">
          <path fill-rule="evenodd" s
								d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z"
								clip-rule="evenodd" />
        </svg>
					</div>
				</label>
			</div>
		</fieldset>


		<div>
			<label for="email" class="sr-only">Email</label>

			<div class="relative">
				<input type="email"
					class="rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
					id="email" name="email" placeholder="0000@naver.com" />
					<button class="inline-block rounded bg-teal-600 px-6 py-2 text-sm font-medium text-white transition hover:scale-110 hover:shadow-xl focus:outline-none focus:ring active:bg-teal-500" id="btnVerifyEmail">
				verify email</button>
			</div>
		</div>

		<div>
			<div class="relative">
				<input type="text"
					class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm" 
					id="emailCheck" placeholder="put your verification code here" />
			</div>
		</div>

		<div class="flex items-center justify-between">
			<!-- <p class="text-sm text-gray-500">
        No account?
        <a class="underline" href="">Sign up</a>
      </p> -->
			<button type="submit"
				class="inline-block rounded-lg bg-teal-500 px-5 py-3 text-sm font-medium text-white"
				id="btnSubmit">Sign Up</button>
		</div>
	</form>
</div>
<script>
let btnIdCheck = false;
$("#pwConfirm").on("keyup", function() {
	if ($("#pw").val() !== $("#pwConfirm").val()) {
		$(".invalid-feedback").show();
		$(".invalid-feedback").text("the password is not equivalent");
	} else {
		$(".invalid-feedback").hide();
		$(".invalid-feedback").text("");
	}

});
$("#btnIdCheck").on("click", function() {
	$.ajax({
		url : "/recrute/id-check",
		data : {
			userId : $("#userId").val(),
		},
		method: "get",
		success : function(data) {
			console.log("success");
			console.log(data);
			console.log(data.count);
			if (data.count > 0) {
				alert("쓸 수 없는 아이디입니다.");
				$("#userId").val("");
			} else {
				const useID = confirm("쓸 수 있는 아이디 입니다. 사용하시겠어요?");
				if (useID) {
					$("#userId").attr("readonly", true);
					btnIdCheck = true;
				}
			}
		},
		complete : function(data) {
			console.log("complete");
			console.log(data);
		},
	});
	return false;
});

let code = "";
$("#btnVerifyEmail").on("click", function(e) {
	$.ajax({
		url : "/recrute/email-check",
		data : {
			email : $("#email").val(),
		},
		method: "get",
		success : function(data) {
			console.log("success");
			console.log(data);
			if (data.sent === "true") {
				alert("해당 이메일로 인증키를 전송하였습니다.");
				code = data.code;
			} else {
				alert("해당 이메일로 인증키를 전송하는데 실패하였습니다.");
			}
		},
		complete : function(data) {
			console.log("complete");
			console.log(data);
		},
	});
	return false;
})
$("#btnSubmit").on("click", function(e) {
	if ($("#userId").val() === "") {
		//e.preventDefault();
		alert("id는 필수입력 사항입니다.");
		//member.userID.value = "";
		//member.userID.focus();
		return false;
	} else if ($("#pw").val() === "") {
		alert("passwords는 필수입력 사항입니다.");
		return false;
	} else if ($("#pwConfirm").val() === "") {
		alert("password확인은 필수입니다.");
		return false;
	} else if($("#userName").val() === "") {
		alert("이름 기입은 필수입니다.");
		return false;
	}
	else if($("#birth").val() === "") {
		alert("생년월일 기입은 필수입니다.");
		return false;
	}
	else if($("#phoneNum").val() === "") {
		alert("전화번호 기입은 필수입니다.");
		return false;
	}
	else if($("#gender").val() === null) {
		alert("성별 체크는 필수입니다.");
		return false;
	}
	else if($("#emailCheck").val() !== code) {
		alert("이메일 인증 키를 다시 한 번 확인해 주세요.");
		return false;
	
	} else if (!btnIdCheck) {
		alert("아이디 중복 체크를 해주세요.");
		return false;
	}
});
</script>
<%@ include file="/WEB-INF/include/footer.jsp"%>