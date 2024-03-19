<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게임</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> 
 <style>
    #game{
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      height: 100vh;
    }
  </style>
 
</head>
<body class="d-flex flex-column justify-content-between vh-100">
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
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/lotto.do">로또</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/rsp.do">가위바위보</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/board.do">게시판</a>
            </li>
             <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/gugudan.do">구구단</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
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
      <form action="${pageContext.request.contextPath}/rsp.do" method="post">
        <div class="col-md-4 d-flex justify-content-center">
          <div class="card" style="width: 18rem;"> 
            <img src="${user.img }" class="card-img-top" alt="...">
            <div class="card-body text-center">
              <h5 class="card-title">당신</h5>
              <button class="btn btn-primary m-2" type="submit" value="가위" name="rsp">가위</button>              
              <button class="btn btn-primary m-2" type="submit" value="바위" name="rsp">바위</button> 
              <button class="btn btn-primary m-2" type="submit" value="보" name="rsp">보</button> 
            </div>
          </div>
        </div>
      </form>
        <div class="col-md-4  d-flex justify-content-center ">
          <div class="card" style="width: 18rem;">
            <img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.net%2FMjAxNjEwMDdfMjQx%2FMDAxNDc1ODA5NzI3MTU0.hyt8VNKUQJUEfzYZgSvgW0PfvdV34QMh2NF1G73WE_kg.gTFZYfJpkMoq1x92WrdMCno1c7gWB02z7PAFPCdRqXsg.JPEG.minjea3636%2F2.jpg&type=a340" 
            class="card-img-top" alt="...">
            <div class="card-body text-center">
              <h5 class="card-title">심판</h5>
              <p>${com.getResult(user)}</p>
            </div>
          </div>
        </div>
        <div class="col-md-4 d-flex justify-content-center ">
          <div class="card" style="width: 18rem;">
            <img src="${com.img }" class="card-img-top" alt="...">
            <div class="card-body text-center">
              <h5 class="card-title">컴퓨터</h5>
              <button class="btn btn-primary m-2">${com.rsp}</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <footer id="footer" class="text-center d-flex justify-content-center">
    <hr>
    <p>© Company 2022-2023   ||</p>
    <div id="clock" ></div>
     <script>
    function clock(){
   let today = new Date();
   let hour= today.getHours();
   let minute = today.getMinutes();
    let sec = today.getSeconds();

    //document.write(hour + " : " + minute + " : " + sec+ "<br>") ;

       let clockElement = document.getElementById('clock');
       clockElement.innerHTML =" NOW : "+ hour + " : " + minute + " : " + sec+ "<br>";
	}

     setInterval(clock,1000);
  </script>
  </footer>
</body>
</html>