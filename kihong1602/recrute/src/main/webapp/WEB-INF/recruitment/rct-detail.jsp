<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../layout/header.jsp" %>
<div class="max-w-xl mx-auto bg-white p-6 rounded-lg shadow-lg">
    <h1 class="text-2xl font-bold">${requestScope.detailDTO.title}</h1>
    <p class="text-gray-600 mt-2">${requestScope.detailDTO.content}</p>
    <div class="bg-gray-100 p-4 mt-4 rounded">
        <h2 class="text-lg font-semibold">회사 정보</h2>
        <ul class="mt-2">
            <li>직무: ${requestScope.detailDTO.job}</li>
            <li>연봉: ${requestScope.detailDTO.salary}</li>
            <li>기술 스택: ${requestScope.detailDTO.skills}</li>
            <li>근무형태: ${requestScope.detailDTO.workForm}</li>
            <li>경력: ${requestScope.detailDTO.career}</li>
            <li>회사명: ${requestScope.detailDTO.companyName}</li>
            <li>회사주소: ${requestScope.detailDTO.location}</li>
            <li>공고 시작일: ${requestScope.detailDTO.startDate}</li>
            <li>마감일: ${requestScope.detailDTO.endDate}</li>
        </ul>
    </div>
    <a
            class="group flex items-center justify-between gap-4 rounded-lg border border-teal-600 bg-teal-600 px-5 py-3 transition-colors hover:bg-transparent focus:outline-none focus:ring"
            href="javascript:apply('${requestScope.detailDTO.recruitId}','${requestScope.detailDTO.companyId}')"
    >
  <span
          class="font-medium text-white transition-colors group-hover:text-teal-600 group-active:text-teal-500"
  >
    지원하기
  </span>

        <span
                class="shrink-0 rounded-full border border-current bg-white p-2 text-teal-600 group-active:text-teal-500"
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
<script src="../../js/apply.js"></script>
<%@include file="../layout/footer.jsp" %>
