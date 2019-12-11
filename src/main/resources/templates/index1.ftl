<!doctype html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<#--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
	<#--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
	<title>基于bootstrup的jQuery多级列表树插件</title>
	<link href="/css/bootstrap.css" rel="stylesheet">
	<style type="text/css">
	</style>

</head>
<body>


	<div class="container">
      <div class="row">
        <div class="col-sm-3">
          <div id="treeview4" class=""></div>
        </div>
      </div>
    </div>

    <script type="text/javascript" src="/plugins/jQuery/jquery-3.2.1.js"></script>
	<script src="/js/bootstrap-treeview.js"></script>
	<script type="text/javascript">

        $(function() {
            $.ajax({
                url: "/pc/getDeptToJson",
                data:[],
                type: "get",
                cache: true,
                dataType: "json",
                success: function (result) {
                    $('#treeview4').treeview({
                        color: "#428bca",
                        data: result
                    });
                }
            });
        });
        // $(".row").click(function () {
        //     var check=$('#treeview4').treeview('getSelected');
        //     // alert(check+"=="+check.length);
        //     for (var i= 0; i < check.length;i++)
        //     {
        //         alert(check[i].text);
        //     }
        // })
    </script>
</body>
</html>