<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
  <div class="mx-auto max-w-lg">
    <form
            class="mb-0 mt-6 space-y-4 rounded-lg p-4 shadow-lg sm:p-6 lg:p-8"
    >
      <h1 class="text-center text-2xl font-bold text-indigo-600 sm:text-3xl">
        회원가입이 완료되었습니다!!
      </h1>
      <p class="mx-auto mt-4 max-w-md text-center text-gray-500">
        채용 공고에 지원하기 위해서는 이메일 인증이 필요합니다.<br/>
        지금 바로 진행하시겠습니까?
      </p>

      <div class="">
        <div class="relative w-full">
          <button id="auth-btn" type="button" class="block w-full rounded-lg bg-indigo-600 px-5 py-3 text-sm font-medium text-white">Email 인증
          </button>
        </div>
      </div>

      <p class="text-center text-sm text-gray-500">
        나중에 하시겠습니까?
        <a class="underline" href="/">메인 화면으로</a>
      </p>
    </form>
  </div>
</div>
<script src="/js/authMail.js"></script>