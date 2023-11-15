<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../../layout/header.jsp" %>
<main>
    <section>
        <div class="mx-auto max-w-screen-2xl px-4 py-16 sm:px-6 lg:px-8">
            <div class="grid grid-cols-1 lg:h-screen lg:grid-cols-2">
                <div class="relative z-10 lg:py-16">
                    <div class="relative h-64 sm:h-80 lg:h-full">
                        <img
                                alt="House"
                                src="https://images.unsplash.com/photo-1583608205776-bfd35f0d9f83?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80"
                                class="absolute inset-0 h-full w-full object-cover"
                        />
                    </div>
                </div>

                <div class="relative flex items-center bg-gray-100">
        <span
                class="hidden lg:absolute lg:inset-y-0 lg:-start-16 lg:block lg:w-16 lg:bg-gray-100"
        ></span>

                    <div class="p-8 sm:p-16 lg:p-24">
                        <h2 class="text-2xl font-bold sm:text-3xl">
                            이메일 인증 페이지입니다.
                        </h2>

                        <p class="mt-4 text-gray-600">
                            이메일 인증을 하셔야 모든 서비스 이용이 가능합니다.
                        </p>

                        <a
                                href="javascript:emailConfirm('sid')"
                                class="mt-8 inline-block rounded border border-indigo-600 bg-indigo-600 px-12 py-3 text-sm font-medium text-white hover:bg-transparent hover:text-indigo-600 focus:outline-none focus:ring active:text-indigo-500"
                        >
                            이메일 인증
                        </a>
                        <a
                                href="<c:url value="/"/>"
                                class="mt-8 inline-block rounded border border-indigo-600 bg-indigo-600 px-12 py-3 text-sm font-medium text-white hover:bg-transparent hover:text-indigo-600 focus:outline-none focus:ring active:text-indigo-500"
                        >
                            메인화면으로
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<script src="../../../js/emailConfirm.js"></script>
<%@include file="../../layout/footer.jsp" %>