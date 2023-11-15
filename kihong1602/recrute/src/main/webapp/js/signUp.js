let memberId = document.querySelector('input[name="member_id"]');
let password = document.querySelector('input[name="password"]');
let confirm = document.getElementById('password_confirm');
let name = document.querySelector('input[name="name"]');
let birth = document.querySelector('input[name="birth"]');
let gender = document.querySelector('input[name="gender"]');
let email = document.querySelector('input[name="email"]');
let tel = document.querySelector('input[name="phoneNumber"]');
let passwordConfirm = document.querySelector('.password-confirm');
let form = document.getElementById('signup-form');

let isProperId = false;
const regexMap = new Map();
regexMap.set('id', /^(?=.*[a-zA-Z])(?=.*[0-9]).{1,30}$/);
regexMap.set('password',
    /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,30}$/);
regexMap.set('name', /^(?=.*[a-zA-Zㄱ-ㅎ가-힣]).{1,30}$/);
regexMap.set('email', /^[a-z0-9]+@[a-z]+\.[a-z.]{2,}$/);
regexMap.set('tel', /^(?=.*[0-9]).{10,20}$/);

function invalid(e, memberId, password, name, birth, gender, email, tel) {
  e.stopPropagation();

  let isProper = false;

  if (check(memberId)) {
    alert("ID 입력은 필수입니다.");
    memberId.focus();
  } else if (!isProperId) {
    alert("중복된 아이디 입니다.");
    memberId.focus();
  } else if (!invalidId(memberId)) {
    alert("올바르지 않은 아이디 형식입니다.");
    memberId.focus();
  } else if (check(name)) {
    alert("이름을 입력해주세요.");
    name.focus();
  } else if (!invalidName(name)) {
    alert("올바르지않은 이름 형식입니다.");
    name.focus();
  } else if (check(email)) {
    alert("이메일을 입력해주세요.");
    email.focus();
  } else if (!invalidEmail(email)) {
    alert("올바르지 않은 이메일 형식입니다.")
    email.focus();
  } else if (check(password)) {
    alert("비밀번호 입력은 필수입니다.");
    password.focus();
  } else if (!invalidPw(password)) {
    alert("올바르지 않은 비밀번호 형식입니다.");
    password.focus();
  } else if (check(birth)) {
    alert("생년월일을 입력하세요.");
    birth.focus();
  } else if (check(gender)) {
    alert("성별을 골라주세요.");
  } else if (check(tel)) {
    alert("전화번호를 입력해주세요.");
    tel.focus();
  } else if (!invalidTel(tel)) {
    alert("올바르지 않은 전화번호 형식입니다.");
    tel.focus();
  } else {
    isProper = true;
  }

  return isProper;
}

function check(word) {
  return (word.value === "" || word.value === null || word.value === undefined);
}

function invalidId(memberId) {
  return regexMap.get('id').test(memberId.value);
}

function invalidPw(password) {
  return regexMap.get('password').test(password.value);
}

function invalidName(name) {
  return regexMap.get('name').test(name.value);
}

function invalidEmail(email) {
  return regexMap.get('email').test(email.value);
}

function invalidTel(tel) {
  return regexMap.get('tel').test(tel.value);
}

const signUpFormSubmitEvent = (memberId, password, name, birth, gender, email,
    tel) => {
  /*form.addEventListener('keydown', (e) => {
      if (e.code === "Enter") {
          invalid(e, memberId, password, name, birth, gender, email, tel)
      }
  }, true);*/

  form.addEventListener('submit', (e) => {
    e.preventDefault();
    let isProper = invalid(e, memberId, password, name, birth, gender, email,
        tel)

    if (isProper) {
      fetch('/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          memberId: memberId.value,
          name: name.value,
          email: email.value,
          password: password.value,
          birth: birth.value,
          gender: gender.value,
          phoneNumber: tel.value
        })
      })
      .then(response => response.text())
      .then(data => {
        const result = JSON.parse(data).data;
        switch (result) {
          case "available":
            alert("회원가입이 완료되었습니다.");
            location.href = "/complete"
            break;
          case "unavailable":
            alert("회원가입에 실패하였습니다.");
            break;
        }
      })
      .catch(error => {
        alert('서버오류 입니다.' + error);
      })
    }
  });
}

