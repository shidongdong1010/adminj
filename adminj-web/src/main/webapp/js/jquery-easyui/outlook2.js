$(function(){
	InitLeftMenu();
	tabClose();
	tabCloseEven();
	
	$('.easyui-accordion').on("click",'a', function(e){
		e.preventDefault();
		return false;
	});
})

//初始化左侧
function InitLeftMenu() {
	$(".easyui-accordion").accordion();
    $(".easyui-accordion").empty();
   
    $.each(_menus.menus, function(i, n) {
    	var contenthtml = '<ul>';
        $.each(n.menus, function(j, o) {
			contenthtml += '<li><div><a href="' + o.url + '" ><span class="icon '+o.icon+'" >&nbsp;</span><span class=\'title\'>' + o.menuname + '</span></a></div></li> ';
        });
        contenthtml += '</ul>';
        	
        $(".easyui-accordion").accordion('add', {
			title: n.menuname,
			content: contenthtml,
			iconCls: n.icon,
			selected: false
		});
    });

	$('.easyui-accordion li div').click(function(){
		var tabTitle = $(this).find("a").find(".title").text();
		var url = $(this).find("a").attr("href");
		addTab(tabTitle, url);
		$('.easyui-accordion li div').removeClass("selected");
		$(this).addClass("selected");
	}).hover(function(){
		$(this).addClass("hover"); 
	},function(){
		$(this).removeClass("hover");
	});
    
	$(".easyui-accordion").accordion();
}

// 获取父菜单
function findMenu(menuid){
	var menu;
	$.each(_menus.menus, function(i, n) {
		if(n.menuid == menuid){
			menu = n;
			return;
		}
	});
	return menu;
}

function addTab(subtitle,url){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			width:$('#mainPanle').width()-10,
			height:$('#mainPanle').height()-26
		});
	}else{
		// 显示当前tab
		$('#tabs').tabs('select',subtitle);
		
		// 得到当前tab
		var current_tab = $('#tabs').tabs('getSelected');
		// 刷新当前tab
		$('#tabs').tabs('update',{
		     tab:current_tab,
		     options : {
		          content : createFrame(url)
		     }
		});
	}
	tabClose();
}

function createFrame(url)
{
	var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'+url+'" style="border:none;width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children("span").text();
		$('#tabs').tabs('close',subtitle);
	})

	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});
		
		var subtitle =$(this).children("span").text();
		$('#mm').data("currtab",subtitle);
		
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});	
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t!=currtab_title)
				$('#tabs').tabs('close',t);
		});	
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

function clockon() {
    var now = new Date();
    var year = now.getFullYear(); //getFullYear getYear
    var month = now.getMonth();
    var date = now.getDate();
    var day = now.getDay();
    var hour = now.getHours();
    var minu = now.getMinutes();
    var sec = now.getSeconds();
    var week;
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    if (hour < 10) hour = "0" + hour;
    if (minu < 10) minu = "0" + minu;
    if (sec < 10) sec = "0" + sec;
    var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    week = arr_week[day];
    var time = "";
    time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu + ":" + sec + " " + week;

    $("#bgclock").html(time);

    var timer = setTimeout("clockon()", 200);
}
