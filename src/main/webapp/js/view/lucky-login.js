
    

var aes_iv = 'xpLbp7JdqU49LJuz'
var rsa_public_key = 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrxmafQwygjv/X8Bt\
KmAdMQi0Tl5NkUiF1+bnOxnyH6PaozW1PVMANGZNGkD9e+g58ucHEJSG\
6MHUBwhlgpHjsUa1+uobU/zQQkmY0C+rEC0sxK+3OUF+hbawoKJXzxlWS\
O6P3Txdu98t3myuL9EEg8lIpIhk3L+dm94M9/CMCkwIDAQAB'

var rsaencrypt = new JSEncrypt()
rsaencrypt.setPublicKey(rsa_public_key)

var aes_key = getAesKey()

layui.use('form', function () {
    
    var form = layui.form

    form.on('submit(login)', function (data) {

        var index = layer.load(0, {shade: false})

        $('#submit').attr('disabled', true)

        log(data.field)
        $.post(URL + '/login/admin', 
        {
            params: aesEncrypt(JSON.stringify(data.field)).toString(),
            secret_key: rsaencrypt.encrypt(aes_key)
        }, function (res) {
            if (typeof res == 'string') {
                res = JSON.parse(res)
            }
            if (res.code == 10000) {
                sessionStorage.setItem('userId', res.data.userId)
                sessionStorage.setItem('token', res.data.token)
                location.replace('/lucky.html')
            } else {
                layer.msg(res.msg)
            }
            $('#submit').attr('disabled', false)
            layer.close(index)
        })

        return false
    })

})


// 加密
function aesEncrypt(message) {
    var key = CryptoJS.enc.Latin1.parse(aes_key),
        iv = CryptoJS.enc.Latin1.parse(aes_iv)
    var ciphertext = CryptoJS.AES.encrypt(message, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC
    })
    return ciphertext
}

function getAesKey() {
    var key = localStorage.getItem('aes_key')
    if (!key) {
        key = CryptoJS.lib.WordArray.random(8).toString(CryptoJS.enc.Hex)
        localStorage.setItem('aes_key', key)
    }
    return key
}