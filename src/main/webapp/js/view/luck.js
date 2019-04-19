
$(function () {

    var number

    $.get(URL + '/prize/getNumber', function (res) {
        var res = JSON.parse(res)
        if(res.code == 10000) {
            number = res.data.number
        }
    })
    
})
