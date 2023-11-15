<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
	<!--
  Heads up! 👋

  Plugins:
    - @tailwindcss/forms
-->

<header class="bg-gray-50">
  <div class="mx-auto max-w-screen-xl px-4 py-8 sm:px-6 lg:px-8">

    <div class="mt-8">
      <h1 class="text-2xl font-bold text-gray-900 sm:text-3xl">
        Welcome Back ${loggedName }!
      </h1>

      <p class="mt-1.5 text-sm text-gray-500">
        Your website has seen a 52% increase in traffic in the last month. Keep
        it up! 🚀
      </p>
    </div>
  </div>
</header>
<%@ include file="/WEB-INF/include/footer.jsp"%>