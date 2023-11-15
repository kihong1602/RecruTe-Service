const id = document.querySelector('input[name="id"]')
const password = document.querySelector('input[name="password"]')
const submitBtn = document.querySelector('#submit-btn')

const checkInputEmpty = (el) => {
    return (el.value === "" || el.value === null || el.value === undefined)
}

const validateInputValue = (el, regex) => {
    const elRegex = new RegExp(regex);
    return elRegex.test(el.value);
}

id.addEventListener('input', e => {
    id.value = id.value.replace(/[^a-zA-Z0-9]/g,'')
})
password.addEventListener('input', e => {
    password.value = password.value.replace(/[^a-zA-Z0-9!@#$%^*+=-]g/,'')
})

const isNotEmpty = (id, password) => {
    if (checkInputEmpty(id)) {
        alert("아이디를 입력해주세요.")
        id.focus()
        return false
    } else if (!validateInputValue(id, /^(?=.*[a-zA-Z])(?=.*[0-9]).{1,30}$/)) {
        alert("아이디 형식이 올바르지 않습니다.")
        id.focus()
        return false
    } else if (checkInputEmpty(password)) {
        alert("비밀번호를 입력해주세요.")
        password.focus()
        return false
    } else if (!validateInputValue(password, /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,30}$/)) {
        alert("비밀번호 형식이 올바르지 않습니다.")
        password.focus()
        return false
    }

    return true;
}

const sendData = (idVal, passwordVal) => {
    const info = {
        username: idVal,
        password: passwordVal
    }

    const msg = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        redirect: 'follow',
        body: JSON.stringify(info)
    }

    fetch(window.location.href, msg)
        .then((res) => {
            if (res.ok) document.location.href="/"
            else alert("아이디와 비밀번호를 다시 확인해주세요.")
        }
    )
}

const checkAndSend = (e, id, password) => {
    e.stopPropagation();

    if (isNotEmpty(id, password)) {
        sendData(id.value, password.value)
    }
}

const addFormEvent = (id, password) => {
    form.addEventListener('keydown', (e) => {
        if (e.code === "Enter") {
            checkAndSend(e, id, password)
        }
    }, true);
}

const addBtnEvent = (id, password) => {
    submitBtn.addEventListener("click", (e) => {
        checkAndSend(e, id, password)
    });
}

const addSubmitEvent = (id, password) => {
    addFormEvent(id, password)
    addBtnEvent(id, password)
}

addSubmitEvent(id, password)
