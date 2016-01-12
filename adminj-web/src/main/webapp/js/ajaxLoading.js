$(document).ajaxStart(function(handler) {
	//显示遮罩
	ajaxLoadingShow();
});

$(document).ajaxSuccess(function(evt, request, settings) {
	//隐藏遮罩
	ajaxLoadingHide();
});

//弹出加载层
function ajaxLoadingShow() {
	var obj = $(".datagrid-mask");
	if(obj.size() <= 0 ){
		$("<div class=\"datagrid-mask\"></div>").css( {
			display : "block",
			width : "100%",
			height : $(window).height()
		}).appendTo("body");
		$("<div class=\"datagrid-mask-msg\"></div>").html("正在加载，请稍候。。。").appendTo("body").css( {
			display : "block",
			left : ($(document.body).outerWidth(true) - 190) / 2,
			top : ($(window).height() - 45) / 2
		});
	}
}

//取消加载层  
function ajaxLoadingHide() {
	$(".datagrid-mask").remove();
	$(".datagrid-mask-msg").remove();
}