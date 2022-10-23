<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<div class="container d-flex justify-content-center">

    <div class="w-50">
        <sec:authorize access="hasRole('ROLE_ADMIN')">  
            <h1 class="m-4 text-center">Thêm nhân viên</h1>
        </sec:authorize>
        <sec:authorize access="!hasRole('ROLE_ADMIN')">
            <h1 class="m-4 text-center">Đăng ký</h1>
        </sec:authorize>
        <div id="validatorRegister"></div>
        <div class="form-group m-4">
            <label for="email" class="h5">Email</label>
            <input type="email" class="form-control" id="email" placeholder="tpizza@gmail.com" />
        </div>
        <div class="form-group m-4">
            <label for="username" class="h5">Tài khoản</label>
            <input type="text" class="form-control" id="username" placeholder="tpizza" />
        </div>
        <div class="form-group m-4">
            <label for="password" class="h5">Mật khẩu</label>
            <input type="password" class="form-control" id="password" placeholder="6+ ký tự" />
        </div>
        <div class="form-group m-4">
            <label for="confirmPassword" class="h5">Xác nhận mật khẩu</label>
            <input type="password" class="form-control" id="confirmPassword" placeholder="Xác nhận lại mật khẩu" />
        </div>
        <div class="form-group m-4 d-flex justify-content-center">
            <c:url value="/api/register" var="register" />
            <sec:authorize access="hasRole('ROLE_ADMIN')">  
                <input type="button" onclick="validatorRegister('ROLE_STAFF')" value="ĐĂNG KÝ" class="btn btn-primary h5 w-50" />
            </sec:authorize>
            <sec:authorize access="!hasRole('ROLE_ADMIN')">
                <input type="button" onclick="validatorRegister('ROLE_USER')" value="ĐĂNG KÝ" class="btn btn-primary h5 w-50" />
            </sec:authorize>
        </div>
    </div>
</div>
<script>
    function validatorRegister(role){
        if(document.getElementById("email").value == "" || document.getElementById("username").value == "" || document.getElementById("password").value == "" || document.getElementById("confirmPassword").value == ""){
            document.getElementById("validatorRegister").innerHTML = "<div class='alert alert-danger' role='alert'>Vui lòng nhập đầy đủ thông tin</div>";
            return false;
        } else {
            if(role == "ROLE_USER"){
                addUser('${register}', role, 'http://localhost:8080/tpizza/login');
            } else {
                addUser('${register}', role, 'http://localhost:8080/tpizza/admin/user-manager');
            }
        }
    }
</script>