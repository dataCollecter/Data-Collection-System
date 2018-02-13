'use strict';
const ajaxOptions = {
    method: 'GET',
    timeout: 5000,
    beforeSend: function() {
        myalert('success', '数据发送成功');
    },
    contentType:"application/json",
    dataType: 'JSON',
};

let Data = (function() {
    // 缓存
    const Data = [];
    // 路由 方便后期拓展,目前无多大用处
    const Router = [{
            url: '/data/get'
        },
        {
            url: '/data/search'
        }
    ];
    // 页面控制器
    const Page = {
        name: 'Data',
        init: false,
        page: 1,
        step: 15,
        max: function() {
            return Math.ceil(Data.length / Page.step);
        },
        previous: function() {
            $(`#${this.name}_previous`).click(function() {
                if (Page.page <= 1) {
                    console.log("previous");
                    return;
                }
                Page.page--;
                Page.fixed();
            });
        },
        next: function() {
            $(`#${this.name}_next`).click(function() {
                if (Page.page >= Page.max()) {
                    console.log("next");
                    return;
                }
                Page.page++;
                Page.fixed();
            });
        },
        fixed: function() {
            let root = $('#Data');
            let tbody = root.children('tbody');
            let dom = '';
            for (let i = (this.page - 1) * this.step; i < Data.length && i < this.page * this.step; i++) {
                dom +=
                    `<tr>
	                <td>${i+1}</td>
	                <td>${Data[i].source}</td>
	                <td>${Data[i].url}</td>
	                <td>${Data[i].title}</td>
	                <td>${Data[i].time}</td>
	            </tr>
	    		`;
            }
            tbody.html(dom);
            let info = `第 <span class="label label-info">${this.page}</span> 页,共 <span class="label label-info">${this.max()}</span>页, 每页 <span class="label label-info">${this.step}</span> 项 , 共 <span class="label label-info">${Data.length}</span>项`;
            if (!this.init) {
                let foot = `
				<div class="dataTables_info" id="${this.name}_info" role="status" aria-live="polite">${info}</div>
		    	 <div class="dataTables_paginate pull-right paging_simple_numbers" id="${this.name}_paginate">
		            <ul class="pagination">
		                <li class="paginate_button previous" id="${this.name}_previous"><a href="javascript:void(0)" aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a></li>
		                <li class="paginate_button next" id="${this.name}_next"><a href="javascript:void(0)" aria-controls="example1" data-dt-idx="7" tabindex="0">Next</a></li>
		            </ul>
		        </div>`;
                root.parent().parent().append(foot);
                this.previous();
                this.next();
                this.init = true;
            }
            $(`#${this.name}_info`).html(info);

        }
    }

    // 需要重新选择的dom节点 
    const Dom = {
        Search: $('button[data-submit=Datasearch]'),
    };

    // 
    function fixed(options, data) {

        Router[0].resolve = function() {

            //返回的不知道是json对象 还是 json字符串
            //  目前是当成json对象没有进行转码
            data.result.forEach(function(item) {
                Data.push(item);
            });

            Page.fixed();
        };
        Router[1].resolve = function() {
            const item = {
                source: options.data.source,
                time: options.data.time,
                url: options.data.url,
                title: options.data.title
            };
            Data.push(item);
            Page.fixed();
        };
        for (let i = 0; i < Router.length; i++) {

            if (Router[i].url === options.url) {
                Router[i].resolve();
                break;
            }
        }
    }

    // 发送ajax
    function ajax(options, mes) {

        $.ajax($.extend(options, ajaxOptions))
            .done(function(data) {
                responseHandler("success", data, mes.success);
                fixed(options, data);
            })
            .fail(function(err) {
                responseHandler("error", err, mes.error);
            });
    }

    // 函数拓展
    const Function = [{
        name: "search",
        mes: {
            success: "!",
            error: "!"
        }
    }];

    // 暴露的接口
    let self = {
        load: function(options) {
            const mes = {
                success: "加载数据成功!",
                error: "加载数据失败!"
            };
            ajax(options, mes);
            return this;
        }
    }

    Function.forEach(function(item) {
        self[item.name] = function(options) {
            ajax(options, item.mes);
            return self;
        }
    });
    return self;
})();

