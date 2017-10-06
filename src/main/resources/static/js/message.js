$(document).ready(function () {
    $('#userMessage').on('click',function(){
        $.ajax({
            type: 'post',
            url: 'userMessage',
            data: '',
            dataType: 'html',
            success: function (msg) {
                document.getElementById('messageTable').innerHTML = msg;
            },
            error: function () {
                console.log("error");
            }
        })
    });
    $('#permissionMessage').on('click',function(){
        $.ajax({
            type: 'post',
            url: 'permissionMessage',
            data: '',
            dataType: 'html',
            success: function (msg) {
                document.getElementById('messageTable').innerHTML = msg;
            },
            error: function (e) {
                console.log(e);
            }
        })
    });
    $('#roleMessage').on('click',function(){
        $.ajax({
            type: 'post',
            url: 'roleMessage',
            data: '',
            dataType: 'html',
            success: function (msg) {
                document.getElementById('messageTable').innerHTML = msg;
            },
            error: function (e) {
                console.log(e);
            }
        })
    });
    $('#userRole').on('click',function(){
        $.ajax({
            type: 'post',
            url: 'userRole',
            data: '',
            dataType: 'html',
            success: function (msg) {
                document.getElementById('messageTable').innerHTML = msg;
            },
            error: function (e) {
                console.log(e);
            }
        })
    });
    $('#rolePermission').on('click',function(){
        $.ajax({
            type: 'post',
            url: 'rolePermission',
            data: '',
            dataType: 'html',
            success: function (msg) {
                document.getElementById('messageTable').innerHTML = msg;
            },
            error: function (e) {
                console.log(e);
            }
        })
    });
    $('#logout').on('click',function () {
        $.ajax({
            type: 'get',
            url: '/logout',
            data: '',
            dataType: 'html',
            success: function (msg) {
                window.location.href="/login";
            },
            error: function (e) {
                console.log(e);
            }
        })
    })
});