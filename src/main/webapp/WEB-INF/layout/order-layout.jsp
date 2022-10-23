<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>

        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="utf-8">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                    integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
                    crossorigin="anonymous"></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
                    integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />
                <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js" integrity="sha512-CryKbMe7sjSCDPl18jtJI5DR5jtkUWxPXWaLCst6QjH8wxDexfRJic2WRmRXmstr2Y8SxDDWuBO6CQC6IE4KTA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
                <link rel="stylesheet" href="<c:url value="/css/style.css" />" />

                <script src="<c:url value="/js/user.js" />"></script>
                <script src="<c:url value="/js/product.js" />"></script>
                <script src="<c:url value="/js/category.js" />"></script>
                <script src="<c:url value="/js/function.js" />"></script>
                <script src="<c:url value="/js/cart.js" />"></script>
                <script src="<c:url value="/js/order.js" />"></script>
                <script src="<c:url value="/js/bill.js" />"></script>
                <script src="<c:url value="/js/discount.js" />"></script>
                
                <title>
                    <tiles:insertAttribute name="title" />
                </title>
            </head>

            <body>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-9">
                            <div class="">
                                <tiles:insertAttribute name="header" />
                                <tiles:insertAttribute name="order-navbar" />
                            </div>
                            <div>
                                <tiles:insertAttribute name="order-content" />
                            </div>
                            
                        </div>
                        <div class="col-3">
                            <tiles:insertAttribute name="cart" />
                        </div>

                    </div>

                </div>
            </body>

            </html>