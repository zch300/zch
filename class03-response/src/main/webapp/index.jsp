<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>      响应不同类型的文件</title>
  <style>
    ul li{
      list-style: none;
      float: left;
      margin-top: 40px;
    }

    ul li a{
      padding: 30px 60px;
      height: 40px;
      background-color: #83d4e6;
      color: #fff;
      box-sizing: border-box;
      margin-right: 10px;
      font-size: 16px;
      text-decoration: none;
    }

    ul li a:hover{
      background-color: #d1d1df;
    }
  </style>
</head>
<body>
<h1><%= "     设置 Content-Type 不同类型的资源" %>
</h1>
<h2><%= "     根据不同的参数类型返回不同的资源" %>
</h2>
<br/>
<ul>
  <li>
    <a href="/res?type=png">图片</a>
  </li>
  <li>
    <a href="/res?type=pdf">pdf</a>
  </li>
  <li>
    <a href="/res?type=text">文本</a>
  </li>
  <li>
    <a href="/res?type=web">网页</a>
  </li>
  <li>
    <a href="/verifyCode">验证码</a>
  </li>
</ul>
</body>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>下载文件</title>
  <style>
    /* 美化按钮的样式 */
    a {
      display: inline-block;
      padding: 10px 20px;
      background-color: #4fdd5a;
      color: #f8f1f1;
      text-decoration: none;
      border-radius: 5px;
      box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
    }

    /* 创建一个容器用于定位按钮 */
    .button-container {
      position: fixed;
      bottom: 30%;
      left: 50%;
      transform: translateX(-50%);
    }
  </style>
</head>

<body>
<div class="button-container">
  <a href="download?filename=image.jpg">查看壁纸</a>
  <a href="download?filename=txt.txt">下载文件</a>
</div>
</body>

</html>