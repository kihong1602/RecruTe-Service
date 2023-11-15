<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 
<%@ include file="../layout/header.jsp"%>


<section class="bg-gray-100">
  <div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
    <div class="grid grid-cols-1 gap-x-16 gap-y-8 lg:grid-cols-1">
      <div class="rounded-lg bg-white p-8 shadow-lg lg:col-span-3 lg:p-12">
      
      <h3>🍀회원가입🍀</h3>
        <form class="space-y-4"
        	  action="../member/signup-process" 
        	  method="post" >

        
          <!-- 아이디 -->
          <div>
            <input
	              class="w-full rounded-lg border-gray-200 p-3 text-sm"
	              placeholder="아이디"
	              type="text"
	              name="member_id"
	              id="member_id"/>
          </div>
          
          <!-- 비밀번호 -->
          <div>
            <input
	              class="w-full rounded-lg border-gray-200 p-3 text-sm"
	              placeholder="비밀번호"
	              type="password"
	              name="password"
	              id="password"/>
          </div>
          
          <!-- 비밀번호 확인 -->
          <div>
            <input
	              class="w-full rounded-lg border-gray-200 p-3 text-sm"
	              placeholder="비밀번호 확인"
	              type="password"
	              name="pwConfirm"
	              id="pwConfirm"/>
	         <div class="pwConfirmTxt"></div>
          </div>
          
          <!-- 이름 -->
          <div>
            <input
              class="w-full rounded-lg border-gray-200 p-3 text-sm"
              placeholder="이름"
              type="text"
              name="name"
              id="name"/>
          </div>
          
          <!-- 생년월일 -->
          <div>
            <input
              class="w-full rounded-lg border-gray-200 p-3 text-sm"
              type="date"
              name="birth"
              id="birth"/>
          </div>




		  <!-- 성별 -->
		
		 <div >
            <div>
               <input type="radio" 
		               id="gender" 
		               name="gender" 
		               value="0" 
		               checked="checked" />
               <label name="gender" for="ag1">남자</label>
               
               <input type="radio" 
		               id="gender" 
		               name="gender" 
		               value="1" />
               <label name="gender" for="ag2">여자</label>
            </div>
          </div>
		
		          
          
          
          <!-- 전화번호 -->
          <div>
              <input
                class="w-full rounded-lg border-gray-200 p-3 text-sm"
                placeholder="전화번호"
                type="tel"
                name="phone_number"
                id="phone_number"
              />
            </div>
            
            
            <!-- 이메일 -->
            <div class="relative">
			  <input
			  	class="w-full rounded-lg border-gray-200 p-3 text-sm"
			    placeholder="flea@rhcp.com"
			    type="email"
			    name="email"
			    id="email"
			  />
			</div>
			
			

		  <!-- 버튼 -->
          <div class="mt-4">
          	<button
              type="submit"
              id="btnIdCheck"
              class="inline-block w-full rounded-lg bg-black px-5 py-3 font-medium text-white sm:w-auto">
              아이디 중복 확인
            </button>
            <button
              type="submit"
              id="btnSignupCheck"
              class="inline-block w-full rounded-lg bg-black px-5 py-3 font-medium text-white sm:w-auto">
              회원가입
            </button>
            <button
              type="reset"
              class="inline-block w-full rounded-lg bg-black px-5 py-3 font-medium text-white sm:w-auto">
              취소
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>




<script>

//아이디 중복을 확인합니다.
let isIDCheck = false; 
$("#btnIdCheck").on("click",function(e){
	console.log("click");
	
	$.ajax({
		type: "get",
		url:"../member/idCheck",
		dataType: "json",
		data: {
			member_id : $("#member_id").val(),
		},
		
		success:function(data){
			console.log(data)
			if(data.count>0) {
				alert("사용할 수 없는 아이디 입니다.")
			} else if($("#member_id").val().trim() === ""){
				alert("아이디를 입력해주세요.")
			} else {
				//Yes, No 확인 창
				const userIdPossible = confirm("쓸 수 있는 아이디 입니다. 사용하시겠어요?"); 
				// 사용자가 아이디를 사용하겠다고 확인한 경우
				if(userIdPossible) { 
					$("#member_id").attr("readonly",true); // 아이디 입력란을 읽기 전용으로 설정합니다.
					isIDCheck=true; // 아이디 중복 확인이 완료되었음을 나타내는 변수를 설정합니다.
				} 
			}
		},
		error:function(){
			alert("통신 오류입니다.")
		}
	});
	return false;
})



//비밀번호 일치를 확인합니다.
$("#pwConfirm").on("keyup",function(){
	if( $("#password").val() !== $("#pwConfirm").val() ) {
		$(".pwConfirmTxt").show();
		$(".pwConfirmTxt").text("비밀번호가 일치하지 않습니다.");
	} else {
		$(".pwConfirmTxt").hide();
		$(".pwConfirmTxt").text("");
	}
});




//필수입력사항을 확인합니다. (전부)
$('#btnSignupCheck').on("click", function(){
	if($("#member_id").val().trim() === ""){
		alert("아이디는 필수입력 사항입니다.");
		$("#member_id").focus();
		return false;
	} else if($("#password").val().trim() === ""){
		alert("비밀번호는 필수입력 사항입니다.");
		$("#password").focus();
		return false;
	} else if($("#pwConfirm").val().trim() === ""){
		alert("비밀번호는 필수입력 사항입니다.");
		$("#pwConfirm").focus();
		return false;
	} else if($("#name").val().trim() === ""){
		alert("이름은 필수입력 사항입니다.");
		$("#name").focus();
		return false;
	} else if($("#birth").val().trim() === ""){
		alert("생년월일은 필수입력 사항입니다.");
		$("#birth").focus();
		return false;
	} else if($("#phone_number").val().trim() === ""){
		alert("전화번호는 필수입력 사항입니다.");
		$("#phone_number").focus();
		return false;
	} else if($("#email").val().trim() === ""){
		alert("이메일은 필수입력 사항입니다.");
		$("#email").focus();
		return false;
	} else if(!isIDCheck){
		alert("아이디 중복 확인을 해주세요");
		return false;
	}
});



</script>



<%@ include file="../layout/footer.jsp"%>
