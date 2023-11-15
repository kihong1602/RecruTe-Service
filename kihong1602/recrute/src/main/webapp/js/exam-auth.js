function sendExaminationEmail() {
  let aptId = document.getElementById('apt-id').value;
  let examId = parsingURL();
  fetch(`/exam/auth/${examId}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      aptId: `${aptId}`
    }),
    timeout: 50000
  })
  .then(response => response.text())
  .then(data => {
    let result = JSON.parse(data).data;
    switch (result) {
      case "available":
        alert('인증되었습니다. 시험페이지로 이동합니다.');
        location.href = `/exam/${examId}`;
        break;
      case "unavailable":
        alert('수험번호가 다릅니다. 다시 입력해주세요.');
        aptId.value = "";
        break;
      case "fail":
        alert('인증정보가 없습니다. 시험응시를 해주세요.');
        history.back();
        break;
    }
  })
}

function parsingURL() {
  const url = new URL(window.location.href);
  const uri = url.pathname.split("/");
  return uri[uri.length - 1];
}
