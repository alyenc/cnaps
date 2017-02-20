<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>电子联行号查询</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="select/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="table/bootstrap-table.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="select/js/bootstrap-select.min.js"></script>
    <script src="table/bootstrap-table.min.js"></script>
    <script src="table/bootstrap-table-zh-CN.min.js"></script>
	<script src="index.js"></script>
  </head>
  <body >
  	<div>
  		<h3 style="text-align:center">现代支付系统号查询</h3>
	  	<div style="padding-top:20px;padding-left:50px;text-align:center">
		  	<select id="bankSelect" class="selectpicker">
			</select>
			<select id="provinceSelect" class="selectpicker">
			</select>
			<select id="citySelect" class="selectpicker">
			</select>
			<button id="query" type="button" class="btn btn-default">查询</button>
	  	</div>
		<div style="padding-top:20px">
		  	<table id="branchBank" class="table"></table> 
	  	</div>
  	</div>
  </body>
</html>