
<!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>layui</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    </head>
<body>



   <button type="button" onclick="m()" style="width: 60px;height: 30px;background-color: #00FFFF"></button>
<script>
    <#--跳转前判断登录人员的工段、岗位、班组、班次等信息-->
    function m() {
        $.ajax({
            type: 'post',
            url : '/spot/changeShifts/login',
            data: $("form").serialize(),
            success : function(responseText) {
            },
            complete : function() {
                //请求完成的处理
            },
            error : function() {
            },
            beforeSend:function(XMLHttpRequest){

            }
        });
    }
</script>
</body>
</html>