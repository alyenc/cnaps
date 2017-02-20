$(function() {
    getBanks();
    getProvinces();
	getCitys($('#provinceSelect').selectpicker('val'));
    $('#provinceSelect').on('changed.bs.select', function (e) {
    	var provinceCode = $('#provinceSelect').selectpicker('val');
    	getCitys(provinceCode);
	});
    $('#branchBank').bootstrapTable({
    	striped: true,
    	pagination: true,
    	sidePagination: "client",
    	pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
		columns: [{
		    field: 'branchBankCode',
		    title: 'cnaps'
		}, {
		    field: 'branchBankName',
		    title: '支行名称'
		}, {
		    field: 'branchBankAddress',
		    title: '地址'
		}, {
		    field: 'branchBankTelephone',
		    title: '电话'
		}]
	});
    $("#query").click(getBranchBanks);
});

function getBanks(){
	$.ajax({
	    url : 'getBanks.do',
	    type : "post",
	    async : false,
	    dataType : "json",
	    success : function(data) {
	    	var bankSelect = $("#bankSelect");
	    	for(var i=0; i < data.length; i++ ){
	    		var bankName = data[i].bankName;
	    		var bankCode = data[i].bankCode;
	    		bankSelect.append("<option value='"+bankCode+"'>"+bankName+"</option>");
	    	}	    	
	    },
	    error : function(xhr, status, msg) {
	      
	    }
	});
}

function getProvinces(){
	$.ajax({
	    url : 'getProvinces.do',
	    type : "post",
	    async : false,
	    dataType : "json",
	    success : function(data) {
	    	var provinceSelect = $("#provinceSelect");
	    	for(var i=0; i < data.length; i++ ){
	    		var provinceName = data[i].provinceName;
	    		var provinceCode = data[i].provinceCode;
	    		provinceSelect.append("<option value='"+provinceCode+"'>"+provinceName+"</option>");
	    	}	    	
	    },
	    error : function(xhr, status, msg) {
	      
	    }
	});
}

function getCitys(provinceCode){
	var param = {
		provinceCode : provinceCode
	}
    $.ajax({
        url : 'getCitys.do',
        type : "post",
        async : false,
        data : param,
        success : function(data) {
            var citySelect = $("#citySelect");
            console.log(citySelect);
            citySelect.find("option").remove();
            for(var i=0; i < data.length; i++ ){
                var cityName = data[i].cityName;
                var cityCode = data[i].cityCode;
                citySelect.append("<option value='"+cityCode+"'>"+cityName+"</option>");
            }
            citySelect.selectpicker('refresh');
        },
        error : function(xhr, status, msg) {

        }
    });
}

function getBranchBanks(){
	var params = {
		bankCode: $('#bankSelect').selectpicker('val'),
		cityCode: $('#citySelect').selectpicker('val')
	}
    $.ajax({
        url : 'getBranchBanks.do',
        type : "post",
        async : false,
        data : params,
        dataType : "json",
        success : function(data) {
        	$('#branchBank').bootstrapTable("load", data);
        },
        error : function(xhr, status, msg) {

        }
    });
}

//function getBranchBanks(){
//	var params = {
//		bankCode: $('#bankSelect').selectpicker('val'),
//		cityCode: $('#citySelect').selectpicker('val')
//	}
//	console.log("+++++++++++++++++++++++++++++")
//	$('#branchBank').bootstrapTable({
//		url: 'getBranchBanks.do',
//		method: 'post',
//		queryParams : function (params) {
//			var temp = {
//                bankCode: $('#bankSelect').selectpicker('val'),
//                cityCode: $('#citySelect').selectpicker('val')
//            };
//            return temp;
//        }
//	});
//}