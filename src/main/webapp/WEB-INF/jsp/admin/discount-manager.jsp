<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <h1>KHUYẾN MÃI</h1>
    <form>
        <div class="row">
            <div class="col px-1">
                <div class="form-floating mb-3 mt-3">
                    <input type="text" class="form-control" id="nameDiscount" placeholder="Tên khuyến mãi">
                    <label for="nameDiscount">Tên khuyến mãi</label>
                </div>
            </div>
            <div class="col px-1">
                <div class="form-floating mt-3 mb-3">
                    <input type="number" class="form-control" id="percentageReduction"
                        placeholder="Tỉ lệ">
                    <label for="percentageReduction">Tỉ lệ</label>
                </div>
            </div>
            <div class="col px-1">
                <div class="form-floating mt-3 mb-3">
                    <input type="date" class="form-control" id="startDate" placeholder="Ngày bắt đầu" name="startDate">
                    <label for="startDate">Ngày bắt đầu</label>
                </div>
            </div>
            <div class="col px-1">
                <div class="form-floating mt-3 mb-3">
                    <input type="date" class="form-control" id="endDate" placeholder="Ngày kết thúc" name="endDate">
                    <label for="endDate">Ngày kết thúc</label>
                </div>
            </div>
            <div class="col px-1">
                <div class="form-floating mt-3 mb-3">
                    <input type="number" class="form-control" id="amountDiscount" placeholder="Số lượng mã"
                        name="amountDiscount">
                    <label for="amountDiscount">Số lượng mã</label>
                </div>
            </div>
            <div class="col px-1">
                <div class="form-floating mt-3 mb-3">
                    <select class="form-select" id="statusDiscount" name="statusDiscount">
                        <option value="Enable">Enable</option>
                        <option value="Disable">Disable</option>
                    </select>
                    <label for="statusDiscount" class="form-label">Trạng thái:</label>
                </div>
            </div>
            <div class="col px-1">
                <div class="form-floating mt-3 mb-3">
                    <button type="button" class="btn btn-primary w-100" style="height: 58px;" onclick="addDiscount('<c:url value="/api/addDiscount" />')">Thêm mã</button>
                </div>    
            </div>
        </div>
    </form>

    <div id="listDiscount">

    </div>
    <script>
        <c:url value='/api/getDiscounts' var="getDiscounts" />;
        window.onload = function () {
            loadDiscount('${getDiscounts}');
        }
    </script>
</div>