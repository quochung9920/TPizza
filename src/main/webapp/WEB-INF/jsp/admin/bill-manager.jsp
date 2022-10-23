<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container d-flex justify-content-center">
    <div class="container py-4">
      <div class="h3">TẤT CẢ ĐƠN HÀNG</div>
      <table class="table" id="tableCartOrder">
        <caption>Danh sách các đơn hàng của cửa hàng</caption>
        <thead>
          <tr>
            <th scope="col">Mã đơn hàng</th>
            <th scope="col">Thời gian đặt</th>
            <th scope="col">Nội dung đơn</th>
            <th scope="col">Tổng tiền</th>
            <th scope="col">Trạng thái</th>
            <th scope="col"></th>
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
      loadCartOrder('${endpointCartOrder}');
      moment.lang("vi").format('llll');
    }
  </script>