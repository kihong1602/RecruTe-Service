<%--
  Created by IntelliJ IDEA.
  User: limsmac
  Date: 10/19/23
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
Heads up! 👋

This component comes with some `rtl` classes. Please remove them if they are not needed in your project.
-->
<section>
    <div class="mx-auto max-w-screen-xl px-4 py-8 sm:py-12 sm:px-6 lg:py-16 lg:px-8">

        <div>
            <h1 class="text-3xl font-bold sm:text-4xl">채용1</h1>
        </div>
        <div class="lg:fixed lg:top-48 flex flex-col justify-start">
            <div class="lg:py-2 flex justify-start items-center">
                <h3 class="w-24 text-xl font-bold sm:text-xl">채용 기간</h3>
                <p class="text-gray-600 font-bold text-base sm:text-lg">
                    2023-10-18 ~ 2023-10-25
                </p>
            </div>
            <div class="lg:py-2 flex justify-start items-center">
                <h3 class="w-24 text-xl font-bold sm:text-xl">급여</h3>
                <p class="text-gray-600 font-bold text-base sm:text-lg">
                    1000000
                </p>
            </div>
            <div class="lg:py-2 flex justify-start items-center">
                <h3 class="w-24 text-xl font-bold sm:text-xl">근무 형태</h3>
                <p class="text-gray-600 font-bold text-base sm:text-lg">
                    서울
                </p>
            </div>
            <div class="lg:py-2 flex justify-start items-center">
                <h3 class="w-24 text-xl font-bold sm:text-xl">직무</h3>
                <p class="text-gray-600 font-bold text-base sm:text-lg">
                    백엔드
                </p>
            </div>
            <div class="lg:py-2 flex justify-start items-center">
                <h3 class="w-24 text-xl font-bold sm:text-xl">요구 기술</h3>
                <p class="text-gray-600 font-bold text-base sm:text-lg">
                    Java
                </p>
            </div>
            <div class="lg:py-2 flex justify-start items-center">
                <h3 class="w-24 text-xl font-bold sm:text-xl">경력</h3>
                <p class="text-gray-600 font-bold text-base sm:text-lg">
                    2
                </p>
            </div>
            <div class="lg:py-2 flex justify-start items-center">
                <button id="apply-btn" type="button"
                   class="inline-block rounded bg-indigo-600 px-12 py-3 text-sm font-medium text-white transition hover:bg-indigo-700 focus:outline-none focus:ring focus:ring-yellow-400">
                    Get Started Today
                </button>
            </div>
        </div>


        <div class="lg:ml-80 lg:px-8 lg:py-4 grid grid-cols-1 gap-8 lg:grid-cols-2 lg:gap-16">
            <div class="lg:py-4">
                <h2 class="text-3xl font-bold sm:text-4xl">상세 내용</h2>

                <p class="mt-4 text-gray-600">
                    채용을 진행하겠습니다. 자기소개서를 작성해주세요.
                </p>
            </div>
        </div>

    </div>
</section>
<script src="../../../js/apply.js"></script>