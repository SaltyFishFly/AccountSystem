async function executeSQL() {
    const sql = document.getElementById('sql_input').value;

    if (sql === "") {
        alert("请输入要执行的SQL语句");
        return;
    }

    let resp = await fetch('/api/sql/execute', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({sql})
    });
    let data = await resp.json();
    if (data.code === 200)
        alert("执行成功")
    else
        alert(`执行失败，错误信息： ${data.message}`);
}