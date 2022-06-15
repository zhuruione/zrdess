
$(function () {
    getpage(0,0)
})

function getpage(father,leave){
    $("#dir_li").children().remove()
    $.get("/getfiles",
        {
            father:father,
            leave:leave
        },
        function (data) {
            var dirs=data.datas.dirs
            $.each(dirs, function (i) {
                var dir=dirs[i]
                $("#dir_li").append('<span  class="maindir">' +
                    '         <a onclick="showdirs('+dir.id+','+dir.leave+',\''+dir.name+'\')" class="list-group-item" data-toggle="collapse">' +
                    '            <p class="list-group-item-text text-muted" style="position: absolute;left: 50px;top: 15px;font-size: 17px">'+dir.name+'</p>' +
                    '        <img src="/image/fileimg/dir.png" height="30px">' +
                    '        </a>' +
                    '    </span>')

            })
            var files=data.datas.files
            $.each(files, function (i) {
                var file=files[i]
                $("#dir_li").append('<span  class="maindir">' +
                    '         <a onclick="openfile('+file.id+')" class="list-group-item" data-toggle="collapse">' +
                    '            <p class="list-group-item-text text-muted" style="position: absolute;left: 50px;top: 15px;font-size: 17px">'+file.name+'</p>' +
                    '        <img src="/image/fileimg/'+file.type+'.png" height="30px">' +
                    '        </a>' +
                    '    </span>')

            })
        })
}
function showdirs(thisdir,leave,name){
    leave+=1
    $("#dh_ol").append('<li class="ok" id="ol_'+leave+'" ><a onclick="reback('+thisdir+','+leave+')">'+name+'</a></li>\n')
    getpage(thisdir,leave)
}
function reback(thisdir,leave){
    getpage(thisdir,leave)
    var li_class=$("#ol_"+leave).attr("class");
    while (li_class=="ok"){
        leave++
        li_class=$("#ol_"+leave).attr("class")
        $("#ol_"+leave).remove()
    }
}
function openfile(fileid){
    $(location).attr("href","/openfile?fileid="+fileid)
}