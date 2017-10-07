$(document).ready(function () {
    $("form").validation();
    $("input[type='button']").on('click',function(event){
        console.log(decodeURIComponent($('form').serialize(),true));
        var data = decodeURIComponent($('form').serialize(),true);
        if ($("form").valid(this,"error!")===false){
            return false;
        }

        $.post("registerUser",data, function (data) {
            console.log(data);

            document.getElementById('regist').innerHTML = data;
        })
    });
});