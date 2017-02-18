$(function() {
    getBanks();
    getProvinces();
});

function getBanks(){
	$.ajax({
	    url : 'http://localhost:8080/cnaps/getBanks.do',
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
	    url : 'http://localhost:8080/cnaps/getProvinces.do',
	    type : "post",
	    async : false,
	    dataType : "json",
	    success : function(data) {
	    	var bankSelect = $("#provinceSelect");
	    	for(var i=0; i < data.length; i++ ){
	    		var provinceName = data[i].provinceName;
	    		var provinceCode = data[i].provinceCode;
	    		bankSelect.append("<option value='"+provinceCode+"'>"+provinceName+"</option>");
	    	}	    	
	    },
	    error : function(xhr, status, msg) {
	      
	    }
	});
}

function getCitys(){
    $.ajax({
        url : 'http://localhost:8080/cnaps/getProvinces.do',
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

function getBranchBanks(){
    $.ajax({
        url : 'http://localhost:8080/cnaps/getProvinces.do',
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