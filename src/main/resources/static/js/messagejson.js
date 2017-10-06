$(document).ready(function () {
    $('.userMessage').DataTable({
        processing: true,
        serverSide: true,
        lengthChange: true,//是否允许用户改变表格每页显示的记录数
        ordering: true,//是否允许用户排序
        paging: true,//是否分页
        pagingType: "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
        /* scrollX: true,//允许水平滚动
         scrollY: "200px",
         scrollCollapse: true, */
        searching: false,//是否开始本地搜索
        stateSave: false,//刷新时是否保存状态
        autoWidth: true,//自动计算宽度
        //deferRender : true,//延迟渲染
        language: {
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": " ",
            "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            // "search": "用户",
            // "processing": "载入中",
            "paginate": {
                "first": "首页",
                "previous": "上一页",
                "next": "下一页",
                "last": "尾页"
            }
        },
        ajax: {
            url: '../../userJson/userMessage',
            type: 'POST'
        },
        columns: [
            {
                data: "id"
            },
            {
                data: "username"
            },
            {
                data: "name"
            },
            {
                data: "password"
            },
            {
                data: "salt"
            },
            {
                data: "state"
            }
        ]
    });
    $('#userMessage').on('click',function(){
        $('.showUser').css('display','block');
        $(".showPermission").css('display','none');
        $('.showRole').css('display','none');
        $(".showUserRole").css('display','none');
        $(".showRolePermission").css('display','none');
        $('#DataTables_Table_0').dataTable().fnDestroy();
        $('.userMessage').DataTable({
            processing: true,
            serverSide: true,
            lengthChange: true,//是否允许用户改变表格每页显示的记录数
            ordering: true,//是否允许用户排序
            paging: true,//是否分页
            pagingType: "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
            /* scrollX: true,//允许水平滚动
             scrollY: "200px",
             scrollCollapse: true, */
            searching: false,//是否开始本地搜索
            stateSave: false,//刷新时是否保存状态
            autoWidth: true,//自动计算宽度
            //deferRender : true,//延迟渲染
            language: {
                "lengthMenu": "每页 _MENU_ 条记录",
                "zeroRecords": " ",
                "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
                "infoEmpty": "无记录",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                // "search": "用户",
                // "processing": "载入中",
                "paginate": {
                    "first": "首页",
                    "previous": "上一页",
                    "next": "下一页",
                    "last": "尾页"
                }
            },
            ajax: {
                url: '../../userJson/userMessage',
                type: 'POST'
            },
            columns: [
                {
                    data: "id"
                },
                {
                    data: "username"
                },
                {
                    data: "name"
                },
                {
                    data: "password"
                },
                {
                    data: "salt"
                },
                {
                    data: "state"
                }
            ]
        });
    });
    $('#permissionMessage').on('click',function(){
        $('.showUser').css('display','none');
        $(".showPermission").css('display','block');
        $('.showRole').css('display','none');
        $(".showUserRole").css('display','none');
        $(".showRolePermission").css('display','none');
        $('#DataTables_Table_1').dataTable().fnDestroy();
        $('.permissionMessage').DataTable({
            processing: true,
            serverSide: true,
            lengthChange: true,//是否允许用户改变表格每页显示的记录数
            ordering: true,//是否允许用户排序
            paging: true,//是否分页
            pagingType: "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
            /* scrollX: true,//允许水平滚动
             scrollY: "200px",
             scrollCollapse: true, */
            searching: false,//是否开始本地搜索
            stateSave: false,//刷新时是否保存状态
            autoWidth: true,//自动计算宽度
            //deferRender : true,//延迟渲染
            language: {
                "lengthMenu": "每页 _MENU_ 条记录",
                "zeroRecords": " ",
                "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
                "infoEmpty": "无记录",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                // "search": "用户",
                // "processing": "载入中",
                "paginate": {
                    "first": "首页",
                    "previous": "上一页",
                    "next": "下一页",
                    "last": "尾页"
                }
            },
            ajax: {
                url: '../../userJson/permissionMessage',
                type: 'POST'
            },
            columns: [
                {
                    data: "id"
                },
                {
                    data: "parentId"
                },
                {
                    data: "parentIds"
                },
                {
                    data: "permission"
                },
                {
                    data: "available"
                },
                {
                    data: "name"
                },
                {
                    data: "resourceType"
                },
                {
                    data: "url"
                }
            ]
        });
    });
    $('#roleMessage').on('click',function(){
        $('.showUser').css('display','none');
        $(".showPermission").css('display','none');
        $('.showRole').css('display','block');
        $(".showUserRole").css('display','none');
        $(".showRolePermission").css('display','none');
        $('#DataTables_Table_2').dataTable().fnDestroy();
        $('.roleMessage').DataTable({
            processing: true,
            serverSide: true,
            lengthChange: true,//是否允许用户改变表格每页显示的记录数
            ordering: true,//是否允许用户排序
            paging: true,//是否分页
            pagingType: "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
            /* scrollX: true,//允许水平滚动
             scrollY: "200px",
             scrollCollapse: true, */
            searching: false,//是否开始本地搜索
            stateSave: false,//刷新时是否保存状态
            autoWidth: true,//自动计算宽度
            //deferRender : true,//延迟渲染
            language: {
                "lengthMenu": "每页 _MENU_ 条记录",
                "zeroRecords": " ",
                "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
                "infoEmpty": "无记录",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                // "search": "用户",
                // "processing": "载入中",
                "paginate": {
                    "first": "首页",
                    "previous": "上一页",
                    "next": "下一页",
                    "last": "尾页"
                }
            },
            ajax: {
                url: '../../userJson/roleMessage',
                type: 'POST'
            },
            columns: [
                {
                    data: "id"
                },
                {
                    data: "available"
                },
                {
                    data: "description"
                },
                {
                    data: "role"
                }
            ]
        });
    });
    $('#userRole').on('click',function(){
        $('.showUser').css('display','none');
        $(".showPermission").css('display','none');
        $('.showRole').css('display','none');
        $(".showUserRole").css('display','block');
        $(".showRolePermission").css('display','none');
        $('#DataTables_Table_3').dataTable().fnDestroy();
        $('.userRole').DataTable({
            processing: true,
            serverSide: true,
            lengthChange: true,//是否允许用户改变表格每页显示的记录数
            ordering: true,//是否允许用户排序
            paging: true,//是否分页
            pagingType: "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
            /* scrollX: true,//允许水平滚动
             scrollY: "200px",
             scrollCollapse: true, */
            searching: false,//是否开始本地搜索
            stateSave: false,//刷新时是否保存状态
            autoWidth: true,//自动计算宽度
            //deferRender : true,//延迟渲染
            language: {
                "lengthMenu": "每页 _MENU_ 条记录",
                "zeroRecords": " ",
                "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
                "infoEmpty": "无记录",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                // "search": "用户",
                // "processing": "载入中",
                "paginate": {
                    "first": "首页",
                    "previous": "上一页",
                    "next": "下一页",
                    "last": "尾页"
                }
            },
            ajax: {
                url: '../../userJson/userRole',
                type: 'POST'
            },
            columns: [
                {
                    data: "userInfoList[0].id"
                },
                {
                    data: "userInfoList[0].username"
                },
                {
                    data: "userInfoList[0].name"
                },
                {
                    data: "userInfoList[0].password"
                },
                {
                    data: "userInfoList[0].salt"
                },
                {
                    data: "userInfoList[0].state"
                },
                {
                    data: "id"
                },
                {
                    data: "available"
                },
                {
                    data: "description"
                },
                {
                    data: "role"
                }
            ]
        });
    });
    $('#rolePermission').on('click',function(){
        $('.showUser').css('display','none');
        $(".showPermission").css('display','none');
        $('.showRole').css('display','none');
        $(".showUserRole").css('display','none');
        $(".showRolePermission").css('display','block');
        $('#DataTables_Table_4').dataTable().fnDestroy();
        $('.rolePermission').DataTable({
            processing: true,
            serverSide: true,
            lengthChange: true,//是否允许用户改变表格每页显示的记录数
            ordering: true,//是否允许用户排序
            paging: true,//是否分页
            pagingType: "full_numbers",//除首页、上一页、下一页、末页四个按钮还有页数按钮
            /* scrollX: true,//允许水平滚动
             scrollY: "200px",
             scrollCollapse: true, */
            searching: false,//是否开始本地搜索
            stateSave: false,//刷新时是否保存状态
            autoWidth: true,//自动计算宽度
            //deferRender : true,//延迟渲染
            language: {
                "lengthMenu": "每页 _MENU_ 条记录",
                "zeroRecords": " ",
                "info": "当前 _START_ 条到 _END_ 条 共 _TOTAL_ 条",
                "infoEmpty": "无记录",
                "infoFiltered": "(从 _MAX_ 条记录过滤)",
                // "search": "用户",
                // "processing": "载入中",
                "paginate": {
                    "first": "首页",
                    "previous": "上一页",
                    "next": "下一页",
                    "last": "尾页"
                }
            },
            ajax: {
                url: '../../userJson/rolePermission',
                type: 'POST'
            },
            columns: [
                {
                    data: "id"
                },
                {
                    data: "available"
                },
                {
                    data: "description"
                },
                {
                    data: "role"
                },
                {
                    data: "sysPermissionList.id"
                },
                {
                    data: "sysPermissionList.parentId"
                },
                {
                    data: "sysPermissionList.parentIds"
                },
                {
                    data: "sysPermissionList.permission"
                },
                {
                    data: "sysPermissionList.available"
                },
                {
                    data: "sysPermissionList.resourceType"
                },
                {
                    data: "sysPermissionList.url"
                }
            ]
        });
    });
});