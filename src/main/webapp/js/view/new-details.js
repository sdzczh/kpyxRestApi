

$(function () {

    $.get(URL + '/article/' + regLocation('id'), function (res) {
        var res = JSON.parse(res)
        if (res.code == 10000) {
            $('#title').html(res.data.title)
            $('#author').html(res.data.author)
            $('#date').html(moment(res.data.createTime).format('YYYY-MM-DD hh:mm:ss'))
            $('#count').html(res.data.clinkNum)
            $('#content').html($('#content').html(res.data.content).text())
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