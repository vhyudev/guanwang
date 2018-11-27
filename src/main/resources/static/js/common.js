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

function getLeftNews(){
    $.post("/leftNewsquery",{type:"1"},function(data){
        $("#leftNews").html('');
        if(data.responseCode == '1'){
            $("#leftNews").html("查询出错了");
            return;
        }
        for (var i = 0; i < data.data.length; i++) {
            $("#leftNews").append("<dd><a href='"+data.data[i].url+"' target='_blank' title='"+data.data[i].title+"'>"+data.data[i].title+"</a></dd>");
        }

    },"json");
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  decodeURI(r[2]); return null;
}
function getArticle(){
    var id = getQueryString("id");
    $.post("/getArticle",{id:id},function(data){
      if(data.responseCode=="0"){//成功
        $("#newsTitle").html();//标题
        $("#newsTitle").html("<h3>"+data.data.nd.title+"</h3>")
        $("#secondTitle").html();//第二行
        $("#secondTitle").html(data.data.nd.publishDate+"&nbsp  &nbsp&nbsp&nbsp&nbsp 点击："+data.data.nd.clickcount);
        $("#mainArea").html();
        $("#mainArea").html(data.data.nd.content);
        $("#beforArticle").html();
        if(data.data.beforeId==null || data.data.beforeId==""){
            $("#beforArticle").html("上一篇：没有啦");
        }else{
            $("#beforArticle").html("上一篇：<a href='"+data.data.beforeUrl+"' target='_blank' title='"+data.data.beforeTitle+"'>"+data.data.beforeTitle+"</a> <span class='ListDate'>"+data.data.beforePublishDate+"</span>");
        }
        if(data.data.nextId==null || data.data.nextId==""){
            $("#nextArticle").html("下一篇：没有啦");
        }else{
            $("#nextArticle").html("下一篇：<a href='"+data.data.nextUrl+"' target='_blank' title='"+data.data.nextTitle+"'>"+data.data.nextTitle+"</a> <span class='ListDate'>"+data.data.nextPublishDate+"</span>");
        }

      }

    },"json");
}



