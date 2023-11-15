<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

		 
		 
<%@ include file="../layout/header.jsp"%>


<!-- 로그인 여부 -->
<c:choose>

<%-- 로그인 전 : 세션값이 없을 때 or 만료된 이후 --%>
<c:when test="${empty loggedId}"> 
<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
  <div class="mx-auto max-w-lg text-center">
    <h1 class="text-2xl font-bold sm:text-3xl">
     로그아웃 상태입니다. 다시 로그인해주세요~^0^
    </h1>
  </div>
</div>
</c:when>




<%-- 로그인 후 :  ../exam/exam?examTbl_id=${ }--%>
<c:otherwise>

<form action="../exam/idAuth-process"
	  method="post">

<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
	
  <div class="mx-auto max-w-lg text-center">
    <h1 class="text-2xl font-bold sm:text-3xl">지원하신 회사의 채용시험</h1>
    <p class="mt-4 text-gray-500">
      수험번호를 입력해주세요✏️
    </p>
  </div>
  
  
  <%-- <a href="../board/view?no=${board.no}">${board.title }</a> --%>

	<div class="mx-auto mb-0 mt-8 max-w-md space-y-4" 
 	 	 id="join"> 
 	  	<%-- 수험번호  --%>
		<div>
	      <div class="relative">
	        <input    type="text"
			          id="apt_id" 
			          name="apt_id"
			          class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
			          placeholder="수험번호"/>
	      </div>
	    </div>

		<%-- 수험번호 인증버튼  --%>
		<button type="submit"
			    id="btnSubmit"
			    class="inline-block rounded-lg bg-blue-500 px-5 py-3 text-sm font-medium text-white">
		  시험보러 가기
		</button>
		
    </div>
</div>

</form>

</c:otherwise>
</c:choose>








<%@ include file="../layout/footer.jsp"%>