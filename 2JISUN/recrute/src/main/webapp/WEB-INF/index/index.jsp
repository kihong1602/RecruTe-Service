<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 
		 
<%@ include file="../layout/header.jsp"%>


<section>
  <div class="max-w-screen-xl px-4 py-8 sm:px-6 sm:py-12 lg:px-8 lg:py-16">
    <div class="grid grid-cols-1 gap-y-8 lg:grid-cols-2 lg:items-center lg:gap-x-16">
      <div class="mx-auto max-w-lg text-center lg:mx-0 ltr:lg:text-left rtl:lg:text-right">
        
        <h2 class="text-3xl font-bold sm:text-4xl">RecruTe-Service</h2>
        <p class="mt-4 text-gray-600">
           ⭐${loggedName}⭐님 안녕하세요.
        </p>
        <p class="mt-4 text-gray-600">
          채용정보를 제공해드립니다.
        </p>
        <a href="../compRecruit/list"
           class="mt-8 inline-block rounded bg-indigo-600 px-12 py-3 text-sm font-medium text-white transition hover:bg-indigo-700 focus:outline-none focus:ring focus:ring-yellow-400">
          공고 보러가기
        </a>
      </div>
    </div>
  </div>
</section>

<%@ include file="../layout/footer.jsp"%>