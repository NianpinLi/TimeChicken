//得到查询的参数
function queryParams(params) {
    var temp = $("#searchForm").serializeArray();
    temp['rows'] = params.limit; //页面大小
    temp['page'] = (params.offset / params.limit) + 1; //页码
    temp['sort'] = params.sort; //排序列名
    temp['sortOrder'] = params.order; //排位命令（desc，asc）
   return temp;
}
//根据条件查询列表
function searchTable() {
    $("#table").bootstrapTable("refresh");
}
//根据条件查询列表
function clearSearchTable(table) {
    $("#searchForm")[0].reset();
    $("#table").bootstrapTable("refresh");
}