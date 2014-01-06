<!-- start: MAIN JAVASCRIPTS -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/assets/plugins/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/blockUI/jquery.blockUI.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/iCheck/jquery.icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/perfect-scrollbar/src/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/perfect-scrollbar/src/perfect-scrollbar.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<!-- end: MAIN JAVASCRIPTS -->
<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/ckeditor/adapters/jquery.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/form-validation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script>
    jQuery(document).ready(function () {
        Main.init();
        FormValidator.init();
    });
</script>
