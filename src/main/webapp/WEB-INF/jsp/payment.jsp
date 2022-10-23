<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div style="min-height: 100vh;background-image: url(<c:url value="/images/background-order.jpg" />)">
    <div class="container">
        <div class="d-flex justify-content-center">
            <div class="w-50 shadow-lg">
                <div class="h4 text-center m-0 py-4">THANH TOÁN</div>
                <div class="p-3 bg-white">
                    <div class="fs-5">ĐƠN HÀNG ĐƯỢC ĐẶT CHO</div>
                    <div class="text-center text-danger" id="validatorPayment"></div>
                    <div class="mb-3 mt-3">
                        <label for="nameOrder" class="form-label">Họ và tên:</label>
                        <input type="text" class="form-control" id="nameOrder" placeholder="Nhập tên">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="phoneOrder" class="form-label">Số điện thoại:</label>
                        <input type="text" class="form-control" id="phoneOrder" placeholder="Nhập số điện thoại">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="addressOrder" class="form-label">Địa chỉ:</label>
                        <input type="text" class="form-control" id="addressOrder" placeholder="Nhập địa chỉ">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="email" class="form-control" id="emailOrder" placeholder="Nhập email">
                    </div>
                    <c:url value="/api/createBill" var="addBill" />
                    <button type="button" onClick="validatorPayment()" class="btn btn-success w-100">ĐẶT HÀNG</button>
                    <script>
                        function validatorPayment(){
                            if(document.getElementById("nameOrder").value == ""){
                                document.getElementById("validatorPayment").innerHTML = "Vui lòng nhập họ và tên";
                            } else if(document.getElementById("phoneOrder").value == ""){
                                document.getElementById("validatorPayment").innerHTML = "Vui lòng nhập số điện thoại";
                            } else if(document.getElementById("addressOrder").value == ""){
                                document.getElementById("validatorPayment").innerHTML = "Vui lòng nhập địa chỉ";
                            } else if(document.getElementById("emailOrder").value == ""){
                                document.getElementById("validatorPayment").innerHTML = "Vui lòng nhập email";
                            } else {
                                addBill('${addBill}')
                            }

                        }
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
           