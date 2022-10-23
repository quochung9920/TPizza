<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <h1>Thống kê</h1>
    <div class="container-fluid">
        <div class="row">
            <div class="col-6">
                <canvas id="myTotalChart"></canvas>
            </div>
            <div class="col-6">
                <canvas id="myTotalChartMonth"></canvas>
            </div>
        </div>
    </div>

    <script>
        let totalLabels = [], totalData = [];
        let totalLabelsMonth = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        let totalDataMonth = [];
        <c:forEach var="t" items="${totalBillsByDay}">
            totalLabels.push("${t.date}");
            totalData.push(${t.total});
        </c:forEach>;
        <c:forEach var="tbm" items="${totalBillsByMonth}">
            totalDataMonth.push(${tbm});
        </c:forEach>;
        window.onload = function () {
            totalChart('myTotalChart', totalLabels, totalData, 'Doanh thu 7 ngày gần nhất');
            totalChart('myTotalChartMonth', totalLabelsMonth, totalDataMonth, 'Doanh thu theo tháng');
        }
    </script>
</div>