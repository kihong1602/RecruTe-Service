function apply(recruitId, companyId) {
    fetch('/recruitments/' + recruitId, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            recruitId: recruitId,
            companyId: companyId
        })
    })
        .then(response => response.text())
        .then(data => {
            if (JSON.parse(data).data === "available") {
                let msg = "성공적으로 지원되었습니다.";
                alert(msg);
                location.href = "/";
            } else {
                alert('지원에 실패하였습니다.');
            }
        }).catch(() => {
        alert('서버오류가 발생하였습니다.');
    })
}