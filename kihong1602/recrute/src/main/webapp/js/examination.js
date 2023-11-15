function submitExamination(answers) {
  const url = new URL(window.location.href);
  const uri = url.pathname.split("/");
  const aptId = url.searchParams.get('aptId');
  const examId = uri[uri.length - 1];

  let jsonData = {
    aptId: aptId,
    answers: answers
  }

  fetch(`exam/${examId}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(jsonData)
  })
  .then(response => response.text())
  .then(data => {
    let result = JSON.parse(data).data;
    switch (result) {
      case "available":
        alert('제출이 완료되었습니다.!');
        location.href = "/";
        break;
      case "unavailable":
        alert('제출에 실패하였습니다. 다시 시도해주세요.');
        break;
      default:
        alert('답을 모두 작성하지않았습니다. 모두 작성하고 제출해주세요.');
        break;
    }
  }).catch(() => {
    alert('서버오류입니다.');
  })
}

