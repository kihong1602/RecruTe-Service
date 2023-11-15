<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-20
  Time: 오후 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../layout/header.jsp" %>
<c:choose>
    <c:when test="${requestScope.result eq 'success'}">
        <section>
            <div
                    class="mx-auto max-w-screen-xl px-4 py-8 sm:py-12 sm:px-6 lg:py-16 lg:px-8"
            >
                <div class="grid grid-cols-1 gap-8 lg:grid-cols-2 lg:gap-16">
                    <div
                            class="relative h-64 overflow-hidden rounded-lg sm:h-80 lg:order-last lg:h-full"
                    >
                        <img
                                alt="Party"
                                src="https://images.unsplash.com/photo-1527529482837-4698179dc6ce?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80"
                                class="absolute inset-0 h-full w-full object-cover"
                        />
                    </div>

                    <div class="lg:py-24">
                        <h2 class="text-3xl font-bold sm:text-4xl">이메일 인증이 완료되었어요!</h2>

                        <p class="mt-4 text-gray-600">
                            이제 모든 서비스를 이용할 수 있습니다! 즐거운 이용되세요!
                        </p>

                        <a
                                href="/"
                                class="mt-8 inline-block rounded bg-indigo-600 px-12 py-3 text-sm font-medium text-white transition hover:bg-indigo-700 focus:outline-none focus:ring focus:ring-yellow-400"
                        >
                            메인 페이지로
                        </a>
                    </div>
                </div>
            </div>
        </section>
    </c:when>
    <c:otherwise>
        <div class="flex flex-col h-screen bg-white">
            <img
                    src="https://images.unsplash.com/photo-1558769132-cb1aea458c5e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1548&q=80"
                    alt=""
                    class="object-cover w-full h-64"
            />

            <div class="flex items-center justify-center flex-1">
                <div class="max-w-xl px-4 py-8 mx-auto text-center">
                    <h1 class="text-2xl font-bold tracking-tight text-gray-900 sm:text-4xl">
                        이메일 인증에 실패했어요...
                    </h1>

                    <p class="mt-4 text-gray-500">
                        다시 시도해보세요..
                    </p>

                    <a
                            href="/"
                            class="inline-block px-5 py-3 mt-6 text-sm font-medium text-white bg-indigo-600 rounded hover:bg-indigo-700 focus:outline-none focus:ring"
                    >
                        메인 페이지로
                    </a>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<%@include file="../../layout/footer.jsp" %>
