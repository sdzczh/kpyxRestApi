

var aes_iv = 'xpLbp7JdqU49LJuz'
var rsa_public_key = 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrxmafQwygjv/X8Bt\
KmAdMQi0Tl5NkUiF1+bnOxnyH6PaozW1PVMANGZNGkD9e+g58ucHEJSG\
6MHUBwhlgpHjsUa1+uobU/zQQkmY0C+rEC0sxK+3OUF+hbawoKJXzxlWS\
O6P3Txdu98t3myuL9EEg8lIpIhk3L+dm94M9/CMCkwIDAQAB'

var rsaencrypt = new JSEncrypt()
rsaencrypt.setPublicKey(rsa_public_key)

var aes_key = getAesKey()

var number = ''

var candidateList = [], luckyDogList = {}

var time = null //定时器

layui.use('form', function () {
    var form = layui.form

    form.verify({
        lucky: function (value) {
            if (!value) {
                return '请先选择奖项在开奖哦~'
            }
        }
    })

    form.on('select(type)', function(data){
        if(luckyDogList[data.value]) {
            changeClass(luckyDogList[data.value].length)
            $('#startRaffle').attr('disabled', true)
            renderLuckyDog()
        } else {
            $('#startRaffle').attr('disabled', false)
        }
    })

    form.on('submit(lucky)', function (data) {
        var index = data.field.type * 1

        var map = {
            amount: LUCKYLIST[index].num,
            number: number,
            type: LUCKYLIST[index].type
        }

        log(map)

        startRaffle({
            params: aesEncrypt(JSON.stringify(map)).toString(),
            secret_key: rsaencrypt.encrypt(aes_key)
        }, LUCKYLIST[index].type)

        loadingRaffle(LUCKYLIST[index].num)

        return false
    })

})

$(function () {
    renderSelect()

    $.get(URL + '/prize/getNumber', function (res) {
        var res = JSON.parse(res)
        if (res.code == 10000) {
            res.data.number = 1
            number = res.data.number
            $.get(URL + '/selection/getSelectList', {
                number: number
            }, function (res) {
                var res = JSON.parse(res)
                if (res.code == 10000) {
                    candidateList = res.data.list
                }
            })
        }
    })

    $('#endRaffle').click(function () {
        endRaffle()
    })
})

function startRaffle(data, key) {

    $('#startRaffle').attr('disabled', true)
    $('#endRaffle').attr('disabled', false)

    $.post(URL + '/prize/draw', data, function (res) {
        if (typeof res == 'string') {
            res = JSON.parse(res)
        }
        if (res.code == 10000) {
            luckyDogList[key] = res.data
        } else {
            layer.msg(res.msg)
        }
    })
}

function endRaffle() {

    $('#startRaffle').attr('disabled', false)
    $('#endRaffle').attr('disabled', true)

    clearInterval(time)

    renderLuckyDog()
}

function loadingRaffle(length) {

    changeClass(length)

    time = setInterval(function () {
        var html = ''
        for (var i = 0; i < length; i++) {
            html += '<li>' + randomItem() + '</li>'
        }
        $('#lucky-dog-list').html(html)
    }, 20)
}

function changeClass(length) {
    if (length > 5) {
        $('#lucky-dog-list').attr('class', 'lucky-dog-type2')
    } else {
        $('#lucky-dog-list').attr('class', 'lucky-dog-type1')
    }
}

function renderLuckyDog() {
    var html = ''
    luckyDogList[$('#lucky-select').val()].forEach(function (item) {
        html += '<li>' + item.invoiceId + '</li>'
    })
    $('#lucky-dog-list').html(html)
}

function randomItem() {
    var index = Math.floor((Math.random() * candidateList.length));
    return candidateList[index]
}

function renderSelect() {
    var list = LUCKYLIST.slice(0, 10)

    var html = ''
    list.forEach(function (item) {
        html += '<option value="' + item.type + '">' + item.title + '' + item.num + '名，奖金' + item.prize + '元</option>'
    })

    $('#lucky-select').append(html)
}

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

// 解密
function aesDecrypt(ciphertext) {
    var key = CryptoJS.enc.Latin1.parse(aes_key),
        iv = CryptoJS.enc.Latin1.parse(aes_iv)

    var decrypted = CryptoJS.AES.decrypt(ciphertext, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC
    })
    return decrypted.toString(CryptoJS.enc.Utf8)
}

function getAesKey() {
    var key = localStorage.getItem('aes_key')
    if (!key) {
        key = CryptoJS.lib.WordArray.random(8).toString(CryptoJS.enc.Hex)
        localStorage.setItem('aes_key', key)
    }
    return key
}