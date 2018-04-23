<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<div style="width: 200px;height: 400px;margin: 0px auto">
    <form action="/test.do" method="post">
        <h2>请上传Excel!</h2>
        用户名： <input name="user_name" type="text"><br>
        性 别： <input name="sex" type="text"><br><br>
        <input type="file"><br><br>
        <div style="width: 150px">
            <input type="reset" value="重置" width="40px" style="float: left">
            <input type="submit" value="提交" width="40px" style="float: right">
        </div>
    </form>
</div>


<%--
<div>
    <button name="importBtn" class="btn btn-primary addExcelBtn" type="button">
        <i class="fa fa-file-excel-o"></i> 批量导入
    </button>
    ...... <!-- excel上传 -->
    <form class="fileForm" method="post" enctype="multipart/form-data">
        <input type="file" name="uploadFile" style="display:none;"/>
    </form>

</div>
--%>

<script type="text/javascript">
    $(".addExcelBtn").unbind('click');
    $(".addExcelBtn").click(function () {
        $(".import").unbind('click');
        $(".import").click(function () {
            $('input[type="file"][name="uploadFile"]').click();
        });
        $('input[type="file"]').unbind("change");
        $('input[type="file"]').change(function () {
            uploadFile();
            $('input[type="file"][name="uploadFile"]').val("");
        });
    });
    function uploadFile() {
        var fileName = $('input[type="file"][name="uploadFile"]').val();
        if (fileName === '') {
            frameModal.hitModal("请选择文件");
            return;
        }
        var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
        if (fileType !== 'xls' && fileType !== 'xlsx') {
            frameModal.hitModal("文件格式不正确，excel文件！");
            return;
        }
        $(".fileForm").ajaxSubmit({
            dataType: "json",
            data: {'1': 1},
            type: "POST",
            url: 'url',
            success: function (data, textStatus) {
                console.log(data);
            },
            error: function () {
                frameModal.hitModal('操作失败');
            }
        });
    };

</script>


</body>
</html>
