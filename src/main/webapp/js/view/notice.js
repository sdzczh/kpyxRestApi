

getList(location.hash.replace('#!page=', ''))

function getList(page) {
    $.get(URL + '/article/drawNotice', {
        page: page,
        rows: 10
    }, function (res) {
        var res = JSON.parse(res)
        if(res.code == 10000) {
            var html = ''
            res.data.data.forEach(function (item, index) {
                html += '<li>\
                            <a href="./notice-details.html?number=' + item.number + '&id=' + item.id + '&type=' + item.type + '">' + item.title + '</a>\
                            <p><span>发布：' + item.author + '</span><span>时间：' + moment(item.updateTime).format('YYYY-MM-DD') + '</span><span>浏览量：' + item.clinkNum +'</span></p>\
                        </li>'
            })
            $('#new-list').html(html)

            // 分页
            layui.use('laypage', function () {
                layui.laypage.render({
                    elem: 'pagination',
                    count: res.data.count,
                    curr: location.hash.replace('#!page=', ''),
                    theme: 'sp-laypage',
                    hash: 'page',
                    jump: function(obj, first){
                        if(!first){
                            getList(obj.curr)
                        }
                      }
                })
            })
        }
    })
}

$(function () {
    $.get(URL + '/article/recommendList', function (res) {
        var res = JSON.parse(res)
        if(res.code == 10000) {
            var html = ''
            res.data.forEach(function (item, index) {
                html += '<li class="hairline--bottom"><a href="/new-details.html?id=' + item.id + '">' + item.title + '</a></li>'
            })
            $('#recommend-list').html(html)
        }
    })
})