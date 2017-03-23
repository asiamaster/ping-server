
<!-- basic scripts -->

<script type="text/javascript">
	if('ontouchstart' in document.documentElement) document.write("<script src='${url_local_static}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");


    function turnPage(currentPage){
        $("#form input[name='currPage']").val(currentPage);
        $("#form input[type='submit']").click();
    }
</script>

<script src="${url_local_static}/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="${url_local_static}/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="${url_local_static}/assets/js/jquery-ui.custom.min.js"></script>
<script src="${url_local_static}/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${url_local_static}/assets/js/jquery.easypiechart.min.js"></script>
<script src="${url_local_static}/assets/js/jquery.sparkline.min.js"></script>
<!--<script src="${url_static}/ace1.3/assets/js/flot/jquery.flot.min.js"></script>
<script src="${url_static}/ace1.3/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="${url_static}/ace1.3/assets/js/flot/jquery.flot.resize.min.js"></script>-->
<script src="${url_local_static}/assets/js/jquery.validate.min.js"></script>
<script src="${url_local_static}/assets/js/jquery.validate.extend.js"></script>
<script src="${url_local_static}/assets/js/base.js"></script>
<!-- ace scripts -->
<script src="${url_local_static}/assets/js/ace-elements.min.js"></script>
<script src="${url_local_static}/assets/js/ace.min.js"></script>

<!--mydate97-->
<script src="${url_local_static}/My97DatePicker/WdatePicker.js"></script>

<!-- diligrp js
<script src="${url_static}/ace1.3/assets/js/diligrp.navigation.js"></script>
<!-- inline scripts related to this page -->
