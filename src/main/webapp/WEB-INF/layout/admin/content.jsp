<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Dashboard</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Dashboard</li>
            </ol>
            <div class="row">
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-primary text-white mb-4">
                        <div class="card-body">Tổng doanh thu</div>
                        <div class="h3 px-3" id="totalRevenue"></div>
                        <script>
                            var totalRevenue = ${totalRevenue};
                            document.getElementById("totalRevenue").innerHTML = formatNumber(totalRevenue, ',', '.') + " VNĐ";
                        </script>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="<c:url value="/admin/turnover" />">Xem chi tiết</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-warning text-white mb-4">
                        <div class="card-body">Tổng số đơn đặt hàng</div>
                        <div class="h3 px-3" id="totalOrder"></div>
                        <script>
                            var totalOrder = ${totalOrder};
                            document.getElementById("totalOrder").innerHTML = formatNumber(totalOrder, ',', '.') + " Đơn hàng";
                        </script>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="<c:url value="/admin/bill-manager" />">Xem chi tiết</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-success text-white mb-4">
                        <div class="card-body">Số sản phẩm</div>
                        <div class="h3 px-3" id="totalProducts"></div>
                        <script>
                            var totalProducts = ${totalProducts};
                            document.getElementById("totalProducts").innerHTML = formatNumber(totalProducts, ',', '.') + " Sản phẩm";
                        </script>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="<c:url value="/admin/product-manager" />">Xem chi tiết</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6">
                    <div class="card bg-danger text-white mb-4">
                        <div class="card-body">Tài khoản hoạt động</div>
                        <div class="h3 px-3" id="totalUsers"></div>
                        <script>
                            var totalUsers = ${totalUsers};
                            document.getElementById("totalUsers").innerHTML = formatNumber(totalUsers, ',', '.') + " Tài khoản";
                        </script>
                        <div class="card-footer d-flex align-items-center justify-content-between">
                            <a class="small text-white stretched-link" href="<c:url value="/admin/user-manager" />">Xem chi tiết</a>
                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-6">
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-chart-area me-1"></i>
                            Thống kê doanh thu
                        </div>
                        <div class="card-body">
                            <canvas id="myAreaChart" width="100%" height="40"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-xl-6">
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-chart-bar me-1"></i>
                            Sản phẩm bán chạy nhất
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <c:forEach items="${top3Product}" var="top">
                                    <div class="col-4">
                                        <img src="<c:url value="${top.productImage}" />" class="img-fluid" alt="Responsive image">
                                        <h5>${top.productName}</h5>
                                        <p>Đã bán ${top.total} sản phẩm</p>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    Các đơn đặt hàng
                </div>
                <div class="card-body">
                    <nav class="navbar navbar-expand-sm navbar-white">
                        <div class="container-fluid p-0">
                          <div class="collapse navbar-collapse d-flex justify-content-between" id="mynavbar">

                            <ul class="pagination m-0">
                                <c:forEach var="i" begin="1" end="${Math.ceil(totalOrder / 5)}">
                                    
                                    <li class="page-item"><a class="page-link" onclick="loadBillDashboardKw('<c:url value='/api/getBillDashboard/${i}' />')" href="javascript:void(0)" >${i}</a></li>
                                </c:forEach>
                            </ul>
                            <form class="d-flex" style="height: 40px;">
                              <input class="form-control me-2" type="text" id="searchBillDashboard" placeholder="Nhập mã đơn hàng">
                              <button class="btn btn-primary" style="width: 140px" type="button" onclick="loadBillDashboardKw('<c:url value='/api/getBillDashboard/1' />')">Tìm kiếm</button>
                            </form>
                          </div>
                        </div>
                      </nav>
                    
                    <table id="datatablesSimple" class="w-100">
                        <thead>
                            <tr>
                                <th>Mã đơn hàng</th>
                                <th>Người đặt</th>
                                <th>Ngày đặt</th>
                                <th>Tổng tiền</th>
                                <th>Trạng thái</th>
                            </tr>
                        </thead>
                        <tbody id="listOrderDashboard">

                        </tbody>
                        <script>
                            <c:url value='/api/getBillDashboard' var="endpointCartOrder" />;
                            let tLabels=[], tData=[];
                            <c:forEach var="t" items="${totalBillsByDay}">
                                tLabels.push("${t.date}");
                                tData.push(${t.total});
                            </c:forEach>
                            window.onload = function () {
                                loadBillDashboard('${endpointCartOrder}');
                                totalChartLine('myAreaChart', tLabels, tData, 'Doanh thu 7 ngày gần nhất');
                            }
                        </script>
                        <style>
                            .dataTable-dropdown, .dataTable-search{
                                display: none;
                            }
                        </style>
                    </table>
                </div>
            </div>
        </div>
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
  