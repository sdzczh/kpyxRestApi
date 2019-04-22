$(function () {
    if(regLocation('type') == 0) {
        // 开奖
        renderPrizeList()
    } else if (regLocation('type') == 5) {
        // 入围
        renderSelectionList()
    }


    $.get(URL + '/article/' + regLocation('id'), function (res) {
        var res = JSON.parse(res)
        if (res.code == 10000) {
            $('#title').html(res.data.title)
            $('#author').html(res.data.author)
            $('#date').html(moment(res.data.createTime).format('YYYY-MM-DD hh:mm:ss'))
            $('#count').html(res.data.clinkNum)
            $('#content').html(res.data.content)
        }
    })

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

function renderPrizeList() {
    $.get(URL + '/prize/list', {
        number: regLocation('number')
    }, function (res) {
        var res = JSON .parse(res)
        if (res.code == 10000) {
            var html = ''
            res.data.forEach(function(item, index) {
                var o = LUCKYLIST[item.type]
                html += '<tr>\
                            <td>' + o.title + o.prize + '元</td>\
                            <td>' + item.invoice_id + '</td>\
                        </tr>'
            })
            $('#roster-table').html(html)
            $('#roster-thead').html('<th>奖项</th><th>发票号码</th>')
        }
    })
}

function renderSelectionList() {
    $.get(URL + '/selection/list', {
        number: regLocation('number')
    }, function (res) {
        var res = JSON .parse(res)
        if (res.code == 10000) {
            var html = ''
            res.data.forEach(function(item, index) {
                html += '<tr>\
                            <td>' + item.invoice_code + '</td>\
                            <td>' + item.invoice_id + '</td>\
                        </tr>'
            })
            $('#roster-table').html(html)
            $('#roster-thead').html('<th>发票代码</th><th>发票号码</th>')
        }
    })
}