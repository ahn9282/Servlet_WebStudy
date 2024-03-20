<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>LottoGame</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    </script>
    <style>
     #game{
      min-height:100vh;
    }
    </style>
</head>
<body id="game" class="d-flex flex-column justify-content-between">
  <hedear>
    <nav class="navbar navbar-expand-lg bg-body" data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">게임사이트</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/lotto.do">로또</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/rsp.do">가위바위보</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/board.do">게시판</a>
            </li>
             <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/gugudan.do">구구단</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
          <span id="time" class="text-white m-2 p-0" style="min-width:100px"></span>
            <input class="form-control me-2 bg-white " type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
  </hedear>

  <main>
<div class="container">
  <div class="row">
  <%
  int count = 0;
  %>
  <c:forEach var="num" items="${lotto.numbers}">


    <div class="col-lg-2 mt-3 d-flex justify-content-center align-items-center">
      <svg class="rounded-circle" width="140" height="140" focusable="false">
        <rect width="100%" height="100%" fill="${lotto.getColor(num)}"
        />
        <text text-anchor="middle" x="50%" y="50%" fill="white" dy=".3em" font-size="60">${num}</text>
      </svg>
    </div>
   </c:forEach>
  </div>
</div>   

<div class="container d-flex flex-column align-items-center justify-content-center">
        <h1>+</h1>

     <div class="col-lg-12 mt-3 d-flex justify-content-center align-items-center">
      <svg class="rounded-circle" width="140" height="140" focusable="false">
        <rect width="100%" height="100%" fill="${lotto.getColor(lotto.bonusnum)}"
        />
        <text text-anchor="middle" x="50%" y="50%" fill="black" dy=".3em" font-size="60">${lotto.bonusnum }</text>
      </svg>
    </div>
      </div>
 

  </main>

    
  <footer id="footer" class="text-center d-flex justify-content-between border-top" style="overflow-hidden">
  
    <p class="m-auto" style="position:relative width:50%">© Company 2022-2023 </p>
    <div id="clock" class="btn btn-primary m-0" style="float-right min-width:60px" ></div>
     <script>
    function clock(){
   let today = new Date();
   let hour= today.getHours();
   let minute = today.getMinutes();
    let sec = today.getSeconds();

    //document.write(hour + " : " + minute + " : " + sec+ "<br>") ;

       let clockElement = document.getElementById('clock');
       clockElement.innerHTML =" NOW : "+ hour + " : " + minute + " : " + sec+ "<br>";
       let timeElement = document.getElementById('time');
       timeElement.innerHTML = hour + " : " + minute + " : " + sec+ "<br>";
	}
	clock();
     setInterval(clock,1000);
  </script>
  </footer>

</body>
</html>