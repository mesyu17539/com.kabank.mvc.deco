/**
 * 
 */
function init() {
	var arr=['burgerking','kakao','lotto','sktelecom','bitcamp'];
	for(var i = 0; i < arr.length ; i++){
		document.querySelector('#'+arr[i]).addEventListener('click',
				function(e){
			location.href ="../"+this.id+"/main.jsp";
		},false);
	}
}
window.addEventListener("load",init,false);