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
    
    
      position: fixed;
      top: 150px;
      left: 35%;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: white;
      border: 1px solid #aaaaaa;
      overflow: hidden;

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
      <div class="container">

        <h2 class="my-3 text-center">게시판</h2>
        <div class="card shadow">
          <div class="card-header ">
            <h5 class="text-primary">DataTables Example</h5>
          </div>
          <div class="card-body p-3">
            <div class="table-responsive">
              <table class="table table-bordered table-hover">
                <form action="${pageContext.request.contextPath }/boarddelete.do" method="post">
                  <thead>
                    <tr class="text-center">
                      <th>번호</th>
                      <th>이름</th>
                      <th>제목</th>
                      <th>날짜</th>
                      <th>히트</th>
                      <th>삭제</th>
                    </tr>
                  </thead>
                  <tbody>

                    <c:forEach var="dto" items="${list }">
                      <tr class="text-center ">
                        <td>${dto.getBid()}</td>
                        <td>${dto.getBname()}</td>
                        <td><a href="boardupdate.do?bid=${dto.bid}">${dto.btitle}</a></td>
                        <td>${dto.getBdate()}</td>
                        <td>${dto.getBhit()}</td>
                        <td><button class="btn btn-success" type="submit" name="bid"
                            value="${dto.getBid() }">삭제</button></td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </form>
              </table>

              <div class="container my-3 d-flex flex-row justify-content-center text-center">
                <div class="border py-2 text-primary" style="width:2em ">
                  1
                </div>
                <div class="border py-2 text-primary" id="tenmore" style="width:2em">
                  >>
                </div>
              </div>
            </div>

          </div>
          <div class="card-footer d-flex justify-content-center">



            <button class="btn btn-primary modal_btn" id="modal_button">글쓰기</button>

            <div id="gomodal"></div>

            <div id="modal" class="modal-overlay">
              <form action="${pageContext.request.contextPath }/board_add.do">

                <div class="card card-border d-flex flex-column justify-content-center" id="modalcontent">
                  <div class="card-header w-100">
                    <h2>글쓰기</h2>
                  </div>
                  <div class="card-body p-3 w-100">
                    <p class="mb-0">작성자 :</p>
                    <input class="w-100 mx-auto p-3" type="text" name="bname" value=""
                      style="border-radius: 5px;">
                    <p class="mb-0">제목 : </p>
                    <input class="w-100 mx-auto p-3" type="text" name="btitle" value=""
                      style="border-radius: 5px;">
                    <p class="mb-0">내용 : </p>
                    <textarea class="w-100 mx-auto p-3" style="min-height: 60px ;border-radius: 5px;"
                      name="bcontent"></textarea>
                  </div>
                  <div class="card-footer w-100">
                    <button class="btn btn-primary me-auto" type="submit">전송</button>
                    <a class="btn btn-secondary" id="closebtn">취소</a>
                  </div>
                </div>
              </form>
            </div>

            

          </div>
          
        </div>
      </div>

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