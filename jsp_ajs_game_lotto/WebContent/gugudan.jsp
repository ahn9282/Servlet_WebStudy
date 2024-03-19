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
            <input class="form-control me-2 bg-white " type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
  </hedear>

  <main>

   <table class="table-bordered" style="min-width:1000px">
        <thead class="bordered text-center">
            <tr>
                <th>2단</th>
                <th>3단</th>
                <th>4단</th>
                <th>5단</th>
                <th>6단</th>
                <th>7단</th>
                <th>8단</th>
                <th>9단</th>
            </tr>
        </thead>
        <tbody class=" text-center">

            <script>
                
                for(let i =1; i<=9;i++){
                    document.write("<tr>");
                        for(let j =2; j<=9;j++){
                            document.write("<td>");
                                document.write(j+ " * " + i+" = " + (i*j) );
                                document.write("</td>");
                            }
                            document.write("</tr>");
                        }
                        </script>
                        </tbody>
    </table>
  </main>

  <footer>

    <hr>
    <div class="text-center">

      <p>
        © Comapny 2022-2023
      </p>
    </div>
  </footer>


</body>
</html>