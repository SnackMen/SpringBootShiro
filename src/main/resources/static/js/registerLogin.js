$(document).ready(function () {
    $("form").validation();
    $("input[type='button']").on('click',function(event){
        // 2.最后要调用 valid()方法。
        // $('form').submit(function () {
        //    console.log($(this).serialize());
        //    return false;
        // });
        console.log($('form').serialize());
        if ($("form").valid(this,"error!")===false){
            return false;
        }
    });
});