<%
    var total =  parseInt(page.totalPage);
    var page = parseInt(page.pageIndex);
%>

<script type="text/javascript">
    function Fpage(page){
        $("input[name='pageIndex']").val(page);
        $("#form").submit();
    }
    var Fpage = window.Fpage;
</script>

<%if(total > 0){%>
<div class="page">

    <%if(page > 1){%>
    <a href="javascript:Fpage(1);">首页</a>
    <a href="javascript:Fpage(${page-1});" class="prev">&lt;</a>
    <%}%>

    <%if(page == 1 && total==1){%>
    <b>${page}</b>
    <%}else if(page == 1 && total>2){%>
    <b>${page}</b>
    <a href="javascript:Fpage(${page+1})">${page+1}</a>
    <a href="javascript:Fpage(${page+2})">${page+2}</a>
    <%}else if(page == 1 && total==2){%>
    <b>${page}</b>
    <a href="javascript:Fpage(${page+1})">${page+1}</a>
    <%}else if(page == 2 && total==2){%>
    <a href="javascript:Fpage(${page-1})">${page-1}</a>
    <b>${page}</b>
    <%}else if(page > 1 && total>page){%>
    <a href="javascript:Fpage(${page-1})">${page-1}</a>
    <b>${page}</b>
    <a href="javascript:Fpage(${page+1})">${page+1}</a>
    <%}else if(page == total){%>
    <a href="javascript:Fpage(${page-2})">${page-2}</a>
    <a href="javascript:Fpage(${page-1})">${page-1}</a>
    <b>${page}</b>
    <%}%>

    <%if(page < total){%>
    <a href="javascript:Fpage(${page+1})" class="next">&gt;</a>
    <a href="javascript:Fpage(${total})">尾页</a>
    <%}%>
    <span>第${page}页/共${total}页</span>
    跳转至
    <input class="iptText" id="pageVal" size="5" maxlength="5">
    <a href="javascript:void(0);" class="toPage"
       onclick="if($('#pageVal').val()<=${total} &&$('#pageVal').val() >0){Fpage($('#pageVal').val())}">确定</a>

</div>

<%}else{%>
<div style="line-height: 60px; color: #999; font-size:14px; text-align: center; border: #CCCCCC solid 1px; border-top:0; margin-bottom: 50px;">数据为空！</div>
<%}%>