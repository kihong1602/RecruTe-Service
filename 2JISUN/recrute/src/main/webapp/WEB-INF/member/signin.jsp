<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 
<%@ include file="../layout/header.jsp"%>


<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
  <div class="mx-auto max-w-lg text-center">
    <h1 class="text-2xl font-bold sm:text-3xl">🍀로그인🍀</h1>

    <p class="mt-4 text-gray-500">
      Welcome to my world
    </p>
  </div>


	<div class="mx-auto mb-0 mt-8 max-w-md space-y-4" 
	 	 id="join"> 
	 	  	 
	 	<!-- 아이디 -->
 		<!-- 조건문 : 쿠키(saveIdCookie)로 아이디를 기억하는 조건문 생성 -->
 		<div>
	      <label for="text" class="sr-only">아이디</label>
	      <div class="relative">
	        <input
					type="text"
					id="member_id" 
					name="member_id"
					value="${cookie.saveIdCookie.value}" 
					class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
					placeholder="아이디를 입력해주세요."/>
	
	        <span class="absolute inset-y-0 end-0 grid place-content-center px-4">
	          <svg
	            xmlns="http://www.w3.org/2000/svg"
	            class="h-4 w-4 text-gray-400"
	            fill="none"
	            viewBox="0 0 24 24"
	            stroke="currentColor">
	            <path
	              stroke-linecap="round"
	              stroke-linejoin="round"
	              stroke-width="2"
	              d="M16 12a4 4 0 10-8 0 4 4 0 008 0zm0 0v1.5a2.5 2.5 0 005 0V12a9 9 0 10-9 9m4.5-1.206a8.959 8.959 0 01-4.5 1.207"
	            />
	          </svg>
	        </span>
	      </div>
	    </div>
	    
	    

	
		<!-- 비밀번호 -->
	    <div>
	      <div class="relative">
	        <input
	       		 type="password"	
	        	  id="password"
		          name="password"
		          class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
		          placeholder="비밀번호를 입력해주세요."/>
	
	
	        <span class="absolute inset-y-0 end-0 grid place-content-center px-4">
	          <svg
	            xmlns="http://www.w3.org/2000/svg"
	            class="h-4 w-4 text-gray-400"
	            fill="none"
	            viewBox="0 0 24 24"
	            stroke="currentColor"
	          >
	            <path
	              stroke-linecap="round"
	              stroke-linejoin="round"
	              stroke-width="2"
	              d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
	            />
	            <path
	              stroke-linecap="round"
	              stroke-linejoin="round"
	              stroke-width="2"
	              d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"
	            />
	          </svg>
	        </span>
	      </div>
	    </div>
    
    	
    	<!-- 조건문 : 쿠키(saveIdCookie)로 아이디를 기억하는 조건문 생성 .-->
		<div class="flex items-center justify-between">
	    	<p class="text-sm text-gray-500"> 아이디 기억하기</p>
		    <label for="AcceptConditions"
				   class="relative h-8 w-14 cursor-pointer [-webkit-tap-highlight-color:_transparent]">

				  <input type="checkbox" 
				  		 name="save_id" 
				  		 value="rememberMe" 
				  		 <c:if test="${not empty cookie.saveIdCookie}">checked</c:if>
						 id="AcceptConditions" 
						 class="peer sr-only " />
				
				  <span class="absolute inset-0 rounded-full bg-gray-300 transition peer-checked:bg-green-500"></span>
				  <span class="absolute inset-y-0 start-0 m-1 h-6 w-6 rounded-full bg-white transition-all peer-checked:start-6"></span>
			</label>
	    </div>


	
	    <div class="flex items-center justify-between">
	      <!-- 계정이 없으면 회원가입 -->
	      <p class="text-sm text-gray-500">
	        No account? <a class="underline" href="../member/signup">Sign up</a>
	      </p>
	      
		  <!-- 로그인 버튼 -->
	      <button
			        type="submit"
			        id="btnSubmit"
			        class="inline-block rounded-lg bg-blue-500 px-5 py-3 text-sm font-medium text-white">
	        로그인
	      </button>
	    </div>
	</div>
</div>


<%@ include file="../layout/footer.jsp"%>




<script>
//http메시지 방식을 json으로 처리하기 위해 jquery(ajax) 사용


$("#btnSubmit").on("click",function(e){
	console.log("click");
	
	// json 형식으로 input(id속성, name속성 값)데이터 set
	const params = {
					member_id : $("#member_id").val(),
					password : $("#password").val(),
					save_id : $('input[name=save_id]').val()
					}
						
	// ajax 통신
	// e.preventDefault();
	// 데이터 담아서 서블릿으로 이동 > 성공 > success
	//						   실패 > error
	$.ajax({
			type: "post",
			url:"../member/signin-process",
			dataType: "json",
			data: params,
			
			success:function(data) {
				 console.log(data);
				 location.href="../index/index";
			},
			
			error : function(){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                    alert("아이디, 비밀번호를 다시 입력해주세요.")
               }
			});	
	//return false; 

})

</script>