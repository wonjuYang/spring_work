<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>TripleJ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/iziModal.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flexslider.css" />
<style>

   		html{
   			font-size:10px;
   		}
   		
   		#room{
   			background-color: pink;
   			padding-top: 120px;
   		}
   		
   		.wrapper{
   			display:flex;
   			flex-flow:column wrap;
   			align-items:center;

   		}


   		h1, h2{
   			color:white; 
   		}
   		
   		.wrapper>h1{
   			font-weight: 700;
   			margin-top:0;
			margin-bottom: 20px;
			font-size: 5.2rem;
   		}

   		.wrapper>h2{
   			margin-top:0;
   			margin-bottom: 40px;
   			font-size: 2.1rem
   		}

         h2{
            font-size: 4.8rem;
            font-weight: bold;

         }
  

         .flexslider{
            margin:0 auto;
            width:650px;
            background-color: transparent;
            border:none;
         }
         
          .section{
            overflow: hidden;
            position: relative;
            width:100%;
            height: 100%;
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

         

         .about__heading{
            padding-left: 8.333333333%;
            text-align: left;
            padding-top:50px;
            color:black;
         }

         .about__intro{
            margin-bottom: 7.7rem;
            padding-left: 8.333333333%;
            text-align: left;
         }

         .cols--flex, .cols.flex {
             display: flex;
             flex-wrap: wrap;
         }        


         

         body{
            background-color: #E3E8EB;
            font-weight: 500;
         }

         .about__single{
            overflow:visible;
            height: 600px;
            margin-bottom: 130px;
         }

         #about__work{
            background-color:#A1CBDE;
         }

         #about__favor{
            background-color:#F8D06F;
         }

         #about__favor h5{
            color:#F8D06F;
         }



         #about__enjoy{
            background-color:#88CF8F;
         }

         #about__blogging{
            background-color:#CA99D7;
         }



         .about__image-wrap{
            margin:0 auto;
            margin-top: 16rem;
            position: relative;
            z-index: 1;
            width: 50%;
         }


         .about__single-image{
            width:42.1rem;
            left: 50%;
            position: absolute;
            transform: translateX(-50%) translateY(-50%) scale(1);
            top: 50%;
            z-index: 2;
         }


         .about__content-wrap_odd{
            top:-20px;
            padding-right:87px; 
            padding-left:8px;
            position: relative;
            z-index: 2;
            width: 50%;
         }


         .about__content-wrap_even{
            top:-20px;
            padding-left:87px; 
            padding-right:8px;
            position: relative;
            z-index: 2;
            width: 50%;
         }

         .about__single-content-inner{
            top:-30px;
            padding-top:50px;
            padding-bottom:80px;
            padding-left:100px;
            padding-right:100px;
            height: auto;
            background-color: white;
         }

         .about__single-content-inner h5{
            color:skyblue;
            font-weight: 700;
            margin-bottom:20px;
         }

         .about__single-content-inner h3{
            font-weight: 1000;
            margin-bottom: 2rem;
         }

         .about__single-content-inner p{
            font-size: 20px;
         }

         .button--white, button--white {
            background-color: #fff;
            border-color: #f1f4f6;
             color: #282a2d;
         }
         .button--border, button--border {
            border: .3rem solid transparent;
            line-height: 4.2rem;
         }
         .btn__inner{
            position: relative;
            margin-top:10px;
            text-align: center;
         }
         
         .white_color{
         	color:white;
         }

         

       

      


   </style>
</head>
<body>

<div class="page ">

	<!-- header include -->
	<%@include file="/include_files/header.jsp" %>
	
	<!--body-->

	<div class="home" id="fullpage">
		<div id="room" class="">
			<div class="wrapper">
				<h1 class="white_color">Everything about tripleJ</h1>
				<h2 class="white_color">tripleJ's work, favor, enjoy and blogging </h2>
			</div>
         <div class="flexslider">
            <ul class="slides">
              <li>
                  <img src="${pageContext.request.contextPath}/resources/images/main_1.png"/>
               </li>
               <li>
                  <img src="${pageContext.request.contextPath}/resources/images/main_2.png" />
               </li>
               <li>
                  <img src="${pageContext.request.contextPath}/resources/images/main_3.png"/>
               </li>           
            </ul>
         </div>
		</div>
		<div class="About">
         <div class="container">
            <div class="about_wrapper">
               <h2 class=about__heading>About Me</h2>
               <p class=about__intro>I, tripleJ, have many interesting thoughts about the world.</p>
               <div class="about__single section" id="about__work">
                  <div class="cols cols--flex">
                     <div class="col col--m6 col--t6 col--w7 about__image-wrap">
                        <img src="${pageContext.request.contextPath}/resources/images/하늘공원.jpeg" class="about__single-image">
                     </div>
                     <div class="col col--m6 col--t6 col--w5 about__content-wrap_odd">
                        <div class="about__single-content">
                           <div class="about__single-content-inner">
                              <h5>work revolutionary THIGNS</h5>
                              <h3>Web and Blockchain</h3>
                              <p>Major in Global media and Economics in SoongSil univ. interested in how to increasing efficiency in various area including works, economy and life.  </p>
                              <button class="btn btn-info btn__inner">about WORK</button>
                           </div> 
                        </div>
                     </div>
                  </div>
               </div>
               
               <div class="about__single section" id="about__favor">
                  <div class="cols cols--flex">   
                     <div class="col col--m6 col--t6 col--w5 about__content-wrap_even">
                        <div class="about__single-content">                           
                           <div class="about__single-content-inner">
                              <h5>game and idol are my favorite</h5>
                              <h3>play game and follow idols</h3>
                              <p> when I have a time, I Usually  play game like overwatch, battleground and so on. I also enjoy game league because gamer can play professional and it looks like cool. I follow some idols, too, because of their passion and work.</p>
                              <button class="btn btn-warning btn__inner">about FAVOR</button>
                           </div>
                        </div>
                     </div>
                     <div class="col col--m6 col--t6 col--w7 about__image-wrap">
                        <img src="${pageContext.request.contextPath}/resources/images/성수대교.jpg" class="about__single-image">
                     </div>
                  </div>
               </div>
               <div class="about__single section" id="about__enjoy"></div>
               <div class="about__single section" id="about__blogging"></div>

            </div>
         </div>
		
		</div>


	</div>

	<!--footer-->


</div>


<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.flexslider.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/iziModal.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery.form.min.js"></script>


<script>


	//변수 ht에 브라우저의 높이값을 저장
	var ht = $(window).height(); 

	//브라우저의 높이값을 section의 높이값으로 지정
	$("section").height(ht);


    $('.flexslider').flexslider();





</script> 
</body>
</html>