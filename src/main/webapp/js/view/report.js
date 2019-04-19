
$(function () {
    // 初始化验证码
    initVaidateCode()

    $('#file').on('change', function () {
        var fd = new FormData()
        fd.append('file', $(this)[0].files[0])
        $(this).val('')
        $.ajax({  
            url: URL + '/file/upload',  
            type: 'post',
            data: fd,
            processData:false,
            contentType:false,
            success : function(res) {
                var res = JSON.parse(res)
                if(res.code == 10000) {
                    var html = '<div class="col-sm-4 mt10 col-xs-6 mt-npl mt-xs-npl upload-file-img">\
                                    <img data-upload-img src="' + res.data.url + '" alt="">\
                                    <span class="upload-file-delete">x</span>\
                                </div>'
                    $('#upload-file').hide()
                    $('#upload-file').before(html)
                } else {
                    layer.msg(res.msg)
                }
            }
       })
    })


    $('#upload').on('click', '.upload-file-delete', function () {
        $(this).closest('.upload-file-img').remove()
        $('#upload-file').show()
    })
})

layui.use('form', function () {
    var form = layui.form
    form.on('submit(report)', function (data) {
        
        var code = data.field.code
        delete data.field.code
        data.field.img_url = $('[data-upload-img]').attr('src')
        $.get(URL + '/report/insert', {
            data: btoa(JSON.stringify(data.field)),
            code: code,
            time: $('[data-validate-code="1"]').attr('time')
        }, function (res) {
            var res = JSON.parse(res)
            if (res.code == 10000) {
                layer.msg('举报成功')
                $('#report-form')[0].reset()
                $('#upload-file').show().siblings().remove()
                refreshVaidateCode('[data-validate-code="1"]', new Date().getTime())
            } else {
                layer.msg(res.msg)
            }
        })

        return false
    })
})