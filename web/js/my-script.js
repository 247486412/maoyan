 
 

//轮播图
$(".banner").slide({
	mainCell: '.picture_box',
	autoPlay: true,
	prevCell: '.arrow_left',
	nextCell: '.arrow_right',
	titCell: '.button button',
	trigger: 'click',
});

//鼠标悬浮购票改为票以售空，离开改回购票
// function demo(evenl) {
// 	alert("没票还点进来是不是傻");
// };
//
// function demo1(evenl) {
// 	evenl.innerHTML = '票已售空';
// };
//
// function demo2(evenl) {
// 	evenl.innerHTML = '购票';
// };


//调用此方法得到id
function getId(id){
	return document.getElementById(id);
}

getId("hover1").onmouseover=function(){
	getId("display1").style.height="110px";
	getId("display1").style.opacity="1";
};
getId("hover1").onmouseout=function(){
	getId("display1").style.height="0px";
	getId("display1").style.opacity="0";
}
getId("hover2").onmouseover=function(){
	getId("display2").style.height="110px";
	getId("display2").style.opacity="1";
	
};
getId("hover2").onmouseout=function(){
	getId("display2").style.height="0px";
	getId("display2").style.opacity="0";
}
getId("hover3").onmouseover=function(){
	getId("display3").style.height="110px";
	getId("display3").style.opacity="1";
};
getId("hover3").onmouseout=function(){
	getId("display3").style.height="0px";
	getId("display3").style.opacity="0";
}
getId("hover4").onmouseover=function(){
	getId("display4").style.height="110px";
	getId("display4").style.opacity="1"
};
getId("hover4").onmouseout=function(){
	getId("display4").style.height="0px";
	getId("display4").style.opacity="0";
}
getId("hover5").onmouseover=function(){
	getId("display5").style.height="110px";
	getId("display5").style.opacity="1";
};
getId("hover5").onmouseout=function(){
	getId("display5").style.height="0px";
	getId("display5").style.opacity="0";
}
getId("hover6").onmouseover=function(){
	getId("display6").style.height="110px";
	getId("display6").style.opacity="1";
};
getId("hover6").onmouseout=function(){
	getId("display6").style.height="0px";
	getId("display6").style.opacity="0";
}
getId("hover7").onmouseover=function(){
	getId("display7").style.height="110px";
	getId("display7").style.opacity="1";
};
getId("hover7").onmouseout=function(){
	getId("display7").style.height="0px";
	getId("display7").style.opacity="0";
}
getId("hover8").onmouseover=function(){
	getId("display8").style.height="110px";
	getId("display8").style.opacity="1";
};
getId("hover8").onmouseout=function(){
	getId("display8").style.height="0px";
	getId("display8").style.opacity="0";
}
getId("hover9").onmouseover=function(){
	getId("display9").style.height="110px";
	getId("display9").style.opacity="1";
};
getId("hover9").onmouseout=function(){
	getId("display9").style.height="0px";
	getId("display9").style.opacity="0"
}



