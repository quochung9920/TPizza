<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>



                <div class="row" id="productByCategory"
                    style="min-height: 100vh;background-image: url(<c:url value="/images/background-order.jpg" />)">


                </div>
                <script>
                    
                    <c:url value='/api/categories' var="endpointCate" />;
                    
                    <c:url value='/api/products/' var="endpointProduct" />;
                    <c:url value="/api/getDiscounts" var="getDiscountsEnable"/>;
                    window.onload = function () {
                        loadCategoryAndProduct('${endpointCate}', '${endpointProduct}', '${getDiscountsEnable}');
                    }
                </script>