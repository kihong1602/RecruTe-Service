let memberId = document.querySelector('input[name="member_id"]');
let password = document.querySelector('input[name="password"]');
let form = document.getElementById('signin-form');
let asyncBtn = document.getElementById('asyncBtn');

function check(word) {
  return (word.value === "" || word.value === null || word.value === undefined);
}

function invalid(e, memberId, password) {
  e.stopPropagation();
  let isProper = true;

  if (check(memberId)) {
    alert("ID 입력은 필수입니다.");
    memberId.focus();
    isProper = false;
  } else if (check(password)) {
    alert("비밀번호 입력은 필수입니다.");
    password.focus();
    isProper = false;
  }

  return isProper;
}

const signInFormSubmitEvent = (memberId, password) => {
  asyncBtn.addEventListener('click', (e) => {
    e.preventDefault();
    if (invalid(e, memberId, password)) {
      loginCheck();
    }
  });
}

signInFormSubmitEvent(memberId, password);

function loginCheck() {
  const data = {
    memberId: memberId.value,
    password: password.value
  };

  fetch('/signin', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(response => response.text())
  .then(data => {
    if (JSON.parse(data).data === "available") {
      let msg = '반갑습니다.' + memberId.value + '님!';
      alert(msg);
      location.href = "/";
    } else {
      alert('잘못 입력하셨거나 없는 회원입니다.');
    }
  })
  .catch(error => {
    alert('서버 오류가 발생하였습니다.');
  });
}
