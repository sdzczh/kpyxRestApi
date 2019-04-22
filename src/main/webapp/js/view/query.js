
$(function () {

    $('[data-index]').click(function () {
        var index = $(this).attr('data-index')
        $('[data-index]').removeClass('active')
        $(this).addClass('active')
        $('[data-tabs]').hide()
        $('[data-tabs=' + index +']').show()
    })

    initVaidateCode()
})


layui.use('form', function () {
    var form = layui.form
    form.on('submit(phone)', function (data) {
        data.field.time = $('[data-validate-code="1"]').attr('time')
        $.get(URL + '/prize/queryPrize', data.field, function (res) {
            var res = JSON.parse(res)
            if (res.code == 10000) {
                $('#query-form-phone')[0].reset()
                successCallback(res.data)
            } else {
                layer.msg(res.msg)
            }
        })
        return false
    })

    form.on('submit(code)', function (data) {
        data.field.time = $('[data-validate-code="1"]').attr('time')
        $.get(URL + '/prize/queryPrize', data.field, function (res) {
            var res = JSON.parse(res)
            if (res.code == 10000) {
                $('#query-form-code')[0].reset()
                successCallback(res.data)
            } else {
                layer.msg(res.msg)
            }
        })
        return false
    })
})


function successCallback(data) {
    refreshVaidateCode('[data-validate-code="1"]', new Date().getTime())
    var html = ''
    data.forEach(function (item, index) {
        html += '<p>恭喜您中了第' + item.number + '期' + LUCKYLIST[item.type].title + LUCKYLIST[item.type].prize +'元， 中奖发票代码是' + item.invoice_code + '</p>'
    })
    $('#query-list').html(html)
    layer.open({
        type: 1,
        shade: false,
        title: false,
        area: ['500px', '300px'],
        content: $('.layer_notice')
    })
}
