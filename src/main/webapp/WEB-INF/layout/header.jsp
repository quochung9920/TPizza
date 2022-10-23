<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
    <header>
        <nav class="navbar navbar-expand-sm navbar-light bg-white shadow-lg">
            <div class="container-fluid d-flex">
                <a class="navbar-brand flex-grow-1" href="javascript:void(0)">
                    <img src="<c:url value="/images/logo.png" />" alt="logo" class="logo image-logo">
                </a>
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="javascript:void(0)"><i
                                class="fa-regular fa-bell"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link fw-bolder text-danger language" href="javascript:void(0)">EN</a>
                    </li>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/login" />">
                                <i class="fa-solid fa-user"></i>
                                <span class="fw-bolder text-dark">Thành viên</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="javascript:void(0)">
                                <i class="fa-solid fa-user"></i>
                                <span class="fw-bolder text-dark">${pageContext.request.userPrincipal.name}</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/logout" />">
                                <span class="fw-bolder text-dark">Đăng xuất</span>
                            </a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/tracking" />">
                            <span class="border-start p-3"></span>
                            <i class="fa-solid fa-magnifying-glass-location"></i>
                            <span class="fw-bolder text-dark">Theo dõi đơn hàng</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
</div>