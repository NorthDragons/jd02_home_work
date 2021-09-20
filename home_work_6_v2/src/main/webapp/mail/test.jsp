<%@ page contentType="text/css" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Simple Pagination with CSS3</title>

<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->

<!-- <meta name="viewport" content="width=device-width"> -->
<style>
.top-menu {
  position: relative;
  background: rgba(34,34,34,.2);
}
.menu-main {
  list-style: none;
  margin: 0;
  padding: 0;
}
.menu-main:after {
  content: "";
  display: table;
  clear: both;
}
.left-item {float: left;}
.right-item {float: right;}
.navbar-logo {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
}
.menu-main a {
  text-decoration: none;
  display: block;
  line-height: 40px;
  padding: 0 20px;
  font-size: 18px;
  letter-spacing: 1px;
  font-family: 'Arimo', sans-serif;
  font-weight: bold;
  color: black;
  transition: .1s linear;
}
.menu-main a:hover {background: rgba(0,0,0,.3);}
@media (max-width: 830px) {
.menu-main {
  padding-top: 90px;
  text-align: center;
}
.navbar-logo {
  position: absolute;
  left: 50%;
  top: 10px;
  transform: translateX(-50%);
}
.menu-main li {
  float: none;
  display: inline-block;
}
.menu-main a {
  line-height: normal;
  padding: 20px 15px;
  font-size: 16px;
}
}
@media (max-width: 630px) {
.menu-main li {display: block;}
}

   .btn {
    display: inline-block; /* Строчно-блочный элемент */
    background: #8C959D; /* Серый цвет фона */
    color: #fff; /* Белый цвет текста */
    padding: 1rem 1.5rem; /* Поля вокруг текста */
    text-decoration: none; /* Убираем подчёркивание */
    border-radius: 3px; /* Скругляем уголки */
   }
  </style>
<link rel="stylesheet" href="css/topmenu.css" type="text/css">
</head>
<body align="center">
<nav class="top-menu">
  <ul class="menu-main">
    <li class="left-item"><a href="">Work</a></li>
    <li class="left-item"><a href="">About</a></li>
    <li class="left-item"><a href="">Story</a></li>
    <li class="right-item"><a href="">Contact</a></li>
    <li class="right-item"><a href="">Shop</a></li>
    <li class="right-item"><a href="">Gallery</a></li>
</ul>
  <a class="navbar-logo" href=""><img src="https://html5book.ru/wp-content/uploads/2017/04/lily-logo.png"></a>
</nav>
</body>