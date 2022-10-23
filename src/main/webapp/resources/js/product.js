
function submitform() {
    document.addProductImage.submit();
}

function loadProducts(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementById("myProduct");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<tr id="${data[i].id}">
                    <td>${formatCode(data[i].id)}</td>
                    <td>
                        <img src="http://localhost:8080/tpizza${data[i].image}" width="60">
                    </td>
                    <td>${data[i].name}</td>
                    <td>${data[i].idCategory.name}</td>
                    <td>${formatNumber(data[i].price, ',', '.')} đ</td>
                    <td>
                        <input type="number" id="product-${data[i].id}" class="form-control" onblur="updateProduct(${data[i].id})" value="${data[i].amount}">
                    </td> 
                </tr>`
        
        d.innerHTML = msg;
    });
}

function loadProductsByCategry(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementById("productByCategory");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<div class="col-3 p-1">
            <div class="card">
                <img class="card-img-top" src="http://localhost:8080/tpizza${data[i].image}" alt="Card image" style="width:100%">
                <div class="p-2">
                  <h5 class="card-title">${data[i].name}</h5>
                  <p class="card-text fs-6">${data[i].content}</p>
                    <hr>
                    <a class="btn btn-success w-100" href="" >
                        <div class="d-flex justify-content-between">
                            <span>CHỌN</span>
                            <span>${data[i].price}</span>
                        </div>
                    </a>
                </div>
              </div>
        </div>`
        
        d.innerHTML = msg;
    });
}



function addProduct(endpoint) {

    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "name": document.getElementById('productName').value,
            "content": document.getElementById('content').value,
            "category": document.getElementById("category").options[document.getElementById("category").selectedIndex].value,
            "price": document.getElementById('price').value,
            "amount": document.getElementById('amount').value,
            "image": document.getElementById('image').files[0].name
        }),
        headers: {
            "Content-Type": "application/json"
        }

    }).then(function (res) {
        console.info(res);
        return res.json();
    }).then(function (data) {
        console.info(data);
    });

}

function updateProduct(id){

    fetch(`/tpizza/api/updateProduct/${id}`, {
        method:"put",
        body: JSON.stringify({
            "amountProduct" : document.getElementById(`product-${id}`).value
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

