// var baseAPI = 'http://localhost:8081';
var baseAPI = 'http://47.107.225.197:8081';
var dicefun = {
    init: function () {
        var container = document.getElementById('dicebox');
        $('.redpacket').remove();
        var arr = this.randomFun();
        var yy = 0;
        for (var i = 0; i < 6; i++) {
            container.appendChild(this.createDice(arr[i], i));
            yy = 10 * yy + arr[i];
        }
        var out;
        $.ajax({
            method: 'POST',
            url: baseAPI + '/dice/checkResult',
            data: {Uname: yy}
        }).done(function (msg) {
            aaax = document.getElementById("demo");  // 找到元素
            aaax.innerHTML = "你的成绩是" + msg;    // 改变内容
            changeZhanJi(msg)
        });
    },
    randomFun: function () {
        var arr = [];
        for (var i = 0; i < 6; i++) {
            var temp = Math.floor(Math.random() * 6 + 1);
            arr.push(temp);
        }
        return arr;
    },
    createDice: function (num, i) {
        var image = document.createElement('img');
        image.setAttribute("class", "redpacket");
        image.id = "redpacket" + i;
        image.src = 'img/' + num + '.jpg';
        return image;
    },
}

function changeZhanJi(msg) {
    let d1 = sessionStorage.getItem('ddd1');
    let d2 = sessionStorage.getItem('ddd2');
    let d3 = sessionStorage.getItem('ddd3');
    let d4 = sessionStorage.getItem('ddd4');
    let d5 = sessionStorage.getItem('ddd5');
    let d6 = sessionStorage.getItem('ddd6');
    var ddd1 = document.getElementById("zhuangyuan");
    var ddd2 = document.getElementById("duitang");
    var ddd3 = document.getElementById("sanhong");
    var ddd4 = document.getElementById("sijin");
    var ddd5 = document.getElementById("erju");
    var ddd6 = document.getElementById("yixiu");
    if (msg == "状元") {
        d1++;
    } else if (msg == "对堂") {
        d2++;
    } else if (msg == "三红") {
        d3++;
    } else if (msg == "四进") {
        d4++;
    } else if (msg == "二举") {
        d5++;
    } else if (msg == "一秀") {
        d6++;
    } else {

    }
    sessionStorage.setItem('ddd1', d1);
    sessionStorage.setItem('ddd2', d2);
    sessionStorage.setItem('ddd3', d3);
    sessionStorage.setItem('ddd4', d4);
    sessionStorage.setItem('ddd5', d5);
    sessionStorage.setItem('ddd6', d6);
    ddd1.innerHTML = d1;
    ddd2.innerHTML = d2;
    ddd3.innerHTML = d3;
    ddd4.innerHTML = d4;
    ddd5.innerHTML = d5;
    ddd6.innerHTML = d6;
}

function zongFen() {
    let d1 = sessionStorage.getItem('ddd1');
    let d2 = sessionStorage.getItem('ddd2');
    let d3 = sessionStorage.getItem('ddd3');
    let d4 = sessionStorage.getItem('ddd4');
    let d5 = sessionStorage.getItem('ddd5');
    let d6 = sessionStorage.getItem('ddd6');
    var p1 = document.getElementById("pl1");
    var p2 = document.getElementById("pl2");
    var p3 = document.getElementById("pl3");
    var p4 = document.getElementById("pl4");
    var p5 = document.getElementById("pl5");
    var p6 = document.getElementById("pl6");
    var ke =[p1,p2,p3,p4,p5,p6];
    let Rnum = window.sessionStorage.getItem('Rnumber');
    let uid = window.sessionStorage.getItem('Unumber');
    $.ajax({
        method: 'POST',
        url: baseAPI + '/room/changeZhanJi',
        data: {uid: uid, d1: d1, d2: d2, d3: d3, d4: d4, d5: d5, d6: d6}
    });

    $.ajax({
        method: 'POST',
        url: baseAPI + '/room/roomInf',
        datatype: 'json',
        data: {Rnumber: Rnum}
    }).success(function (res) {
        var dd = res.data.Rinf;
        for (let i = 0; i < 6; i++) {
            var pp = dd[i].uname;
            var z1 = dd[i].d1;
            var z2 = dd[i].d2;
            var z3 = dd[i].d3;
            var z4 = dd[i].d4;
            var z5 = dd[i].d5;
            var z6 = dd[i].d6;
            var score =(10*z1+7*z2+5*z3+4*z4+2*z5+z6);
            console.log(score);
            var temp = pp+" 得分： "+score;
            ke[i].innerHTML = temp;
        }
    });
}

var shijian = 10;
var time = null;

function start() {
    time = setInterval("count()", 1000);//返回值time只是为了需要暂停的时候clearInterval(time)清除时间间隔
}

function multiStart() {
    time = setInterval("count()", 1000);//返回值time只是为了需要暂停的时候clearInterval(time)清除时间间隔
}

function count() {
    if (shijian < 0) {
        clearInterval(time);
        shijian = 10;
        zongFen();
    } else {
        $("#time p").html(Math.floor(shijian / 60) + ":" + shijian % 60);//这里用到将毫秒转换到时分格式
        shijian--;
        console.info(time);
    }
}

function pause() {
    clearInterval(time);
}

function goOn() {
    time = setInterval("count()", 1000);//重新设置时间间隔
}

function btnClick() {

    var flag = false;
    if (flag == false) {
        console.log("点击了");
        document.getElementById("button_id").disabled = true;
    }
    flag = true;

    setTimeout(function () {
        document.getElementById("button_id").disabled = false;
        flag = false;
    }, 12000);
}
