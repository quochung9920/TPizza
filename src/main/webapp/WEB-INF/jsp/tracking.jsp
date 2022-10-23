<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <div class="container d-flex justify-content-center">
    <div class="container py-4">
      <div class="h3">THEO DÕI ĐƠN HÀNG</div>
      <table class="table" id="tableCartOrder">
        <caption>Danh sách các đơn hàng của bạn</caption>
        <thead>
          <tr>
            <th scope="col">Mã đơn hàng</th>
            <th scope="col">Thời gian đặt</th>
            <th scope="col">Nội dung đơn</th>
            <th scope="col">Tổng tiền</th>
            <th scope="col">Trạng thái</th>
          </tr>
        </thead>
        <tbody id="myCardOrder">
        </tbody>
      </table>
    </div>
  </div>

  <script>
    <c:url value='/api/listBill' var="endpointCartOrder" />;
    window.onload = function () {
      loadCartOrderUser('${endpointCartOrder}');
      moment.lang("vi").format('llll');
    }
  </script>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name == null}">
  <div style="min-height: 100vh;background-image: url(<c:url value="/images/background-order.jpg" />)">
  <div class="container">
    <div class="d-flex justify-content-center">
      <div class="w-50 shadow-lg bg-white px-4" style="min-height: 100vh">
        <div class="h4 text-center m-0 py-4">KIỂM TRA ĐƠN HÀNG</div>
        <div class="mb-3 mt-3">
          <label for="orderId" class="form-label">Nhập mã đơn hàng:</label>
          <input type="number" class="form-control" id="orderId" placeholder="Nhập mã đơn hàng">
        </div>
        <button type="button" class="btn btn-success w-100" onclick="getBill()">TÌM KIẾM</button>
        <div id="orderCheck">

        </div>
          
          
      </div>
    </div>
  </div>
  </div>
</c:if>