
function remove(){

	$('.myremove').click(function(){
		let _this = $(this);
		console.log("11");
		_this.parent().parent().remove();
	})
}

function sendEmail(){

	$('.sendemail').click(function(){
		$('#myemail').show();
		$('.content>div:eq(2)').hide();
	})
}

  $(function () {
    //Add text editor
    $("#compose-textarea").wysihtml5();

  });


$(function(){
	//侧边导航和内容的切换
	$('.aside').click(function(){
		let _this = $(this);
		let index = _this.index();

		_this.addClass('active')
			.siblings().removeClass('active');
		let content = $('.content');
		let div = content.children(`div:eq(${index-1})`);
		div.show()
			.siblings().hide();
	})


	//新建爬虫
	$('.newSpider').click(function(){
		$('.content>div:eq(1)').hide();
		$('#newSpider').show();
	})

	//new Spider hide
	$('.myclose').click(function(){
		$('#newSpider').hide();
		$('.content>div:eq(1)').show();
	})


	//email hide
	$('.myemail').click(function(){
		$('#myemail').hide();
		$('.content>div:eq(2)').show();
	})

	//新增联系人
	$('.newPeople').click(function(){
		var table = $('#mytable');
		var index = table.children().length;
		var tr = $("<tr></tr>");
		var number = $(`<td>${index}</td>`); 
		var people = $("<td><input type='text'></td>");
		var  email = $("<td><input type='text'></td>");
		var edit = $(" <td><button type='button' class='btn  btn-success'>保存</button></td>");
		var remove = $(" <td><button type='button' class='btn  btn-danger myremove'><i class='fa fa-remove'></i></button></td>");
		tr.append(number).append(people).append(email).append(edit).append(remove);
		table.append(tr);

		//重新获取.remove节点
		window.remove();


	});

	//删除节点
	remove();

	sendEmail();
})