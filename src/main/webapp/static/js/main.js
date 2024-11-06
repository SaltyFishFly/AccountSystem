async function register() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (username === "" || password === "") {
        alert("Please fill in both username and password.");
        return;
    }

    let resp = await fetch('/user/register', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password})
    });
    let data = await resp.json();
    if (data.code === 200) {
        alert("注册成功！")
        location.reload();
    }
    else alert(`注册失败，错误信息： ${data.message}`);
}

async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (username === "" || password === "") {
        alert("Please fill in both username and password.");
        return;
    }

    let resp = await fetch('/user/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password})
    });

    let data = await resp.json();
    if (data.code === 200) {
        alert("登录成功！")
        location.reload();
    }
    else alert(`登录失败，错误信息： ${data.message}`);
}