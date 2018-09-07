<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/iziModal.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vendor-2cae343ef1.css" />
<style>

	

	
	.hide{
	  display: none;
	}
	

	
	#modal-custom .iziModal-content header{
	    background: #eee;
	    margin-bottom: 10px;
	    overflow: hidden;
	    border-radius: 3px 3px 0 0;
	    width: 100%;
	}
	#modal-custom .iziModal-content header a{
	    display: block;
	    float: left;
	    width: 50%;
	    padding: 0;
	    text-align: center;
	    background: #ddd;
	    color: #999;
	    height: 73px;
	    vertical-align: middle;
	    line-height: 73px;
	}
	#modal-custom .iziModal-content header a.active{
	    background: #fff;
	    color: #777;
	}
	#modal-custom .iziModal-content section{
	    padding: 30px;
	}
	#modal-custom .iziModal-content section input:not([type="checkbox"]), #modal-custom .iziModal-content section button{
	    width: 100%;
	    border-radius: 3px;
	    border: 1px solid #ddd;
	    margin-bottom: 26px;
	    padding: 15px;
	    font-size: 14px;
	}
	#modal-custom .iziModal-content section button{
	  height: 46px;
	  padding: 0;
	}
	#modal-custom .iziModal-content section input:focus{
	    border-color:#28CA97;
	}
	#modal-custom .iziModal-content section label[for="check"]{
	    margin-bottom: 26px;
	    font-size: 14px;
	    color: #999;
	    display: block;
	}
	#modal-custom .iziModal-content section footer{
	    overflow: hidden;
	}
	#modal-custom .iziModal-content section button{
	    background: #28CA97;
	    color: white;
	    margin: 0;
	    border: 0;
	    cursor: pointer;
	    width: 50%;
	    float: left;
	}
	#modal-custom .iziModal-content section button:hover{
	    opacity: 0.8;
	}
	#modal-custom .iziModal-content section button:nth-child(1){
	    border-radius: 3px 0 0 3px;
	    background: #aaa;
	}
	#modal-custom .iziModal-content section button:nth-child(2){
	    border-radius: 0 3px 3px 0;
	}
	
	#modal-custom .iziModal-content .icon-close{
	    background: #FFF;
	    margin-bottom: 10px;
	    position: absolute;
	    right: -8px;
	    top: -8px;
	    font-size: 14px;
	    font-weight: bold;
	    border-radius: 50%;
	    width: 30px;
	    height: 30px;
	    border: 0;
	    color: #a9a9a9;
	    cursor: pointer;
	}
	#modal-custom .iziModal-content .icon-close:hover, #modal-custom .iziModal-content .icon-close:focus{
	  color: black;
	}
	
	
	
	
	
	@-webkit-keyframes wobble {
	  from {
	    -webkit-transform: none;
	    transform: none;
	  }
	
	  15% {
	    -webkit-transform: translate3d(-25%, 0, 0) rotate3d(0, 0, 1, -5deg);
	    transform: translate3d(-25%, 0, 0) rotate3d(0, 0, 1, -5deg);
	  }
	
	  30% {
	    -webkit-transform: translate3d(20%, 0, 0) rotate3d(0, 0, 1, 3deg);
	    transform: translate3d(20%, 0, 0) rotate3d(0, 0, 1, 3deg);
	  }
	
	  45% {
	    -webkit-transform: translate3d(-15%, 0, 0) rotate3d(0, 0, 1, -3deg);
	    transform: translate3d(-15%, 0, 0) rotate3d(0, 0, 1, -3deg);
	  }
	
	  60% {
	    -webkit-transform: translate3d(10%, 0, 0) rotate3d(0, 0, 1, 2deg);
	    transform: translate3d(10%, 0, 0) rotate3d(0, 0, 1, 2deg);
	  }
	
	  75% {
	    -webkit-transform: translate3d(-5%, 0, 0) rotate3d(0, 0, 1, -1deg);
	    transform: translate3d(-5%, 0, 0) rotate3d(0, 0, 1, -1deg);
	  }
	
	  to {
	    -webkit-transform: none;
	    transform: none;
	  }
	}
	
	@keyframes wobble {
	  from {
	    -webkit-transform: none;
	    transform: none;
	  }
	
	  15% {
	    -webkit-transform: translate3d(-25%, 0, 0) rotate3d(0, 0, 1, -5deg);
	    transform: translate3d(-25%, 0, 0) rotate3d(0, 0, 1, -5deg);
	  }
	
	  30% {
	    -webkit-transform: translate3d(20%, 0, 0) rotate3d(0, 0, 1, 3deg);
	    transform: translate3d(20%, 0, 0) rotate3d(0, 0, 1, 3deg);
	  }
	
	  45% {
	    -webkit-transform: translate3d(-15%, 0, 0) rotate3d(0, 0, 1, -3deg);
	    transform: translate3d(-15%, 0, 0) rotate3d(0, 0, 1, -3deg);
	  }
	
	  60% {
	    -webkit-transform: translate3d(10%, 0, 0) rotate3d(0, 0, 1, 2deg);
	    transform: translate3d(10%, 0, 0) rotate3d(0, 0, 1, 2deg);
	  }
	
	  75% {
	    -webkit-transform: translate3d(-5%, 0, 0) rotate3d(0, 0, 1, -1deg);
	    transform: translate3d(-5%, 0, 0) rotate3d(0, 0, 1, -1deg);
	  }
	
	  to {
	    -webkit-transform: none;
	    transform: none;
	  }
	}
	
	.wobble {
	  -webkit-animation-name: wobble;
	  animation-name: wobble;
	  -webkit-animation-duration: 1s;
	  animation-duration: 1s;
	  -webkit-animation-fill-mode: both;
	  animation-fill-mode: both;
	}

  		html{
  			font-size:10px;
  		}
  		

        .header{
           position: absolute;
           display: flex;
           top:0;
           left:0;
           right:0;
           justify-content: space-between;
           padding:40px;
        }

  

        .header-links{
           background-color: transparent;
           bottom:auto;
           left:auto;
           opacity:1;
           pointer-events: all;
           position:relative;
           right:auto;
           top:auto;
        }

        .header-links ul{ 
           list-style-type:none;
           left:auto;
           max-width: none;
           position: relative;
           display: flex;
           top:auto;
           transform: none;
           width:auto;
           margin-right: 30px
        }

        .header-links li {
           display: inline-block;
           margin-left:25px;
           font-size: 18px;
           position: relative;
           font-weight:bold;
        }

        .header-links a{
           text-decoration:none;
           color:black;
        }


        #logo{
           width:200px;
           height:50px;
        }

        ol{
           display: none;
        }

        #room img{
           opacity: 0.8;
         
        }
        
        .btn a{
        	text-decoration:none;
        	color:white;
        }
         
         
