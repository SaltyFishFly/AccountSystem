async function register() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (username === "" || password === "") {
        alert("请输入账号和密码");
        return;
    }

    let resp = await fetch('/api/user/register', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password})
    });
    let data = await resp.json();
    if (data.code === 200) {
        alert("注册成功")
        location.replace("index");
    }
    else alert(`注册失败，错误信息： ${data.message}`);
}

async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (username === "" || password === "") {
        alert("请输入账号和密码");
        return;
    }

    let resp = await fetch('/api/user/login', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({username, password})
    });

    let data = await resp.json();
    if (data.code === 200) {
        alert("登录成功")
        location.replace("/index")
    }
    else alert(`登录失败，错误信息： ${data.message}`);
}