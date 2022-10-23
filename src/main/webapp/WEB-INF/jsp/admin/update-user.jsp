<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container d-flex justify-content-center">
    <div class="w-50">
        <h1 class="m-4 text-center">Cập nhật thông tin tài khoản</h1>
        <div class="form-group m-4">
            <label for="email" class="h5">Email</label>
            <input type="email" value="${user.email}" class="form-control" id="email" placeholder="tpizza@gmail.com" readonly />
        </div>
        <div class="form-group m-4">
            <label for="username" class="h5">Tài khoản</label>
            <input type="username" value="${user.username}" class="form-control" id="username" placeholder="tpizza" />
        </div>
        <div class="form-group m-4">
            <label for="password" class="h5">Mật khẩu</label>
            <input type="password" value="${user.password}" class="form-control" id="password" placeholder="6+ ký tự" />
        </div>
        <div class="form-group m-4">
            <label for="phone" class="h5">Số điện thoại</label>
            <input type="text" value="${user.phone}" class="form-control" id="phone" placeholder="Số điện thoại" />
        </div>
        <div class="form-group m-4">
            <label for="address" class="h5">Địa chỉ</label>
            <input type="text" value="${user.address}" class="form-control" id="address" placeholder="Địa chỉ" />
        </div>
        <div class="form-group m-4">
            <label for="role" class="h5">Cấp bậc</label>
            <select class="form-control" id="role">
                <c:forEach items="${roles}" var="r">
                    <option value="${r}" <c:if test="${r == user.role}">selected</c:if>>${r}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group m-4 d-flex justify-content-center">
            <c:url value="/api/update-user" var="updateUser" />
            <input type="button" onclick="updateUser('${updateUser}')" value="CẬP NHẬT" class="btn btn-primary h5 w-50" />
        </div>
    </div>
</div>