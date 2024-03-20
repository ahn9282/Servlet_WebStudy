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
    #game {
      min-height: 100vh;
    }

    #tenmore {
      border-radius: 0 5px 5px 0;
    }

    #modal.modal-overlay {

      display: none;

    }

    #modal{
    
      width:100%;
      height: 100%;
      position: fixed;
      top: 0;
      left:0;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: white;
      border: none;
      overflow: hidden;
      background: rgba(0,0,0,0.5);
    }
    #modalcontent{
     width:500px;
     height:100%;
    }
  </style>
</head>

<body id="game" class="d-flex flex-column justify-content-between vh-300">
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
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/board.do">게시판</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page"
                href="${pageContext.request.contextPath }/gugudan.do">구구단</a>
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
      
    </main>
    <script>

      const gomodal = document.getElementById("gomodal");
      const modal = document.getElementById("modal");
      const btnModal = document.getElementById("modal_button");


      function modalOn() {
        modal.style.display = "flex";
      }
      function modalOff() {
        modal.style.display = "none";
      }

      btnModal.addEventListener("click", e => {
        modalOn()

      })
      const closeBtn = document.getElementById("closebtn");
      closeBtn.addEventListener("click", e => {
        modalOff()

      })

      window.addEventListener("keyup", e => {
        if (modal.style.display === "flex" && e.key === "Escape") {
          modalOff()

        }
      })


    </script>
<script>
  function clock(){
 let today = new Date();
 let hour= today.getHours();
 let minute = today.getMinutes();
  let sec = today.getSeconds();

  //document.write(hour + " : " + minute + " : " + sec+ "<br>") ;

   
     let timeElement = document.getElementById('time');
     timeElement.innerHTML = hour + " : " + minute + " : " + sec+ "<br>";
}
clock();
   setInterval(clock,1000);
</script>

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