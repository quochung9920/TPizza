<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="container justify-content-center" style="transform: translateY(35%);">
            <div class="row shadow shadow-lg rounded-3">
                <div class="col-md-5">
                    <img src="<c:url value="/images/logo-login.jpg" />" class="img-fluid" alt="logo">
                </div>
                <div class="col-md-7 align-self-center">
                    <h2 class="text-center">🍕🍕 WELCOME BACK!</h2>
                    <p class="text-center m-0">BẠN ĐÃ LÀ THÀNH VIÊN HUT REWARDS! ĐĂNG NHẬP</p>
                    <p class="text-center">TRƯỚC KHI THANH TOÁN ĐỂ TÍCH ĐIỂM – ĐỔI PIZZA NHÉ!</p>
                    <p class="text-center text-danger">
                        <c:if test="${param.error != null}">
                            Tên đăng nhập hoặc mật khẩu không đúng!!!
                        </c:if>
                    </p>
                    <div class="container">

                        <c:url value="/login" var="action" />

                        <form method="post" action="${action}">
                            <div class="form-group m-4">
                                <label for="email" class="h5">Email</label>
                                <input type="text" class="form-control" id="email" name="email" placeholder="Email">
                            </div>
                            <div class="form-group m-4">
                                <label for="password" class="h5">Mật khẩu</label>
                                <input type="password" class="form-control" id="password" name="password"
                                    placeholder="Mật khẩu">
                            </div>
                            <div class="form-group m-4 d-flex align-self-center justify-content-center">
                                <input type="submit" value="ĐĂNG NHẬP" class="btn btn-success w-75" />
                            </div>

                            <p class="mx-4">Bạn chưa có tài khoản? <span class="text-success"><a class="nav-link" href="<c:url value="/register" />">Đăng ký ngay</a></span></p>
                        </form>
                    </div>
                </div>

            </div>

        </div>