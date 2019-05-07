

var type = regLocation('type')

$(function () {

    type && initPage(type)

    $.get(URL + '/article/' + regLocation('id'), function (res) {
        var res = JSON.parse(res)
        if (res.code == 10000) {
            $('#title').html(res.data.title)
            $('#author').html(res.data.author)
            $('#date').html(moment(res.data.createTime).format('YYYY-MM-DD hh:mm:ss'))
            $('#count').html(res.data.clinkNum)
            $('#content').html($('#content').html(res.data.content).text())

            initPage(res.data.type)

        }
    })

    $.get(URL + '/article/recommendList', function (res) {
        var res = JSON.parse(res)
        if (res.code == 10000) {
            var html = ''
            res.data.forEach(function (item, index) {
                html += '<li class="hairline--bottom"><a href="/new-details.html?id=' + item.id + '">' + item.title + '</a></li>'
            })
            $('#recommend-list').html(html)

        }
    })
})


function initPage(type) {

    switch(type) {
        case 0: 
            type = 0
            break
        case 1: 
            type = 1
            break
        case 2: 
            type = 2
            break
        case 3: 
            type = 3
            break
        case 4: 
            type = 0
            break
        case 5: 
            type = 0
            break
    }

    var ele = $('[data-type=' + type + ']')
    ele.addClass('active')
    $('[data-breadcrumb-active]').html(ele.find('a').html())
}