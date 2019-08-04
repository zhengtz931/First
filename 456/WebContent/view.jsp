<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>打印页面</title>
        <script src="//cdn.bootcss.com/jquery/3.0.0-rc1/jquery.min.js"></script>
	<style>
	      body {
        margin: 0;
        padding: 0;
        background-color: white;
      }
      header, section {
          overflow: hidden;
      }
      ul {
        margin: 0;
        border: 0;
        padding: 0;
      }
      li {
        display: block; /* i.e., suppress marker */
        color: black;
        height: 4em;
        width: 25%;
        margin: 0;
        float: left;
        background-color: green;
        text-align: center;
        line-height: 4em;
      }
      
      aside {
        width: 20%;
        float: left;
        text-align: center;
      }

      aside a {
        display: block;
        height: 4em;
        color: blue;
      }

      article {
        padding: 2em 0;
        width: 80%;
        float: left;
      }
    </style>
	</style>
</head>
<body style="text-align: center;background-color: white;">
	<h1>第二课堂成绩单</h1>
	 <button id="renderPdf">打印成绩单</button>
          <section>
      <aside>
        <h3>it is a title</h3>
        <a href="">Stone Giant</a>
        <a href="">link2</a>
        <a href="">link3</a>
        <a href="">link4</a>
        <a href="">link5</a>
        <a href="">link6</a>
      </aside>
      <article>
        <img src="img/banner1.jpg">
       
        <h2>Stone Giant</h2>
        <p>
          Coming to life as a chunk of stone, Tiny's origins are a mystery on which he continually speculates. He is a Stone Giant now, but what did he used to be? A splinter broken from a Golem's heel? A shard swept from a gargoyle-sculptor's workshop? A fragment of the Oracular Visage of Garthos? A deep curiosity drives him, and he travels the world tirelessly seeking his origins, his parentage, his people. As he roams, he gathers weight and size; the forces that weather lesser rocks, instead cause Tiny to grow and ever grow.
        </p>
   
   
    

      </article>
    </section>   
           
	<jsp:useBean id = "reguser" class = "entity.user"  scope = "session"/> 
<jsp:getProperty property="number" name="reguser"/>

<%
   double[] grade = reguser.getGrade();
for(int i = 0;i < 5;i++)
{
	%>
	
	
	

<%} %>
 
	<div class="box">
		<canvas id="myCanvas" width="400" height="400">
	
			Your browser does not support the canvas element.
		</canvas>	
		
	</div>
	
