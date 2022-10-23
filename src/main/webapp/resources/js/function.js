function formatNumber(nStr, decSeperate, groupSeperate) {
    nStr += '';
    x = nStr.split(decSeperate);
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + groupSeperate + '$2');
    }
    return x1 + x2;
}

function formatCode(id) {
    i = 0;
    x = id;
    while (x != 0) {
        x = Math.floor(x / 10);
        i++;
    }

    var s = "";
    for (j = 1; j <= 6 - i; j++)
    {
        s += "0";
    }
    return s + id;
}

function unformatCode(id) {
    return parseInt(id);
}




function formatDate(date) {
    var year = date.getFullYear().toString();
    var month = (date.getMonth() + 101).toString().substring(1);
    var day = (date.getDate() + 100).toString().substring(1);
    return day + '/' + month + '/' + year;
}
function formatTime(date) {
    var hours = date.getHours().toString();
    var minutes = date.getMinutes().toString();
    var seconds = date.getSeconds().toString();
    return hours + ':' + minutes + ':' + seconds;
}

function formatDateTime(x){
    var date = new Date(x);
    return formatDate(date) + ' ' + formatTime(date);
}