const id = document.querySelector('input[name="id"]')
const email = document.querySelector('input[name="email"]')
const name = document.querySelector('input[name="name"]')
const gender = document.querySelector('input[name="gender"]')
const password = document.querySelector('input[name="password"]')
const passwordConfirm = document.querySelector('input[name="passwordConfirm"]')
const phoneNumber = document.querySelector('input[name="phoneNumber"]')
const birth = document.querySelector('input[name="birth"]')
const form = document.querySelector("#form")
const checkBtn = document.querySelector("#check-btn")

const validateInputValue = (el, regex) => {
    const elRegex = new RegExp(regex);
    return elRegex.test(el.value);
}

id.addEventListener('input', e => {
    id.value = id.value.replace(/[^a-zA-Z0-9]/g, '')
})
password.addEventListener('input', e => {
    password.value = password.value.replace(/[^a-zA-Z0-9!@#$%^*+=-]g/, '')
})
passwordConfirm.addEventListener('input', e => {
    passwordConfirm.value = passwordConfirm.value.replace(/[^a-zA-Z0-9!@#$%^*+=-]/g, '')
})
email.addEventListener('input', e => {
    email.value = email.value.replace(/[^a-z0-9@.]/g, '')
})
name.addEventListener('input', e => {
    name.value = name.value.replace(/[^a-zA-Zㄱ-ㅎ가-힣]/g, '')
})
phoneNumber.addEventListener('input', e => {
    phoneNumber.value = phoneNumber.value.replace(/[^0-9]/g, '')
})


const checkInputEmpty = (el) => {
    return (el.value === "" || el.value === null || el.value === undefined)
}

const registerEvent = (e, id, email, name, gender, password, passwordConfirm, phoneNumber, birth, checked) => {
    e.stopPropagation();


    let isProper = false;
    if (checkInputEmpty(id)) {
        alert("아이디를 입력하세요.")
        id.focus()
    } else if (!validateInputValue(id, /^(?=.*[a-zA-Z])(?=.*[0-9]).{1,30}$/)) {
        alert("아이디 형식이 올바르지 않습니다.")
        id.focus()
    } else if (checked.isDup) {
        alert("중복 체크를 진행하세요.")
        checkBtn.focus()
    } else if (checkInputEmpty(email)) {
        alert("이메일을 입력하세요.")
        email.focus()
    } else if (!validateInputValue(email, /^[a-z0-9]+@[a-z]+\.[a-z.]{2,}$/)) {
        alert("이메일 형식이 올바르지 않습니다.")
        email.focus()
    } else if (checkInputEmpty(name)) {
        alert("이름을 입력하세요.")
        name.focus()
    } else if (!validateInputValue(name, /^[a-zA-Zㄱ-ㅎ가-힣]{1,30}$/)) {
        alert("이름 형식이 올바르지 않습니다.")
        name.focus()
    } else if (checkInputEmpty(gender)) {
        alert("성별을 선택하세요.")
        gender.focus()
    } else if (checkInputEmpty(password)) {
        alert("비밀번호를 입력하세요.")
        password.focus()
    } else if (!validateInputValue(password, /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,30}$/)) {
        alert("비밀번호 형식이 올바르지 않습니다.")
        password.focus()
    } else if (checkInputEmpty(passwordConfirm)) {
        alert("비밀번호 확인을 입력하세요.")
        passwordConfirm.focus()
    } else if (password.value != passwordConfirm.value) {
        alert("비밀번호와 비밀번호 확인 값이 다릅니다.")
        passwordConfirm.focus()
    } else if (checkInputEmpty(phoneNumber)) {
        alert("전화번호를 입력하세요.")
        phoneNumber.focus()
    } else if (!validateInputValue(phoneNumber, /^[0-9]{10,20}$/)) {
        alert("전화번호 형식이 올바르지 않습니다.")
        phoneNumber.focus()
    } else if (checkInputEmpty(birth)) {
        alert("생년월일을 선택하세요.")
        birth.focus()
    } else {
        isProper = true;
    }
    if (!isProper) {
        e.preventDefault();
    }
}

const checkDuplicate = (id, checked) => {
    if (checkInputEmpty(id)) {
        alert("아이디를 입력하세요.")
        id.focus()
    } else if (!validateInputValue(id, /^(?=.*[a-zA-Z])(?=.*[0-9]).{1,30}$/)) {
        alert("아이디 형식이 올바르지 않습니다.")
        id.focus()
    } else {
        const path = `/signup/check-duplicate?username=${id.value}`
        fetch(path)
            .then(res => res.json())
            .then(json => {
                if (json.data.isDup) {
                    alert("중복된 아이디입니다.")
                    id.focus();
                } else {
                    if (!confirm("사용가능한 아이디입니다. 사용하시겠습니까?")) {
                        alert("취소 되었습니다.");
                    } else {
                        checked.isDup = false
                        id.readOnly = true;
                        checkBtn.setAttribute("style", "cursor: default;")
                        checkBtn.removeEventListener("mousedown", checkDupIdEvent)
                        checkBtn.removeEventListener("click", checkDupIdEvent)
                        alert("확인 되었습니다.");
                    }
                }
            });
    }
}

const registerFormSubmitEvent = (id, email, name, gender, password, passwordConfirm, phoneNumber, birth) => {
    const checked = {
        isDup: true
    }

    checkBtn.addEventListener("mousedown", checkDupIdEvent = () => {
        checkDuplicate(id, checked)
    })

    form.addEventListener('keydown', (e) => {
        console.log("e")
        if (e.code === "Enter") {
            if(document.activeElement === checkBtn && checked.isDup) {
                checkDuplicate(id, checked)
            } else {
                registerEvent(e, id, email, name, gender, password, passwordConfirm, phoneNumber, birth, checked)
            }
        }
    }, true);

    form.addEventListener("submit", (e) => {
        registerEvent(e, id, email, name, gender, password, passwordConfirm, phoneNumber, birth, checked)
    });
}

registerFormSubmitEvent(id, email, name, gender, password, passwordConfirm, phoneNumber, birth)

