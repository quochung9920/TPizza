function addBill(endpoint) {

    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "nameOrder": document.getElementById("nameOrder").value,
            "phoneOrder": document.getElementById("phoneOrder").value,
            "addressOrder": document.getElementById("addressOrder").value,
            "emailOrder": document.getElementById("emailOrder").value
        }),
        headers: {
            "Content-Type": "application/json"
        }

    }).then(function (res) {
        console.info(res);
        return res.json();
    }).then(function (data) {
        console.info(data);
        window.location.href = "http://localhost:8080/tpizza/order";
    });

}


function updateBill(id){

    fetch(`/tpizza/api/updateBill/${id}`, {
        method:"put",
        body: JSON.stringify({
            "status" : document.getElementById(`status-${id}`).options[document.getElementById(`status-${id}`).selectedIndex].value
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

function deleteBill(productId) {
    fetch(`/tpizza/api/deleteBill/${productId}`, {
        method: "delete"
    }).then(function (res) {
        console.info(res);
        window.location.reload();
        return res.json();
    }).then(function (data) {
        console.info(data);
    })
}

function getBill() {
    var id = unformatCode(document.getElementById("orderId").value);
    fetch(`/tpizza/api/bill/${id}`).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        var msg = "";
        if (data.id == null) {
            msg += `<div class="mt-4 p-2">
                <div class="alert alert-info">Không có đơn hàng nào được tìm thấy!</div>
                </div>`;
        } else {
            msg += `<div class="mt-4 border border-secondary rounded p-2">
            <div class="h5 border-bottom border-secondary py-2">Thông tin Đơn Hàng ${formatCode(data.id)} 
                <span class="text-end"> - ${data.status}</span>
            </div>
            <div class="py-2">Ngày đặt: ${formatDateTime(data.createDate)}</div>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">SL</th>
                  <th scope="col">Tên món</th>
                  <th scope="col" class="w-25">Đơn giá</th>
                </tr>
              </thead>
              <tbody>`;
                for (var i = 0; i < data.billDetails.length; i++) {
                    msg += `<tr>
                        <th scope="row">x${data.billDetails[i].amount}</th>
                        <td>${data.billDetails[i].idProduct.name}</td>
                        <td>${formatNumber(data.billDetails[i].idProduct.price, ',', '.')} đ</td>
                        </tr>`;
                }
            msg += `</tbody>
                    <tfoot>
                        <tr>
                            <th colspan="2">Tổng</th>
                            <th>${formatNumber(data.totalPrice, ',', '.')} đ</th>
                        </tr>
                    </tfoot>
                </table>
                </div>`;

        }

        document.getElementById("orderCheck").innerHTML = msg;
    });
}


function loadBillDashboard(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementById("listOrderDashboard");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<tr>
            <td>${formatCode(data[i].id)}</td>
            <td>${data[i].nameOrder}</td>
            <td>${formatDateTime(data[i].createDate)}</td>
            <td>${formatNumber(data[i].totalPrice, ',', '.')} VNĐ</td>
            <td>${data[i].status}</td>
        </tr>`
        
        d.innerHTML = msg;
    });
}

function loadBillDashboardKw(endpoint) {
    fetch(endpoint, {
        method:"post",
        body: JSON.stringify({
            "kw" : document.getElementById('searchBillDashboard').value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        document.getElementById("listOrderDashboard").innerHTML = "";
        let d = document.getElementById("listOrderDashboard");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<tr>
            <td>${formatCode(data[i].id)}</td>
            <td>${data[i].nameOrder}</td>
            <td>${formatDateTime(data[i].createDate)}</td>
            <td>${formatNumber(data[i].totalPrice, ',', '.')} VNĐ</td>
            <td>${data[i].status}</td>
        </tr>`
        
        d.innerHTML = msg;
        document.getElementById('searchBillDashboard').value = "";
    });
}