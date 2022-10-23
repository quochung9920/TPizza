<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- <spring:message code="firstWord" />
<spring:message code="secondWord" />
<a href="<c:url value="/?lang=vi" />">VI</a>
<a href="<c:url value="/?lang=en" />">US</a> -->

<div class="content">
    <div>
        <img src="<c:url value="/images/image-index.jpg" />" class="img-fluid" alt="image-index">
    </div>
    <div class="container">
        <h4 class="text-center p-2 m-0">KHUYẾN MẠI</h4>
        <div class="row ">
            <div class="col-6">
                <img src="<c:url value="/images/khuyenmai1.jpg" />" class="img-fluid" alt="image-discount1">
            </div>
            <div class="col-6">
                <img src="<c:url value="/images/khuyenmai2.jpg" />" class="img-fluid" alt="image-discount2">
            </div>
        </div>
        <div class="row">
            <div class="col-12 d-flex justify-content-center py-2">
                <a class="btn btn-success w-75" href="<c:url value="/order/pizza" />" >XEM MENU</a>
            </div>
        </div>
    </div>
</div>