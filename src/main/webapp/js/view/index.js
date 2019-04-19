
$(function () {

    $('#video').attr('width', $('#sp-index-video-wrap').width())
    videojs('video').ready(function () {
        this.play()
    });

    $.get(URL + '/index', function (res) {
        var res = JSON.parse(res)
        if (res.code == 10000) {
            var data = res.data
            renderVideo('#video', data.videos)
            renderBanner('#carousel-banner', data.topBanner)
            renderBanner('#carousel-mid-banner', data.topBanner)
            renderList('#problem', data.cjwtList)
            renderList('#notify', data.tzggList)
            renderList('#policies', data.zcfgList)
            renderList('#news', data.xwzxList)
            noticeList('#notice', data.kjggList)
        }
    })

    // 初始化验证码
    initVaidateCode()

    // 初始化公告
    setInterval(
        function () {
            $('#notice').animate({ marginTop: '-49px' }, function () {
                $(this).css({ marginTop: "0" }).find(":first").appendTo(this);
            })
        }
        , 2000)

})


// 发票录入
layui.use('form', function () {
    var form = layui.form
    form.on('submit(invoice)', function (data) {
        var code = data.field.code
        delete data.field.code
        $.get(URL + '/invoice/insert', {
            data: btoa(JSON.stringify([data.field])),
            code: code,
            time: $('[data-validate-code="1"]').attr('time')
        }, function (res) {
            var res = JSON.parse(res)
            if (res.code == 10000) {
                layer.msg('录入成功')
                $('#invoice-form')[0].reset()
                refreshVaidateCode('[data-validate-code="1"]', new Date().getTime())
            } else {
                layer.msg(res.msg)
            }
        })
        return false
    })
})

function renderVideo(ele, data) {
    $(ele).attr('poster', data.imgUrl).find('source').attr('src', data.videoUrl)
}

// top banner
function renderBanner(ele, data) {
    var indicatorsHtml = ''
    var innerHtml = ''
    data.forEach(function (item, index) {
        indicatorsHtml += '<li data-target="' + ele + '" data-slide-to="' + index + '" class="' + (index == 0 && "active") + '"></li>'
        innerHtml += '<div class="item ' + (index == 0 && "active") + '">\
                            <a href="' + item.href + '"><img class="carousel-img" src="' + item.imgUrl + '" alt="..."></a>\
                            <div class="carousel-caption">\
                                <span>' + item.title + '</span>\
                            </div>\
                        </div>'
    })
    $(ele).find('.carousel-indicators').html(indicatorsHtml)
    $(ele).find('.carousel-inner').html(innerHtml)
}

// 中奖公告
function noticeList(ele, data) {
    var html = ''
    data.forEach(function (item, index) {
        html += '<li>\
                    <a class="notice-li ellipsis" href="/notice-details.html?id=' + item.id + '&type=0&number=' + item.number + '" target="_self">' + item.title + '<span>' + moment(item.updateTime).format('YYYY-MM-DD') + '</span>\
                    </a>\
                </li>'
    })
    $(ele).html(html)
}

// 渲染列表
function renderList(ele, data) {
    var html = ''
    data.forEach(function (item, index) {
        html += '<li>\
                    <a class="clearfix ellipsis" href="/new-details.html?id=' + item.id + '" target="_self">' + item.title + '<span>' + moment(item.updateTime).format('YYYY-MM-DD') + '</span>\
                    </a>\
                </li>'
    })
    $(ele).html(html)
}
