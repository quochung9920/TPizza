function addDiscount(endpoint){
    fetch(endpoint, {
        method:"post",
        body: JSON.stringify({
            "nameDiscount" : document.getElementById("nameDiscount").value,
            "percentageReduction" : document.getElementById("percentageReduction").value,
            "startDate" : document.getElementById("startDate").value,
            "endDate" : document.getElementById("endDate").value,
            "amountDiscount" : document.getElementById("amountDiscount").value,
            "statusDiscount" : document.getElementById("statusDiscount").options[document.getElementById("statusDiscount").selectedIndex].value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    
    }).then(function (res){
        console.info(res);
        return res.json();
    }).then(function (data){
        console.info(data);
    });
}

function loadDiscount(endpoint){
    fetch(endpoint, {
        method:"get",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res){
        console.info(res);
        return res.json();
    }).then(function (data){
        console.info(data);
        var msg = "";
        if(data.length > 0){
            msg += "<table class='table table-striped'>";
            msg += "<tr>";
            msg += "<th>Mã khuyến mãi</th>";
            msg += "<th>Tên khuyến mãi</th>";
            msg += "<th>Tỉ lệ giảm (%)</th>";
            msg += "<th>Ngày bắt đầu</th>";
            msg += "<th>Ngày kết thúc</th>";
            msg += "<th>Số lượng</th>";
            msg += "<th>Trạng thái</th>";
            msg += "</tr>";
            for(var i = 0; i < data.length; i++){
                msg += "<tr>";
                msg += "<td>" + formatCode(data[i].id) + "</td>";
                msg += "<td>" + data[i].name + "</td>";
                msg += "<td>" + data[i].percentageReduction + "</td>";
                msg += "<td>" + formatDateTime(data[i].startDate).split(' ')[0] + "</td>";
                msg += "<td>" + formatDateTime(data[i].endDate).split(' ')[0] + "</td>";
                msg += "<td>" + data[i].amount + "</td>";
                msg += "<td>" + data[i].status + "</td>";
                msg += "</tr>";
            }
            msg += "</table>";
        } else {
            msg += "<div class='alert alert-danger' role='alert'>Không có khuyến mãi nào!!</div>";
        }
        document.getElementById("listDiscount").innerHTML = msg;
    });
}

function addDiscountSession(){
    fetch(`http://localhost:8080/tpizza/api/addDiscountToSession`, {
        method:"post",
        body: JSON.stringify({
            "idDiscount" : document.getElementById("selectDiscount").options[document.getElementById("selectDiscount").selectedIndex].value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    
    }).then(function (res){
        console.info(res);
        return res.json();
    }).then(function (data){
        console.info(data);
    });
}