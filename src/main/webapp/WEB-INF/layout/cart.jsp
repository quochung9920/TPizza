<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid p-2">
    <div class="fs-4 text-center">----- GIỎ HÀNG -----</div>
    <c:if test="${carts == null}">
        <div class="alert alert-info">
            <strong>Không có sản phẩm trong giỏ hàng!</strong>
        </div>
    </c:if>
    <c:if test="${carts != null}">
        <table class="table">
            <tbody>
                <script>
                    var totalPrice = 0;
                </script>
                <c:forEach items="${carts}" var="c">
                    <tr>
                        <th scope="row"><strong>${c.quantity}</strong></th>
                        <td><strong>${c.name}</strong></td>
                        <td><strong id="${c.productId}"></strong></td>
                        <script>
                            var total = ${c.quantity} * ${c.price};
                            totalPrice += total;
                            document.getElementById("${c.productId}").innerHTML = formatNumber(total,'.',',') + ' đ';
                        </script>
                        <td><button type="button" onclick="deleteItemCart(${c.productId})" class="btn btn-danger">X</button></td>
                    </tr>
                </c:forEach>
        </table>
    </c:if>
    <div id="listDiscountEnable">
    </div>
    <div>
        <!-- <div>Thêm món yêu thích</div>
        aaaaaaaaa
      </div> -->
        <table class="table">
            <tbody>
                <tr>
                    <th scope="row">Tổng</th>
                    <c:if test="${carts == null}">
                        <td class="text-end" id="totalPrice">0 đ</td>
                    </c:if>
                    <c:if test="${carts != null}">
                        <td class="text-end" id="totalPrice"></td>
                        <script>
                            document.getElementById("totalPrice").innerHTML = formatNumber(totalPrice,'.',',') + ' đ';
                        </script>
                    </c:if>
                    
                </tr>
                <tr>
                    <th scope="row">Giảm T.Viên</th>
                    <td class="text-end">0 đ</td>
                </tr>
                <tr>
                    <th scope="row">Giảm K.Mại</th>
                    <c:if test="${carts == null}">
                        <td class="text-end">0 đ</td>
                    </c:if>
                    <c:if test="${carts != null}">
                        
                        <td class="text-end" id="totalDiscount">0 đ</td>
                    </c:if>
                    
                </tr>
                <tr>
                    <th scope="row">Phí Giao Hàng</th>
                    <td class="text-end">0 đ</td>
                </tr>

            </tbody>
        </table>
        <a href="<c:url value="/payment" />" class="btn btn-success w-100">THANH TOÁN</a>
    </div>

</div>