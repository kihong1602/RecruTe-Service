function sendEmailToApplicant() {
  let recruitId = parsingURL();
  const JSONBody = {recruitId: recruitId}
  fetch(`/exam/email/${recruitId}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(JSONBody)
  })
  .then(response => response.text())
  .then(data => {
    const result = JSON.parse(data).data;
    if (result === 'available') {
      alert('모든 지원자에게 이메일 전송을 완료하였습니다.');
    } else {
      alert('이메일 전송에 실패하였습니다.');
    }
  }).catch(error => {
    alert(error.message);
  })
}

function parsingURL() {
  const url = new URL(window.location.href);
  const uri = url.pathname.split("/");
  return uri[uri.length - 1];
}