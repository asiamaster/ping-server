
<div class="form-group">
    <label class="col-xs-3 control-label text-right">显示数量: </label>
    <div class="col-xs-9">
        <select name="pageSize">
            <%
                var list = [1,5,10,20,50,100];
                for(count in list){
                    var selected="";
                    if(count == curr){
                        selected="selected";
                    }
            %>
            <option value="${count}" ${selected}>${count}</option>
            <%}%>
        </select>
    </div>
</div>
