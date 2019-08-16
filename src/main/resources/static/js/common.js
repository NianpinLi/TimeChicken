//得到查询的参数
function queryParams(params) {
    var temp = $("#searchForm").serializeArray();
    temp.push(
        {"name":"offset","value":params.offset},
        {"name":"limit","value":params.limit},
        {"name":"sort","value":params.sort},
        {"name":"sortOrder","value":params.order}
    );
    return temp;
}
//根据条件查询列表
function searchTable() {
    $("#table").bootstrapTable("refresh");
}
//根据条件查询列表
function clearSearchTable() {
    $("#searchForm")[0].reset();
    $("#table").bootstrapTable("refresh");
}


// Toggle Sidebar

$(function() {
    $(".toggle-sidebar").bind('click', function() {
        $("body").toggleClass("sidebar-collapse");
    });


    $(function() {
        $(".dial").knob();
    });
});

$(function() {
    $(".dropdown").hover(
        function() {
            $('.dropdown-menu', this).stop(true, true).fadeIn("fast");
            $(this).toggleClass('open');
            $('b', this).toggleClass("caret caret-up");
        },
        function() {
            $('.dropdown-menu', this).stop(true, true).fadeOut("fast");
            $(this).toggleClass('open');
            $('b', this).toggleClass("caret caret-up");
        });
});

// Load More
$(function() {
    $("#message-load-more").bind('click', function() {
        $("#message-load-more .fa").toggleClass("fa-spin");
        return false;
    });
});

// Select2 & Bootstrap-select
$(function() {
    $('.selectpicker').selectpicker();
});