</body>
<script>
	//配置
	var width = $("#myCanvas").width(),
	height = $("#myCanvas").width(),
	edgeLength = 100, //六边形的边长
	pointRadius = 6, //小圆的半径
	c = document.getElementById("myCanvas"),
    ctx = c.getContext("2d"),
    allPoints = [],
    clickPoints = [2, 2, 2, 2, 2, 2],
    mx,my,
    point = [],
    data = [<%=grade[0]*5%>, <%=grade[1]*5%>, <%=grade[2]*5%>, <%=grade[0]*5%>, <%=grade[0]*5%>, 60];   // 权重显示数据

    drawHexagon(edgeLength); 	// 画出5个六边形
    drawLines();	// 画出交叉线
    // drawPoints(pointRadius);	// 是否显示描点
    linePoint(allPoints);

   	for (var i = 0; i < data.length; i++) {
   		var num = 5 - Math.floor(parseInt(data[i])/20);
   		data[i] = point[i][num];
   	};
   	// console.log(data);
    var coverPoints = data;
    drawCover(coverPoints);		// 根据传入数据画出覆盖物范围


    	// 将每部分直线上的点归为一个数组
    function linePoint(allPoints){
	    var firstPoint = [],
	    	secondPoint = [],
	    	thirdPoint = [],
	    	forthPoint = [],
	    	fifthPoint = [],
	    	sixthPoint = [];
	   	for (var i = 0; i < allPoints.length; i++) {
	   		firstPoint.push(allPoints[i][0]);
	   		secondPoint.push(allPoints[i][1]);
	   		thirdPoint.push(allPoints[i][2]);
	   		forthPoint.push(allPoints[i][3]);
	   		fifthPoint.push(allPoints[i][4]);
	   		sixthPoint.push(allPoints[i][5]);
	   	};
	   		// 将每部分直线上的点归为一个数组
	   	point.push(firstPoint, secondPoint, thirdPoint, forthPoint, fifthPoint, sixthPoint);	
	   	return point;
    }


    	//画六个六边形
    function drawHexagon(sixParam) {
        for (var i = 0; i < 6; i++) {
            allPoints[i] = getHexagonPoints(width, height, sixParam - i * sixParam/ 5);	// 每个点坐标
            ctx.beginPath();
            ctx.fillStyle = "#FFF";
            ctx.moveTo(allPoints[i][5][0],allPoints[i][5][1]); //5 首尾连接
            for (var j = 0; j < 6; j++) {
                ctx.lineTo(allPoints[i][j][0],allPoints[i][j][1]); //1 1-5端对端连接
            }
            // ctx.strokeStyle = 'red';
            // ctx.stroke();
            ctx.closePath();
            ctx.fill();
        }
    }


		//画覆盖物
    function drawCover(coverPoints) {
        ctx.beginPath();
        ctx.fillStyle = "rgba(50,188,125,0.5)";
        ctx.moveTo(coverPoints[5][0],coverPoints[5][1]); //5
        for (var j = 0; j < 6; j++) {
            ctx.lineTo(coverPoints[j][0],coverPoints[j][1]);
        }
        ctx.stroke();
        ctx.closePath();
        ctx.fill();
    }


    	//描点
    function drawPoints(pointRadius) {
        ctx.fillStyle="#808080";
        for (var i = 0; i < 5; i++) {
            for (var k = 0; k < 6; k++) {
                ctx.beginPath();
                ctx.arc(allPoints[i][k][0],allPoints[i][k][1],pointRadius,0,Math.PI*2);
                ctx.closePath();
                ctx.fill();
            }
        }
    }


    	//画交叉的线
    function drawLines() {
        ctx.beginPath();
        for (var i = 0; i < 3; i++) {
            ctx.moveTo(allPoints[0][i][0],allPoints[0][i][1]); //1-4
            ctx.lineTo(allPoints[0][i+3][0],allPoints[0][i+3][1]); //1-4
            ctx.strokeStyle = '#000';
            ctx.stroke();
        }
        ctx.closePath();
    }


    	// 画出最外层六边形的边框
    var outPoint = allPoints[0];
    outStroke(outPoint);
    function outStroke(outPoint){
	    ctx.beginPath();
	    ctx.fillStyle = "rgba(0,0,0,0)";
	    ctx.moveTo(outPoint[5][0],outPoint[5][1]); //5 首尾连接
	    for (var j = 0; j < 6; j++) {
	        ctx.lineTo(outPoint[j][0],outPoint[j][1]); //1 1-5端对端连接
	    }
	    ctx.strokeStyle = '#000';
	    ctx.stroke();
	    ctx.closePath();
	    ctx.fill();	
    }
    

    	//传入canvas的宽度和高度还有六边形的边长，就可以确定一个六边形的六个点的坐标了
    function getHexagonPoints(width, height, edgeLength) {
        var paramX = edgeLength * Math.sqrt(3) / 2;
        var marginLeft = (width - 2 * paramX) / 2;
        var x5 = x6 = marginLeft;
        var x2 = x3 = marginLeft + paramX * 2;
        var x1 = x4 = marginLeft + paramX;
     
        var paramY = edgeLength / 2;
        var marginTop = (height - 4 * paramY) / 2;
        var y1 = marginTop;
        var y2 = y6 = marginTop + paramY;
        var y3 = y5 = marginTop + 3 * paramY;
        var y4 = marginTop + 4 * paramY;
     
        var points = new Array();
        points[0] = [x1, y1];
        points[1] = [x2, y2];
        points[2] = [x3, y3];
        points[3] = [x4, y4];
        points[4] = [x5, y5];
        points[5] = [x6, y6];
        return points;
    }
</script>
  <script type="text/javascript" src="./js/html2canvas.js"></script>
    <script type="text/javascript" src="./js/jsPdf.debug.js"></script>
    <script type="text/javascript">

      var downPdf = document.getElementById("renderPdf");

      downPdf.onclick = function() {
          html2canvas(document.body, {
              onrendered:function(canvas) {

                  //返回图片URL，参数：图片格式和清晰度(0-1)
                  var pageData = canvas.toDataURL('image/jpeg', 1.0);

                  //方向默认竖直，尺寸ponits，格式a4【595.28,841.89]
                  var pdf = new jsPDF('', 'pt', 'a4');

                  //需要dataUrl格式
                  pdf.addImage(pageData, 'JPEG', 0, 0, 595.28, 592.28/canvas.width * canvas.height );

                  pdf.save('content.pdf');
              }
          })
      }
    </script>
</html>