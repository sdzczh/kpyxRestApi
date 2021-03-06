

var laydate

// 添加
$('#btn-add').click(function () {
  var id = $('#form-copy').find('[data-id]').attr('data-id') * 1
  $('#form-once').before($('#form-copy').html())
  $('#form-copy').find('[data-id]').attr('data-id', id + 1)
  $('#form-copy').find('[data-btn-id]').attr('data-btn-id', id + 1)
  $('#form-copy').find('[data-indx]').attr('data-indx', id + 1)
  $('#form-copy').find('[data-create_date]').attr('data-create_date', id + 1)
  initDate(id)
})

// 删除
$('#ine-form').on('click', '[data-btn-id]', function () {
  var id = $(this).attr('data-btn-id')
  $('[data-id=' + id + ']').remove()
})


layui.use('laydate', function () {
  laydate = layui.laydate;

  initDate(0)
})

// 发票录入
layui.use('form', function () {
  var form = layui.form

  form.verify({
    invoiceCode: function (value) {
      if (!new RegExp(/^(\d{10}|\d{12})$/).test(value)) {
        return '请输入10位或12位发票代码'
      }
    },
    invoiceId: function (value) {
      if (!new RegExp(/^(\d{8})$/).test(value)) {
        return '请输入8位发票号码'
      }
    },
    amount: function (value) {
        if (!value || isNaN(value)) {
            return '请正确输入金额'
        } else if (value < 100) {
            return '金额必须大于100'
        }
    }
  })


  form.on('submit(invoice)', function (data) {
    var code = data.field.code
    var list = []
    $('[data-id]').each(function (index, ele) {
      if ($(ele).find('[name="invoice_code"]').val()) {
        list.push({
          amount: $(ele).find('[name="amount"]').val(),
          id_card_num: data.field.id_card_num,
          invoice_code: $(ele).find('[name="invoice_code"]').val(),
          invoice_id: $(ele).find('[name="invoice_id"]').val(),
          create_date: $(ele).find('[name="create_date"]').val(),
          phone: data.field.phone,
        })
      }
    })
    $.get(URL + '/invoice/insert', {
      data: btoa(unescape(encodeURIComponent(JSON.stringify(list)))),
      code: code,
      time: $('[data-validate-code="1"]').attr('time')
    }, function (res) {
      var res = JSON.parse(res)
      if (res.code == 10000) {
        layer.msg('录入成功')
        $('#ine-form')[0].reset()
        refreshVaidateCode('[data-validate-code="1"]', new Date().getTime())
      } else {
        initVaidateCode()
        layer.msg(res.msg)
      }
    })
    return false
  })
})

// 初始化验证码
initVaidateCode()

// 初始化日期

function initDate(index) {
  $('[data-create_date="' + index + '"]').attr('id', 'create_date' + index)
  laydate.render({
    elem: '#create_date' + index,
    max: moment(new Date()).format('YYYY-MM-DD')
  })
}