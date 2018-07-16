$(".personal").click(()=>{
	let id=$("input")[0].value
	window.location.href='/accounts/user-info.jsp';
});

$(".account").click(()=>{
	let id=$("input")[0].value;
	window.location.href='/accounts/account-details.jsp';
});
