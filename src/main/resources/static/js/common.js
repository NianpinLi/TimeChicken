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