let Spider = (function() {
    // 维护本地爬虫列表
    const Spider = [];
    // 路由
    const Router = [{
            url: '/spider/get'
        },
        {
            url: '/spider/create'
        },
        {
            url: '/spider/delete'
        },
        {
            url: '/spider/update'
        }
    ];
    const Page = {
        name: 'Spider',
        init: false,
        page: 1,
        step: 15,
        max: function() {
            return Math.ceil(Spider.length / Page.step);
        },
        previous: function() {
            $(`#${this.name}_previous`).click(function() {
                if (Page.page <= 1) {
                    console.log("previous");
                    return;
                }
                Page.page--;
                Page.fixed();
            });
        },
        next: function() {
            $(`#${this.name}_next`).click(function() {
                if (Page.page >= Page.max()) {
                    console.log("next");
                    return;
                }
                Page.page++;
                Page.fixed();
            });
        },
        fixed: function() {
            let root = $('#Spider');
            let tbody = root.children('tbody');
            let dom = '';
            for (let i = (this.page - 1) * this.step; i < Spider.length && i < this.page * this.step; i++) {
                dom +=
                    ` <tr>
                <td>${i+1}</td>
                <td>${Spider[i].name}</td>
                <td>${Spider[i].url}</td>
                <td>${Spider[i].time}</td>
                <td>
                    <button type="button" class="btn  btn-primary" data-submit="Spiderupdate"><i class="fa fa-edit"></i></button>
                </td>
                <td>
                    <button type="button" class="btn  btn-danger " data-submit="Spiderdelete"><i class="fa fa-remove "></i></button>
                </td>
            </tr>
	    		`;
            }
            tbody.html(dom);
            let info = `第 <span class="label label-info">${this.page}</span> 页,共 <span class="label label-info">${this.max()}</span>页, 每页 <span class="label label-info">${this.step}</span> 项 , 共 <span class="label label-info">${Spider.length}</span>项`;

            if (!this.init) {
                let foot = `
				<div class="dataTables_info" id="${this.name}_info" role="status" aria-live="polite">${info}</div>
		    	 <div class="dataTables_paginate pull-right paging_simple_numbers" id="${this.name}_paginate">
		            <ul class="pagination">
		                <li class="paginate_button previous" id="${this.name}_previous"><a href="javascript:void(0)" aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a></li>
		                <li class="paginate_button next" id="${this.name}_next"><a href="javascript:void(0)" aria-controls="example1" data-dt-idx="7" tabindex="0">Next</a></li>
		            </ul>
		        </div>`;
                root.parent().parent().append(foot);
                this.previous();
                this.next();
                this.init = true;
            }
            $(`#${this.name}_info`).html(info);
            fixedDom();
        }

    }

    // dom 
    const Dom = {
        Add: $('button[data-submit=Spideradd]'),
        Update: $('button[data-submit=Spiderupdate]'),
        Delete: $('button[data-submit=Spiderdelete]')
    };

    //	 添加爬虫
    (function Add() {
        Dom.Add.click(function() {
            let inputs = $('#newSpider .box-body input');
            //如果有空的输入值
            if (![].every.call(inputs, function(input) {
                    return input.value != '';
                })) {
                myalert('warning', "尚未填完表格!");
                return;
            }
            const data = {
                name: inputs[0].value,
                url: inputs[1].value,
                title1: inputs[2].value,
                url1: inputs[3].value,
                title2: inputs[4].value,
                url2: inputs[5].value
            };
            const options = {
                url: '/spider/create',
                data: data
            };
            self.add(options);
        });
    })();

    function Update() {
        // 更新爬虫
        Dom.Update.each(function(index, element) {
            $(element).click(function() {
                const _this = $(this);
                const tr = _this.parent().parent();
                const td = tr.children('td:eq(1)');
                const index = tr.index();
                const base = td.text();
                _this.removeClass('btn-success');
                if (_this.hasClass('btn-primary')) {
                    _this.addClass('btn-success');
                    _this.removeClass('btn-primary');
                    _this.html("<i class='fa fa-save'></i>");
                    td.html(`<input type="text" value=${base}>`);
                } else {
                    _this.addClass('btn-primary');
                    _this.html("<i class='fa fa-edit'></i>");
                    let name = td.children('input').val();
                    console.log(name);
                    td.html(base);
                    if (name == base) {
                        return;
                    } else {
                        const options = {
                            url: '/spider/update',
                            data: {
                                name: name,
                                index: index
                            }
                        };
                        self.update(options);
                    }
                }
            });
        });
    }

    function Delete() {
        // 删除爬虫
        Dom.Delete.each(function(index, element) {
            $(element).click(function() {
                const tr = $(this).parent().parent();
                const index = tr.index();
                const name = tr.children('td:eq(1)');
                const options = {
                    url: '/spider/delete',
                    data: {
                        name: name.text(),
                        index: index
                    }
                };
                self.delete(options);
            });
        })
    }

    function fixedDom() {
        Dom.Delete = $('button[data-submit=Spiderdelete]');
        Dom.Update = $('button[data-submit=Spiderupdate]');
        Update();
        Delete();
    }

    // 实时更新本地列表,调整页面
    function fixed(options, data) {

        Router[0].resolve = function() {

            data.result.forEach(function(item) {
                Spider.push(item);
            });
            Page.fixed();
        };
        Router[1].resolve = function() {

            let d = new Date();

            let month = d.getMonth() + 1;
            month =  month  >= 10? month :  '0' + month;

            let day = d.getDate() >= 10? d.getDate() : '0' + d.getDate();

            let date = d.getFullYear() + '-' + month + '-' + day;

            const item = {
                name: options.data.name,
                url: options.data.url,
                time: date
            };

            Spider.push(item);
            Page.fixed();
        };
        Router[2].resolve = function() {
            Spider.splice(options.data.index, 1);
            Page.fixed();
        };
        Router[3].resolve = function() {
            Spider[options.data.index].name = options.data.name;
            Page.fixed();
        };

        for (let i = 0; i < Router.length; i++) {

            if (Router[i].url === options.url) {
                Router[i].resolve();
                break;
            }
        }
    }

    function ajax(options, mes) {

        $.ajax($.extend(options, ajaxOptions))
            .done(function(data) {
                responseHandler("success", data, mes.success);
                fixed(options, data);
            })
            .fail(function(err) {
                responseHandler("error", err, mes.error);
            });
    }
    const Function = [{
            name: "add",
            mes: {
                success: "添加成功!",
                error: "爬虫名重复!"
            }
        },
        {
            name: "update",
            mes: {
                success: "更新成功!",
                error: "爬虫名重复!"
            }
        },
        {
            name: "delete",
            mes: {
                success: "删除成功!",
                error: "爬虫名不存在!"
            }
        }
    ];
    let self = {
        // 可以链式调用
        //  加载数据
        load: function(options) {
            const mes = {
                success: "加载爬虫数据成功!",
                error: "加载爬虫数据失败!"
            };
            ajax(options, mes);
            return this;
        }
    }

    Function.forEach(function(item) {
        self[item.name] = function(options) {
            ajax(options, item.mes);
            return self;
        }
    });
    return self;
})();

