var URL = '';

var LUCKYLIST = [
    {
        type: 0,
        title: '场内特等奖',
        num: 1,
        prize: 50000
    },
    {
        type: 1,
        title: '场内一等奖',
        num: 1,
        prize: 6000
    },
    {
        type: 2,
        title: '场内二等奖',
        num: 1,
        prize: 4000
    },
    {
        type: 3,
        title: '场内三等奖',
        num: 1,
        prize: 2000
    },
    {
        type: 4,
        title: '场内四等奖',
        num: 1,
        prize: 1000
    },
    {
        type: 5,
        title: '场内四等奖',
        num: 2,
        prize: 800
    },
    {
        type: 6,
        title: '场内四等奖',
        num: 3,
        prize: 600
    },
    {
        type: 7,
        title: '场内四等奖',
        num: 4,
        prize: 100
    },
    {
        type: 8,
        title: '场内幸运奖',
        num: 3,
        prize: 1000
    },
    {
        type: 9,
        title: '场内入围奖',
        num: 50,
        prize: 100
    },
    {
        type: 10,
        title: '场外一等奖',
        num: 1,
        prize: 6000
    },
    {
        type: 11,
        title: '场外二等奖',
        num: 1,
        prize: 4000
    },
    {
        type: 12,
        title: '场外三等奖',
        num: 1,
        prize: 2000
    },
    {
        type: 13,
        title: '场外参与奖',
        num: 60,
        prize: 100
    },
]

window.log = console.log

function regLocation(str) {
    var reg = new RegExp('(^|&|[?])' + str + '=([^&]*)(&|$)')
    var r = window.location.search.match(reg)
    var value = ''
    if (r) {
      value = unescape(r[2])
    }
    return value
}

// 图片验证码
function initVaidateCode() {
    refreshVaidateCode('[data-validate-code]', new Date().getTime())
    $('[data-code-refresh]').click(function () {
        var id = $(this).attr('data-code-refresh')
        refreshVaidateCode('[data-validate-code=' + id + ']', new Date().getTime())
    })
}

function refreshVaidateCode(ele, time) {
    $(ele).attr({
        src: URL + '/validateCode?time=' + time,
        time: time
    })
}

$(function () {
    $.get(URL + '/index/friendshipLink', function (res) {
        var res = JSON.parse(res)
        if(res.code == 10000) {
            var html = ''
            res.data.forEach(function (item, index) {
                html += '<li class="pull-left"><a href="' +  item.href + '" target="_blank">' + item.title + '</a></li>'
            })
            $('#friend-ship').append(html)
        }
    })
})