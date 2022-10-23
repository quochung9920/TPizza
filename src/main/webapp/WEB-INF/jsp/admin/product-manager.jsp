<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">QUẢN LÝ SẢN PHẨM</h1>
        <a href="<c:url value="/admin/add-product" />" class="btn btn-outline-primary">Thêm Sản Phẩm</a>
    </div>     
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Mã sản phẩm</th>
                <th>Hình ảnh</th>
                <th>Tên sản phẩm</th>
                <th>Thể loại</th>
                <th>Giá</th>
                <th>Số lượng</th>
            </tr>
        </thead>
        <tbody id="myProduct">
        
        </tbody>
        
    </table>
    <script>
        <c:url value="/api/products" var="endpoint" />
        window.onload = function() {
            loadProducts('${endpoint}');
        }
    </script>
</main>


<footer class="py-4 bg-light mt-auto">
    <div class="container-fluid px-4">
        <div class="d-flex align-items-center justify-content-between small">
            <div class="text-muted">Copyright &copy; Your Website 2022</div>
            <div>
                <a href="#">Privacy Policy</a>
                &middot;
                <a href="#">Terms &amp; Conditions</a>
            </div>
        </div>
    </div>
</footer>