function totalChart(id, totalLabel = [], totalData = [], labelChart) {
    const labels = totalLabel;
    const data = {
        labels: labels,
        datasets: [{
            label: labelChart,
            data: totalData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 205, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(201, 203, 207, 0.2)',
                'rgb(0, 128, 0, 0.2)',
                'rgb(128, 0, 128, 0.2)',
                'rgb(128, 128, 0, 0.2)',
                'rgb(0, 128, 128, 0.2)',
                'rgb(128, 0, 0, 0.2)'
            ],
            borderColor: [
                'rgb(255, 99, 132)',
                'rgb(255, 159, 64)',
                'rgb(255, 205, 86)',
                'rgb(75, 192, 192)',
                'rgb(54, 162, 235)',
                'rgba(153, 102, 255)',
                'rgba(201, 203, 207)',
                'rgb(0, 128, 0)',
                'rgb(128, 0, 128)',
                'rgb(128, 128, 0)',
                'rgb(0, 128, 128)',
                'rgb(128, 0, 0)'
            ],
            borderWidth: 1
        }]
    };
    const config = {
        type: 'bar',
        data: data,
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        },
    };

    let ctx = document.getElementById(id).getContext('2d')
    new Chart(ctx, config)
}

function totalChartLine(id, totalLabel = [], totalData = []) {
    const labels = totalLabel;
    const data = {
        labels: labels,
        datasets: [{
            label: 'Doanh thu 7 ngày gần nhất',
            data: totalData,
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1
        }]
    };
    const config = {
        type: 'line',
        data: data,
    };

    let ctx = document.getElementById(id).getContext('2d')
    new Chart(ctx, config)
}