signUpFormSubmitEvent(memberId, password, name, birth, gender, email, tel);

document.getElementById('signup-id').addEventListener('click', function (e) {
  e.preventDefault();
  idDuplicate();
});

function idDuplicate() {

  fetch('/check-id', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({memberId: memberId.value})
  })
  .then(response => response.text())
  .then(data => {
    //response.text()를 받아온 것이므로 다시한번 Parsing 을 해주어야 한다.
    if (JSON.parse(data).data === "available") {
      alert('사용가능한 ID 입니다.');
      isProperId = true;
    } else if (JSON.parse(data).data === "unavailable") {
      alert('이미 사용중인 ID 입니다.');
    } else {
      alert('입력된 아이디가 없습니다. 아이디를 적어주세요.')
    }
  })
  .catch(() => {
    alert('서버오류가 발생했습니다.');
  })
}

confirm.addEventListener('keyup', () => {

  if (password.value !== confirm.value) {
    pwConDiv.textContent = "비밀번호가 다릅니다.";
    pwConDiv.style.display = "block";
  } else {
    pwConDiv.style.display = "none";
  }
})

//memberId,password,name,email,tel
let idParent = document.querySelector('.id-parent');
let pwParent = document.querySelector('.password-parent');
let pwConfirmParent = document.querySelector('.pw-confirm-parent');
let nameParent = document.querySelector('.name-parent');
let emailParent = document.querySelector('.email-parent');
let telParent = document.querySelector('.tel-parent');
const idDiv = createDiv(idParent);
const pwDiv = createDiv(pwParent);
const pwConDiv = createDiv(pwConfirmParent);
const nameDiv = createDiv(nameParent);
const emailDiv = createDiv(emailParent);
const telDiv = createDiv(telParent);

function createDiv(parent) {
  const div = document.createElement('div');
  div.classList.add('invalid');
  parent.appendChild(div);
  div.style.display = "none";
  return div;
}

memberId.addEventListener('input', () => {

  const compare = memberId.value;
  memberId.value = memberId.value.replace(/[^a-z0-9]/g, "");

  if (compare !== memberId.value) {
    idDiv.textContent = "올바르지 않은 아이디 형식입니다.";
    idDiv.style.display = "block";
    //자식으로 생성하기
  } else {
    idDiv.style.display = "none";
    //hidden 처리하기
  }

})

password.addEventListener('input', () => {
  const compare = password.value;
  password.value = password.value.replace(/[^a-zA-Z!@#$%^&*-=+\d]/g, "");

  if (compare !== password.value) {
    pwDiv.textContent = "올바르지 않은 비밀번호 형식입니다.";
    pwDiv.style.display = "block";

  } else {
    pwDiv.style.display = "none";
  }
})

name.addEventListener('input', () => {
  const compare = name.value;
  name.value = name.value.replace(/[^a-zA-Zㄱ-ㅎ가-힣]/g, "");

  if (compare !== name.value) {
    nameDiv.textContent = "올바르지 않은 이름 형식입니다.";
    nameDiv.style.display = "block";

  } else {
    nameDiv.style.display = "none";
  }
})

email.addEventListener('input', () => {
  const compare = email.value;
  email.value = email.value.replace(/[^a-zA-Z\d@.]/g, "");

  if (compare !== email.value) {
    emailDiv.textContent = "올바르지 않은 이메일 형식입니다.";
    emailDiv.style.display = "block";

  } else {
    emailDiv.style.display = "none";
  }
})

tel.addEventListener('input', () => {
  const compare = tel.value;
  tel.value = tel.value.replace(/[^0-9]/g, "");

  if (compare !== tel.value) {
    telDiv.textContent = "올바르지 않은 전화번호 형식입니다.";
    telDiv.style.display = "block";

  } else {
    telDiv.style.display = "none";
  }
})