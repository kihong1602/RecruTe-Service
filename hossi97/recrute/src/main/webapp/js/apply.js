const applyBtn = document.querySelector("button#apply-btn")
applyBtn.addEventListener('click', e => {
    const path = 'http://' + window.location.host + '/auth'
    fetch(path)
        .then(res => res.status)
        .then(status => {
            if(status === 401) {
                if(confirm("로그인이 필요한 요청입니다. 로그인하시겠습니까?")) {
                    window.location.pathname = "signin"
                }
            } else {
                const msg = {
                    method: 'POST'
                }
                fetch(window.location.href, msg)
                    .then(res => res.json())
                    .then(data => {
                        console.log(data)
                        alert("지원이 완료되었습니다.")
                        window.localStorage.setItem(data.key, data.value)
                    })
                // res 를 바로 parse()하려고 하면 Promise 객체라서 안된다.
                // 200 일때만 하도록 처리
            }
        })
})