let People = (function() {
    // 维护本地爬虫列表
    const People = [];
    // 路由
    const Router = [{
            url: '/contact/get'
        },
        {
            url: '/contact/add'
        },
        {
            url: '/contact/delete'
        }
    ];
    const Page = {
        name: 'People',
        init: false,
        page: 1,
        step: 15,
        max: function() {
            return Math.ceil(People.length / Page.step);
        },
        previous: function() {
            $(`#${this.name}_previous`).click(function() {
                if (Page.page <= 1) {
                    console.log("previous");
                    return;
                }
                Page.page--;
                Page.fixed();
            });
        },
        next: function() {
            $(`#${this.name}_next`).click(function() {
                if (Page.page >= Page.max()) {
                    console.log("next");
                    return;
                }
                Page.page++;
                Page.fixed();
            });
        },
        fixed: function() {
            let root = $('#People');
            let tbody = root.children('tbody');
            let dom = '';
            for (let i = (this.page - 1) * this.step; i < People.length && i < this.page * this.step; i++) {
                dom +=
                    ` <tr>
                <td>${i+1}</td>
                <td>${People[i].name}</td>
                <td>${People[i].mail}</td>
                <td>
                    <button type="button" class="btn  btn-danger " data-submit="Peopledelete"><i class="fa fa-remove "></i></button>
                </td>
            </tr>
	    		`;
            }
            tbody.html(dom);
            let info = `第 <span class="label label-info">${this.page}</span> 页,共 <span class="label label-info">${this.max()}</span>页, 每页 <span class="label label-info">${this.step}</span> 项 , 共 <span class="label label-info">${People.length}</span>项`;

            if (!this.init) {
                let foot = `
				<div class="dataTables_info" id="${this.name}_info" role="status" aria-live="polite">${info}</div>
		    	 <div class="dataTables_paginate pull-right paging_simple_numbers" id="${this.name}_paginate">
		            <ul class="pagination">
		                <li class="paginate_button previous" id="${this.name}_previous"><a href="javascript:void(0)" aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a></li>
		                <li class="paginate_button next" id="${this.name}_next"><a href="javascript:void(0)" aria-controls="example1" data-dt-idx="7" tabindex="0">Next</a></li>
		            </ul>
		        </div>`;
                root.parent().parent().append(foot);
                this.previous();
                this.next();
                this.init = true;
            }
            $(`#${this.name}_info`).html(info);
            fixedDom();
        }
    }

    // dom 
    const Dom = {
        Add: $('button[data-submit=Peopleadd]'),
        Delete: $('button[data-submit=Peopledelete]'),
        Save: $('button[data-submit=Peoplesave]')
    };

    //	 添加
    Dom.Add.click(function() {
        let root = $('#People');
        let tbody = root.children('tbody');
        if (tbody.children('tr').length > People.length + 1) return;
        let dom = ` <tr>
        <td>${ People.length+1 }</td>
        <td><input type="text" placeholder="联系人"></td>
        <td><input type="text" placeholder="邮箱"></td>
        <td><button class="btn btn-success " data-submit="Peoplesave">
            <i class="fa fa-save"></i>
        </button></td>
    	</tr>`;
        tbody.append(dom);
        fixedDom();
    });

    // 添加
    function Add() {

        Dom.Save.click(function() {
            console.log('click');
            const tr = $(this).parent().parent();
            const inputs = tr.children('td').has('input').children('input');
            if (inputs[0].value == '' || inputs[1].value == '') {
                myalert('error', '表格不能为空!');
                return;
            }
            const options = {
                url: '/contact/add',
                data: {
                    name: inputs[0].value,
                    mail: inputs[1].value
                }
            };
            inputs.each(function(index, element) {
                element.value = "";
            });

            self.add(options);
        });
    }

    function Delete() {
        // 删除
        Dom.Delete.each(function(index, element) {
            $(element).click(function() {
                const tr = $(this).parent().parent();
                const index = tr.index();
                const name = tr.children('td:eq(1)');
                const options = {
                    url: '/contact/delete',
                    data: {
                        name: name.text(),
                        index: index
                    }
                };
                self.delete(options);
            });
        })
    }

    function fixedDom() {
        Dom.Delete = $('button[data-submit=Peopledelete]');
        Dom.Save = $('button[data-submit=Peoplesave]');
        Delete();
        Add();

    }

    // 实时更新本地列表,调整页面
    function fixed(options, data) {
        // 根据路由来处理页面 

        Router[0].resolve = function() {

            data.result.forEach(function(item) {
                People.push(item);
            });
            Page.fixed();
        };
        Router[1].resolve = function() {
            const item = {
                name: options.data.name,
                mail: options.data.mail,
            };
            People.push(item);
            Page.fixed();
        };
        Router[2].resolve = function() {
            People.splice(options.data.index - 1, 1);
            Page.fixed();
        };

        for (let i = 0; i < Router.length; i++) {

            if (Router[i].url === options.url) {
                Router[i].resolve();
                break;
            }
        }
    }

    function ajax(options, mes) {

        $.ajax($.extend(options, ajaxOptions))
            .done(function(data) {
                responseHandler("success", data, mes.success);
                fixed(options, data);
            })
            .fail(function(err) {
                responseHandler("error", err, mes.error);
            });
    }
    const Function = [{
            name: "add",
            mes: {
                success: "添加成功!",
                error: "联系人重复!"
            }
        },
        {
            name: "delete",
            mes: {
                success: "删除成功!",
                error: "联系人不存在!"
            }
        }
    ];
    let self = {
        // 可以链式调用
        //  加载数据
        load: function(options) {
            const mes = {
                success: "加载数据成功!",
                error: "加载联系人失败!"
            };
            ajax(options, mes);
            return this;
        }
    }

    Function.forEach(function(item) {
        self[item.name] = function(options) {
            ajax(options, item.mes);
            return self;
        }
    });
    return self;
})();

