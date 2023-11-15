<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
    <div class="mx-auto max-w-lg">
        <h1 class="text-center text-2xl font-bold text-indigo-600 sm:text-3xl">
            Get started today
        </h1>

        <p class="mx-auto mt-4 max-w-md text-center text-gray-500">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Obcaecati sunt
            dolores deleniti inventore quaerat mollitia?
        </p>

        <form
                id="form"
                action="/signup"
                method="post"
                class="mb-0 mt-6 space-y-4 rounded-lg p-4 shadow-lg sm:p-6 lg:p-8"
        >
            <p class="text-center text-lg font-medium">Sign in to your account</p>

            <div class=""><label for="id">ID</label>
                <div class="relative w-full flex justify-stretch gap-4"><input id="id" name="id" type="text"
                                                                               class="grow rounded-lg border-gray-200 p-4 pe-4 text-sm shadow-sm"
                                                                               placeholder="Enter ID">
                    <button id="check-btn" type="button" class="rounded-lg border-gray-100 border-2 p-4">ID 중복 확인
                    </button>
                </div>
            </div>
            <div class="">
                <label for="email">Email</label>
                <div class="relative w-full">
                    <input id="email" name="email" type="email"
                           class="w-full rounded-lg border-gray-200 p-4 pe-4 text-sm shadow-sm"
                           placeholder="Enter email" maxlength="50">
                </div>
            </div>
            <div class="">
                <label for="name">Name</label>
                <div class="relative w-full">
                    <input id="name" type="text" name="name"
                           class="w-full rounded-lg border-gray-200 p-4 pe-4 text-sm shadow-sm"
                           placeholder="Enter name">
                </div>
            </div>
            <div class="">
                <fieldset id="gender">
                    <label for="gender">Gender</label>
                    <div class="relative w-full rounded-lg border-gray-200 p-4 pe-1 text-sm shadow-sm flex justify-evenly">
                        <div>
                            <label for="male">Male</label>
                            <input id="male" type="radio" name="gender" value="male">
                        </div>
                        <div>
                            <label for="female">Femail</label>
                            <input id="female" type="radio" name="gender" value="female">
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="">
                <label for="password">Password</label>
                <div class="relative w-full">
                    <input id="password" name="password" type="password"
                           class="w-full rounded-lg border-gray-200 p-4 pe-4 text-sm shadow-sm"
                           placeholder="Enter password">
                    <span class="absolute inset-y-0 end-0 grid place-content-center px-4">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-gray-400" fill="none" viewBox="0 0 24 24"
                 stroke="currentColor">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path>
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"></path>
            </svg>
          </span>
                </div>
            </div>
            <div class="">
                <label for="password-confirm">Password Confirm</label>
                <div class="relative w-full">
                    <input id="password-confirm" name="passwordConfirm" type="password"
                           class="w-full rounded-lg border-gray-200 p-4 pe-4 text-sm shadow-sm"
                           placeholder="Enter password confirm">
                    <span class="absolute inset-y-0 end-0 grid place-content-center px-4">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4 text-gray-400" fill="none" viewBox="0 0 24 24"
                 stroke="currentColor">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path>
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"></path>
            </svg>
          </span>
                </div>
            </div>
            <div class="">
                <label for="phone-number">Phone Number</label>
                <div class="relative w-full">
                    <input id="phone-number" name="phoneNumber" type="tel"
                           class="w-full rounded-lg border-gray-200 p-4 pe-4 text-sm shadow-sm"
                           placeholder="Enter phone number">
                </div>
            </div>
            <div class="">
                <label for="birth">Birth</label>
                <div class="relative w-full">
                    <input id="birth" name="birth" type="date"
                           class="w-full rounded-lg border-gray-200 p-4 pe-4 text-sm shadow-sm">
                </div>
            </div>

            <button
                    id="submit-btn"
                    type="submit"
                    class="block w-full rounded-lg bg-indigo-600 px-5 py-3 text-sm font-medium text-white"
            >
                Sign in
            </button>

            <p class="text-center text-sm text-gray-500">
                No account?
                <a class="underline" href="">Sign up</a>
            </p>
        </form>
    </div>
</div>

<%--<script src="${requestScope.getContextPath}"></script>--%>
<%--<script src="${pageContext.request.contextPath}"></script>--%>

<script src="/js/signup.js"></script>