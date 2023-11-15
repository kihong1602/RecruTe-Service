function emailConfirm(value) {
    //email-confirm에서는 value로 sid 입력하고, signup에서는 memberId 입력
    fetch('/email', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            key: value
        })
    })
        .then(response => response.text())
        .then(data => {
            if (JSON.parse(data).data === "available") {
                let msg = "인증링크가 성공적으로 발송되었습니다. 이메일을 확인해 주세요!";
                alert(msg);
                location.href = "/";
            } else {
                alert('이메일 발송이 실패했습니다.');
            }
        }).catch(() => {
        alert('서버오류가 발생하였습니다.');
    })
}

