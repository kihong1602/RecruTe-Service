<%--
  Created by IntelliJ IDEA.
  User: BlanC
  Date: 2023-11-01
  Time: PM 6:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../layout/header.jsp" %>
<div class="grid p-6 bg-gray-100 rounded place-content-center sm:p-8">
    <div class="max-w-md mx-auto text-center lg:text-left">
        <header>
            <h2 class="text-xl font-bold text-gray-900 sm:text-3xl">수험자 이메일 전송 페이지</h2>

            <p class="mt-4 text-gray-500">
                아래 버튼을 눌러 수험자들에게 이메일을 전송하세요.
            </p>
        </header>

        <a href="javascript:sendEmailToApplicant()"
           class="inline-block px-12 py-3 mt-8 text-sm font-medium text-white transition bg-gray-900 border border-gray-900 rounded hover:shadow focus:outline-none focus:ring">
            이메일 전송
        </a>
    </div>
</div>
<script src="../../js/exam-email.js"></script>
<%@include file="../layout/footer.jsp" %>
