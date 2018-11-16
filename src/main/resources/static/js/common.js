function getdata(pnum, psize,type,contentUrl,pageUrl) {
    $("#success").html("")
    $.post(contentUrl, {"pnum": pnum, "psize": psize,"type":type},
        function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#success").append('<div style="display: flex;justify-content:space-between">\n' +
                    '\t\t<div><a style="font-size: small" href=' + data[i].url + '>' + data[i].title + '</a></div>\n' +
                    '\t\t<div style="font-size: small">' + data[i].date + '</div>\n' +
                    '\t</div>\n' +
                    '\t<div style="color: #9a9a9a;margin-top: -2px">----------------------------------------------------------' +
                    '------------------------------------------------------------------------------------------------</div>\n')
            }
        }, "json");
    $.post(pageUrl, {"psize": psize,'type':type}, function (data) {
        //显示分页条
        $("#page").html("")
        $("#page").append('<div class=\'t_page ColorLink\'>总数：' + data.count + '条&nbsp;&nbsp;当前页数：' +
            '<span class=\'FontRed\'>' + pnum + '</span>/' + data.pagecount + '' +
            '<a href="#" onclick="getdata(1,' + psize + ',\''+type+'\',\''+contentUrl+'\',\''+pageUrl+ '\')">首页</a>' +
            '<span id="shangyiye"><a href="#" onclick="getdata(' + (pnum - 1) + ',' + psize + ',\''+type+'\',\''+contentUrl+'\',\''+pageUrl+ '\')">上一页</a></span>' +
            '<span id="pagenum"></span> ' +
            '<span id="xiayiye"><a href=# onclick="getdata(' + (pnum + 1) + ',' + psize +',\''+type+'\',\''+contentUrl+'\',\''+pageUrl+ '\')">下一页</a></span>' +
            '<a href="#" onclick="getdata(' + data.pagecount + ',' + psize +',\''+type+'\',\''+contentUrl+'\',\''+pageUrl+ '\')">尾页</a></div>\n')
        //遍历页码
        $("#pagenum").html("");
        for (var i = 0; i < data.pagecount; i++) {
            $("#pagenum").append("<a href='#' onclick='getdata(" + (i + 1) + "," + psize + ',"'+type+'\",\"'+contentUrl+'\",\"'+pageUrl+ "\")'>" + (i + 1) + "</a>")
        }
        //上一下，下一页调整
        if (pnum == 1) {
            $("#shangyiye").html("");
            $("#shangyiye").append("上一页")
        }
        if (pnum == data.pagecount) {
            $("#xiayiye").html("");
            $("#xiayiye").append("下一页")
        }
    }, "json")

}