</style>

</head>
<body>


<div class="header">
      <div class="header-logo">
         <a href="/TripleJ/index.jsp"><img id ="logo" src="${pageContext.request.contextPath}/resources/images/logo1.png"/></a>
      </div>
      
      <div class="header-links">
         <ul>

            <li><a href="/TripleJ/work/list.jsp">work</a></li>
            <li><a href="#">favor</a></li>
            <li><a href="#">enjoy</a></li>
            <li><a href="/TripleJ/board/list.jsp">blogging</a></li>
            <li>
            <%
			//세션에 저장된 id 읽어오기
			String id=(String)session.getAttribute("id");
			%>
			<%if(id!=null){ %>
			<button class=" btn btn-danger">
				<a href="/TripleJ/users/logout.jsp"><%=id %></a>
			</button>
			<%}else{ %>
            <button class="trigger-custom btn btn-danger" data-izimodal-open="#modal-custom">Login</button>
            <%} %>
            </li>
         </ul>
      </div>
</div>

<div id="modal-custom" data-iziModal-group="grupo1">
        <button data-iziModal-close class="icon-close">x</button>
        <header>
            <a href="" class="active" id="signin">Sign in</a>
            <a href="" >New Account</a>
        </header>
	        <section>
	        <form action="/TripleJ/users/login.jsp" method="post" id="myForm">
	            <input type="text" placeholder="Username" name="id" id="id">
	            <input type="password" placeholder="Password" name="pwd" id="pwd">
	            <footer>
	                <button data-iziModal-close>Cancel</button>
	                <button type="submit" class="submit">Log in</button>            
	            </footer>
	        </form>
	        </section>
        <section class="hide">
        <form action="/TripleJ/users/signup.jsp" method="post" id="signupFrom">
            <input type="text" placeholder="Username" name="nid" id="nid">
            <input type="text" placeholder="Email" name="nemail" id="nemail">
            <input type="password" placeholder="Password" name="npwd" id="npwd">
            <label for="check"><input type="checkbox" name="checkbox" id="check" value="1"> I agree to the <u>Terms</u>.</label>
            <footer>
                <button data-iziModal-close>Cancel</button>
                <button type="submit" class="submit">Create Account</button>            
            </footer>
            </form>
        </section>
    </div>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/iziModal.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery.form.min.js"></script>
<script>
$(function(){

	  /* Instantiating iziModal */
	  $("#modal-custom").iziModal({
	      overlayClose: false,
	      overlayColor: 'rgba(0, 0, 0, 0.6)'

	  });

	  /*$(document).on('click', '.trigger-custom', function (event) {
	      event.preventDefault();
	      $('#modal-custom').iziModal('open');
	  });*/

	  /* JS inside the modal */

	  $("#modal-custom").on('click', 'header a', function(event) {
	      event.preventDefault();
	      var index = $(this).index();
	      $(this).addClass('active').siblings('a').removeClass('active');
	      $(this).parents("div").find("section").eq(index).removeClass('hide').siblings('section').addClass('hide');


	      if( $(this).index() === 0 ){
	          $("#modal-custom .iziModal-content .icon-close").css('background', '#ddd');
	      } else {
	          $("#modal-custom .iziModal-content .icon-close").attr('style', '');
	      }
	  });
	  

		$("#myForm").ajaxForm(function(responseData){
			console.log(responseData);
			if(responseData.isSuccess){
				alert("login-success");
				$('#modal-custom').iziModal('close', {
				    transition: 'bounceOutDown' // Here transitionOut is the same property.
				});
				window.location.reload();
			}else{
				alert("login failed");
			}
		});
		
		$("#signupFrom").ajaxForm(function(responseData){
			console.log(responseData);
			if(responseData.isSuccess){
				alert("signup success");
				$('#modal-custom').iziModal('close', {
				    transition: 'bounceOutDown' // Here transitionOut is the same property.
				});
				window.location.reload();
			}else{
				alert("signup failed");
			}
		});
	  
	})
	  







</script>
</body>
</html>