// 页面切换
$(function() {
    //侧边导航和内容的切换
    $('.aside').click(function() {
        let _this = $(this);
        let index = _this.index();

        // 侧栏增加样式
        _this.addClass('active')
            .siblings().removeClass('active');
        // 主栏切换
        let content = $('.content');
        let div = content.children(`div:eq(${index-1})`);
        div.show()
            .siblings().hide();
    });

    $('.newSpider').click(function() {
        $('.content>div:eq(1)').toggle();
        $('#newSpider').toggle();
    });
})

$(function() {

    (function() {
        const options = {
            url: '/spider/get',
            data: {
                pageNum: 1,
                pageSize: 1000
            }
        }
        Spider.load(options);
    })();

    (function() {
        const options = {
            url: '/contact/get',
            data: {
                pageNum: 1,
                pageSize: 1000
            }
        }
        People.load(options);
    })();

    (function() {
        const options = {
            url: '/data/get',
            data: {
                pageNum: 1,
                pageSize: 1000
            }
        }
        Data.load(options);
    })();

})

// 辅助工具
//alert
function myalert(status, mes) {

    let dom = $('.alert');

    if (dom) {
        // 先清除已经有的alert
        dom.children('button').click();
    }

    if (status == "success") {
        dom = `<section class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4><i class="icon fa fa-check"></i>${mes}</h4>
              </section>`;
    } else {
        dom = `<section class="alert alert-warning alert-dismissible">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <h4><i class="icon fa fa-warning"></i>${mes}</h4>
      </section>`;
    }

    $(dom).prependTo('.content');
}

// 处理页面反馈
function responseHandler(status, data, mes = "操作成功！") {
    if (status == 'success') {
        //console.log(data);
        // 无code 
        if (!data.code) {
            myalert('success', mes);
            return;
        }
        // 只有code
        if (data.code == '10') {
            myalert('success', mes);
        } else {
            myalert('error', mes);
        }

    } else if (status == 'error') {
        myalert('error', '网络错误');
        console.log(data);
    } else {
        console.log("未捕捉");
    }
}