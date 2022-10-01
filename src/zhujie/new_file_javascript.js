var widgetNames = ['time_from']; //定义数组存放控件名称

function getWidgetValueByName(name) {
    var widget = _g().parameterEl.getWidgetByName(name); //根据控件名获取控件值
    if (widget == undefined) return;
    var obj = {};
    obj[name] = widget.getValue();
    return obj; //返回控件值组成的数组
}
var paramJson = widgetNames.map(getWidgetValueByName).reduce(function(a, b) {
    return Object.assign(a, b)
});

var paramJsonStr = JSON.stringify(paramJson); //将json数据转换为字符串
var col = this.options.form.getWidgetByName("col_c").getValue();
//alert(col);
//参数进行url编码
var colNames = encodeURIComponent(col)

//指定导出的数据列，导出字段按此顺序排列，为空默认导出所有
//调用导出接口
//console.log(paramJsonStr);
console.log(colNames);
_g().directExportToExcel("ds1", "出库量销售价格明细记录", encodeURIComponent(paramJsonStr), colNames);