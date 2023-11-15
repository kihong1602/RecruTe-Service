const authBtn = document.querySelector("#auth-btn")

const authMail = () => {
    const path = `/member/email`
    const msg = {
        method: 'POST'
    }
    fetch(path, msg)
        .then(res => res.json())
        .then(data => {
            console.log(data)
        });
}

authBtn.addEventListener("mousedown", authMailEvent = () => {
    console.log("클릭")
    authMail()
})