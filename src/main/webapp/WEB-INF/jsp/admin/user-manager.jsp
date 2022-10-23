<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">QUẢN LÝ TÀI KHOẢN</h1>
        <a href="<c:url value="/admin/add-user" />" class="btn btn-outline-primary">Thêm Nhân Viên</a>
    </div>     
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Quyền</th>
                <th></th>
            </tr>
        </thead>
        <tbody id="myUser">
        
        </tbody>
        
    </table>
    <script src="<c:url value="/js/user.js" />"></script>
    <script>
        <c:url value="/api/users" var="endpoint" />
        window.onload = function() {
            loadUsers('${endpoint}');
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