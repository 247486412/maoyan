function addDelete(name) {
  $(".addCategory").click(function () {
    var input = $("<br><div class=\"form-group\" >\n" +
        "            <label for=\"exampleInputName2\" class=\"h4\">" + name + ":</label>\n" +
        "            <input Type=\"text\" class=\"form-control inputText\" id=\"exampleInputName2\"  name=\"name\" placeholder=\"请输入" + name + "\">\n" +
        "        <button Type=\"button\" class=\"btn btn-default deleteCategory\">删除</button></div> ");
    input.appendTo($("#toForm"));
  });
  $("#toForm").on("click", ".deleteCategory", function () {
    $(this).parent().prev("br").remove();
    $(this).parent().remove();
  });
}

//提交时判断
function mySubmit(myForm) {
  $("body").on("submit", myForm, function () {
    var inputText = $(".inputText");
    var flag = true;
    inputText.each(function () {
      var value = $(this).val();
      if (value == null || value.trim().length === 0) {
        flag = false;
        $("#msg").text("值不能为空");
      }
    });
    return flag;
  });
}

//点击时弹出模态框
function choose(url) {
  $(".deleteCategory").click(function () {
    var id = $(this).val();
    $("#exampleModal").modal('show');
    $("#confirm").click(function () {
      location.href = url + "&id=" + id;
    });
  });
}




