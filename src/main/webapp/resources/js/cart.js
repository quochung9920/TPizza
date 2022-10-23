
function addToCart(id, name, price){
    fetch("/tpizza/api/cart", {
        method: "post",
        body: JSON.stringify({
            "productId" : id,
            "name" : name,
            "price" : price,
            "quantity" : 1
        }),
        headers: {
            "Content-Type": "application/json"
        }

    }).then(function (res) {
        console.info(res);
        window.location.reload();
        return res.json();
    }).then(function (data) {

        console.info(data);
    })
}

function deleteItemCart(productId) {
    fetch(`/tpizza/api/cart/${productId}`, {
        method: "delete"
    }).then(function (res) {
        console.info(res);
        window.location.reload();
        return res.json();
    }).then(function (data) {
        console.info(data);
    })
}

function loadCartOrder(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let msg = "";
        const statusArray = [ "PENDING", "SHIPPING", "DELIVERED"];
        for (let i = 0; i < data.length; i++){
            msg += `<tr>
                <td scope="row">${formatCode(data[i].id)}</td>
                <td>${moment(data[i].createDate).fromNow()}</td>
                <td><table class="table" id="tableCartOrder">`;
                for (let j = 0; j < data[i].billDetails.length; j++){
                    msg += `<tr>
                        <td class="border-0">x${data[i].billDetails[j].amount}</td>
                        <td class="border-0">${data[i].billDetails[j].idProduct.name}</td>
                        <td class="border-0">${formatNumber(data[i].billDetails[j].idProduct.price, ',', '.')} đ</td>
                    </tr>`;
                }
                msg += `</table></td>
                <td>${formatNumber(data[i].totalPrice, ',', '.')} đ</td>
                <td>
                    <select class="form-select" id="status-${data[i].id}" onchange="updateBill(${data[i].id})" aria-label="Default select example">`;
                    for (let k = 0; k < statusArray.length; k++){
                        if (statusArray[k].localeCompare(data[i].status) == 0){
                            msg += `<option value="${statusArray[k]}" selected>${statusArray[k]}</option>`;
                        } else {
                            msg += `<option value="${statusArray[k]}">${statusArray[k]}</option>`;
                        }
                    }
                    msg += `</select>
                </td>
                <td>
                    <button type="button" onclick="deleteBill(${data[i].id})" class="btn btn-danger">Huỷ đơn</button>
                </td>
            </tr>`;
        }
        document.getElementById("myCardOrder").innerHTML = msg;
    });
}

function loadCartOrderUser(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let msg = "";
        for (let i = 0; i < data.length; i++){
            msg += `<tr>
                <td scope="row">${formatCode(data[i].id)}</td>
                <td>${moment(data[i].createDate).fromNow()}</td>
                <td><table class="table" id="tableCartOrder">`;
                for (let j = 0; j < data[i].billDetails.length; j++){
                    msg += `<tr>
                        <td class="border-0">x${data[i].billDetails[j].amount}</td>
                        <td class="border-0">${data[i].billDetails[j].idProduct.name}</td>
                    </tr>`;
                }
                msg += `</table></td>
                <td>${formatNumber(data[i].totalPrice, ',', '.')} đ</td>
                <td>${data[i].status}</td>
            </tr>`;
        }
        document.getElementById("myCardOrder").innerHTML = msg;
    });
}

