function loadUsers(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementById("myUser");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<tr id="${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].email}</td>
                    <td>${data[i].role}</td>
                    <td><button class="btn btn-danger" onclick=""><a href="http://localhost:8080/tpizza/admin/update-user?user=${data[i].email}">Thông tin chi tiết</a></button></td>
                </tr>`
        
        d.innerHTML = msg;
    });
}

function addUser(endpoint, role, redirect){

    fetch(endpoint, {
        method:"post",
        body: JSON.stringify({
            "email" : document.getElementById('email').value,
            "username" : document.getElementById('username').value,
            "password" : document.getElementById('password').value,
            "passwordConfirm" : document.getElementById('confirmPassword').value,
            "role" : role
        }),
        headers: {
            "Content-Type": "application/json"
        }
    
    }).then(function (res){
        console.info(res);
        return res.json();
    }).then(function (data){
        console.info(data);
        window.location.href = redirect;
    });
}

function updateUser(endpoint){
    fetch(endpoint, {
        method:"put",
        body: JSON.stringify({
            "email" : document.getElementById('email').value,
            "username" : document.getElementById('username').value,
            "password" : document.getElementById('password').value,
            "phone" : document.getElementById('phone').value,
            "address" : document.getElementById('address').value,
            "role" : document.getElementById("role").options[document.getElementById("role").selectedIndex].value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    
    }).then(function (res){
        console.info(res);
        return res.json();
    }).then(function (data){
        console.info(data);
        window.location.href = "http://localhost:8080/tpizza/admin/user-manager";
    });
}
