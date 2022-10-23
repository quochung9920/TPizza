<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<div class="container d-flex justify-content-center" style="min-height: 100vh;">

    <div class="w-50"> 
        <h1 class="m-4 text-center">Thêm sản phẩm</h1>
        <div class="text-danger text-center" id="validatorProduct"></div>
        <div class="form-group m-4">
            <label for="productName" class="h5">Tên sản phẩm</label>
            <input type="text" class="form-control" id="productName" placeholder="Cocacola" />
        </div>
        <div class="form-group m-4">
            <label for="content" class="h5">Mô tả ngắn</label>
            <input type="text" class="form-control" id="content" placeholder="Cocacola" />
        </div>
        <div class="form-group m-4">
            <label for="category" class="h5">Thể loại</label>
            <select class="form-select" id="category" aria-label="Default select example">
                <c:forEach items="${categories}" var="cate">
                    <option value="${cate.id}">${cate.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group m-4">
            <label for="price" class="h5">Giá</label>
            <input type="number" class="form-control" id="price" placeholder="20000" />
        </div>
        <div class="form-group m-4">
            <label for="amount" class="h5">Số lượng</label>
            <input type="number" class="form-control" id="amount" placeholder="Số lượng" />
        </div>
        
        <c:url value="/admin/add-product" var="addProductImage" />
        <form:form method="POST" name="addProductImage" id="addProductImage" action="${addProductImage}" modelAttribute="addProductImage" enctype="multipart/form-data">
            <div class="form-group m-4">
                <label for="image" class="h5">Hình ảnh</label>
                <input type="file" accept=".jpg, .png, .jpeg" name="productImage" class="form-control" id="image"/>
            </div>
        </form:form>	
        <div class="form-group m-4 d-flex justify-content-center">
            <c:url value="/api/add-product" var="addProduct" />
            <input type="button" onclick="validateAddProduct()" value="THÊM SẢN PHẨM" class="btn btn-primary h5 w-50" />
        </div>

        <script>
            function validateAddProduct(){
                if(document.getElementById("productName").value == ""){
                    document.getElementById("validatorProduct").innerHTML = "Tên sản phẩm không được để trống";
                } else if(document.getElementById("content").value == ""){
                    document.getElementById("validatorProduct").innerHTML = "Mô tả ngắn không được để trống";
                } else if(document.getElementById("price").value == ""){
                    document.getElementById("validatorProduct").innerHTML = "Giá không được để trống";
                } else if(document.getElementById("amount").value == ""){
                    document.getElementById("validatorProduct").innerHTML = "Số lượng không được để trống";
                } else if(document.getElementById("image").value == ""){
                    document.getElementById("validatorProduct").innerHTML = "Hình ảnh không được để trống";
                } else {
                    addProduct('${addProduct}');
                    submitform();
                }
            }
        </script>
    </div>
</div>