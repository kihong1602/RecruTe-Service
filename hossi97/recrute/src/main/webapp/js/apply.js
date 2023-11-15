const applyBtn = document.querySelector("button#apply-btn")
applyBtn.addEventListener('click', e => {
    const urlElements = window.location.href.split("/")
    const rctId = urlElements[urlElements.length - 1]
    const url = "http://" + window.location.host + "/recruitments/apply"
    const info = {
        rctId: rctId
    }

    const msg = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(info)
    }

    fetch(url, msg)
        .then(res => {
            if(res.ok) {
                alert("지원이 완료되었습니다.")
            } else if(res.status === 400) {
                alert("잘못된 요청입니다.")
            } else if(res.status === 401) {
                alert("로그인 및 이메일 인증이 필요한 기능입니다.")
            }
            return res.json()
        }).then((json) => {
            console.log(json)
        })
})