var shijian=10;
var time=null;
function start(){
    time=setInterval("count()",1000);//返回值time只是为了需要暂停的时候clearInterval(time)清除时间间隔
}

function count(){
    if(shijian<0){
    }else{
        $("#time p").html(Math.floor(shijian/60)+":"+shijian%60);//这里用到将毫秒转换到时分格式
        shijian--;
        console.info(time);
    }
}
function pause(){
    clearInterval(time);
}
function goOn(){
    time = setInterval("count()",1000);//重新设置时间间隔
}