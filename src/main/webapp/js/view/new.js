

var type = regLocation('type')


$(function () {

    initPage(type)

    getList(location.hash.replace('#!page=', ''))

    getRecommendList()
})


function getList(page) {
    $.get(URL + '/article/list', {
        type: type,
        page: page
    }, function (res) {
        var res = JSON.parse(res)
        if(res.code == 10000) {
            var html = ''
            res.data.data.forEach(function (item, index) {
                html += '<li>\
                            <a href="./new-details.html?id=' + item.id + '">' + item.title + '</a>\
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

function getRecommendList() {
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
}

function initPage(type) {
    var ele = $('[data-type=' + type + ']')
    ele.addClass('active')
    $('[data-breadcrumb-active]').html(ele.find('a').html())
}