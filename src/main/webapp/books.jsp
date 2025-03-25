<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js" lang="zxx">


<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sách</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Place favicon.ico in the root directory -->
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="shortcut icon" type="image/ico" href="images/favicon.ico" />

<!-- Plugin-CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/icofont.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/cardslider.css">
<link rel="stylesheet" href="css/responsiveslides.css">

<!-- Main-Stylesheets -->
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/overright.css">
<link rel="stylesheet" href="css/theme.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/responsive.css">
<script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body data-spy="scroll" data-target="#mainmenu" data-offset="50">
	<header class="relative" id="sc1">
		<!-- Header-background-markup -->
		<div class="overlay-bg relative">
			<img src="images/slide/slide1.jpg" alt="">
		</div>
		<!-- Mainmenu-markup-start -->
		<div class="mainmenu-area navbar-fixed-top" data-spy="affix"
			data-offset-top="10">
			<nav class="navbar">
				<div class="container">
					<div class="navbar-header">
						<div class="space-10"></div>
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#mainmenu">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<!--Logo-->
						<!-- <a href="#sc1" class="navbar-left show"><img src="images/logo.png" alt="library"></a> -->
						<div class="space-10"></div>
					</div>
					<!--Toggle-button-->

					<!--Active User-->
					<div class="nav navbar-right">
						<div class="active-user navbar-left active">
							<ul class="list-unstyled">
								<li><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"> <img src="images/active_user.png"
										class="img-circle img-thumbnail" alt="library" />
								</a>
									<ul class="dropdown-menu">
										<li><a href="#"> <span><i
													class="icofont icofont-user"></i></span> Thông tin cá nhân
										</a></li>
										<!-- <li>
                                            <a href="#"> <span><i class="icofont icofont-notification"></i></span> Notifications</a>
                                        </li> -->
										<li><a href="#"> <span><i
													class="icofont icofont-ui-password"></i></span> Đổi mật khẩu
										</a></li>
										<li><a href="#"> <span><i
													class="icofont icofont-read-book"></i></span> Sách của tôi
										</a></li>
										<li><a href="#"> <span><i
													class="icofont icofont-logout"></i></span> Đăng xuất
										</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
					<!--Mainmenu list-->
					<div class="navbar-right in fade" id="mainmenu">
						<ul class="nav navbar-nav nav-white text-uppercase">
							<li><a href="index.jsp">Trang chủ</a></li>
							<li><a href="#">Giới thiệu</a></li>
							<li><a href="noitification.jsp">Thông báo</a></li>
							<li><a href="room.jsp">Phòng đọc</a></li>
							<li><a href="feedback.jsp">Phản hồi</a></li>
							<li class="active"><a href="books.jsp">Sách</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="space-100"></div>
		<!-- Mainmenu-markup-end -->
		<!-- Header-jumbotron -->
		<div class="space-100"></div>
		<div class="header-text">
			<div class="container">
				<div class="row wow fadeInUp">
					<div class="col-xs-12 col-sm-10 col-sm-offset-1 text-center">
						<div class="jumbotron">
							<h1 class="text-white">Chọn sách của bạn và tận hưởng</h1>
						</div>
						<div class="title-bar white">
							<ul class="list-inline list-unstyled">
								<li><i class="icofont icofont-square"></i></li>
								<li><i class="icofont icofont-square"></i></li>
							</ul>
						</div>
						<div class="space-40"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="space-100"></div>
		<!-- Header-jumbotron-end -->
	</header>
	<section>
		<div class="space-80"></div>
		<div class="container">
			<div class="row">
				<!-- Sidebar-Start -->
				<div class="col-xs-12 col-md-2">
					<aside>
						<div class="sigle-sidebar">
							<h4>
								<i class="icofont icofont-listine-dots"></i> Danh mục
							</h4>
							<hr>
							<ul class="list-unstyled menu-tip">
								<li><a href="#">Âm nhạc</a></li>
								<li><a href="#">Marketing</a></li>
								<li><a href="#">Chính trịn</a></li>
								<li><a href="#">Lịch sử</a></li>
								<li><a href="#">Toán học</a></li>
								<li><a href="#">Địa lí</a></li>
								<li><a href="#">Công nghệ</a></li>
							</ul>
							<a href="#" class="btn btn-primary btn-xs">Xem thêm</a>

						</div>

						<div class="space-20"></div>
					</aside>
				</div>
				<!-- Sidebar-End -->
				<div class="col-xs-12 col-md-10 pull-right">
					<h4>Tìm kiếm</h4>
					<div class="space-5"></div>
					<form action="#">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Nhập tên sách hoặc tên tác giả">
							<div class="input-group-btn">
								<button type="submit" class="btn btn-primary">
									<i class="icofont icofont-search-alt-2"></i>
								</button>
							</div>
						</div>
					</form>
					<div class="space-30"></div>
					<div class="row">
						<div class="pull-left col-xs-12 col-sm-5 col-md-6">
							<!-- <p>Kết quả <a href="#" class="text-primary">"How To Be a Designer"</a></p> -->
							<p>
								<strong>6</strong> of <strong>76</strong> cuốn sách được tìm
								thấy
							</p>
						</div>
						<!-- sắp xếp(từ từ tính) -->
						<!-- <div class="pull-right col-xs-12 col-sm-7 col-md-6">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label class="control-label col-xs-4" for="sort">Sắp xếp theo : </label>
                                    <div class="col-xs-8">
                                        <div class="form-group">
                                            <select name="sort" id="sort" class="form-control">
                                                <option value="">Năm xuất </option>
                                                <option value="">Best Book</option>
                                                <option value="">Latest Book</option>
                                                <option value="">Old Book</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div> -->
					</div>
					<hr>
					<div class="space-20"></div>
					<div class="row">

						<div class="col-xs-12 col-md-6">
							<div class="category-item well yellow">
								<div class="media">
									<div class="media-left">
										<img src="images/book/book-xs-1.jpg" class="media-object"
											alt="">
									</div>
									<div class="media-body">
										<h5>Smothered In Hughs</h5>
										<h6>By John Doe</h6>
										<div class="space-10"></div>
										<ul class="list-inline list-unstyled rating-star">
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li><i class="icofont icofont-star"></i></li>
										</ul>
										<div class="space-10"></div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit, sed do eiusmod tempor</p>
										<a href="books.jsp" class="text-primary">Xem sách</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-6">
							<div class="category-item well yellow">
								<div class="media">
									<div class="media-left">
										<img src="images/book/book-xs-2.jpg" class="media-object"
											alt="">
									</div>
									<div class="media-body">
										<h5>The Art Of The Surf</h5>
										<h6>By Mako Sheffield</h6>
										<div class="space-10"></div>
										<ul class="list-inline list-unstyled rating-star">
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
											<li><i class="icofont icofont-star"></i></li>
										</ul>
										<div class="space-10"></div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit, sed do eiusmod tempor</p>
										<a href="books.jsp" class="text-primary">Xem sách</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-6">
							<div class="category-item well yellow">
								<div class="media">
									<div class="media-left">
										<img src="images/book/book-xs-3.jpg" class="media-object"
											alt="">
									</div>
									<div class="media-body">
										<h5>Creative Business</h5>
										<h6>By Sarah Smith</h6>
										<div class="space-10"></div>
										<ul class="list-inline list-unstyled rating-star">
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
										</ul>
										<div class="space-10"></div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit, sed do eiusmod tempor</p>
										<a href="books.jsp" class="text-primary">Xem sách</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-6">
							<div class="category-item well yellow">
								<div class="media">
									<div class="media-left">
										<img src="images/book/book-xs-4.jpg" class="media-object"
											alt="">
									</div>
									<div class="media-body">
										<h5>Hustle Now Enjoy Later</h5>
										<h6>By Benjamin Thomson</h6>
										<div class="space-10"></div>
										<ul class="list-inline list-unstyled rating-star">
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
										</ul>
										<div class="space-10"></div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit, sed do eiusmod tempor</p>
										<a href="books.jsp" class="text-primary">Xem sách</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-6">
							<div class="category-item well yellow">
								<div class="media">
									<div class="media-left">
										<img src="images/book/book-xs-5.jpg" class="media-object"
											alt="">
									</div>
									<div class="media-body">
										<h5>The History Of Street Art</h5>
										<h6>By Linda Dinno</h6>
										<div class="space-10"></div>
										<ul class="list-inline list-unstyled rating-star">
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
										</ul>
										<div class="space-10"></div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit, sed do eiusmod tempor</p>
										<a href="books.jsp" class="text-primary">Xem sách</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-6">
							<div class="category-item well yellow">
								<div class="media">
									<div class="media-left">
										<img src="images/book/book-xs-6.jpg" class="media-object"
											alt="">
									</div>
									<div class="media-body">
										<h5>The Beaten Path</h5>
										<h6>By Ed Espisona</h6>
										<div class="space-10"></div>
										<ul class="list-inline list-unstyled rating-star">
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class="active"><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
											<li class=""><i class="icofont icofont-star"></i></li>
										</ul>
										<div class="space-10"></div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit, sed do eiusmod tempor</p>
										<a href="books.jsp" class="text-primary">Xem sách</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="space-60"></div>
					<div class="row">
						<div class="col-xs-12">
							<div class="shop-pagination pull-right">
								<ul id="pagination-demo" class="pagination-sm pagination">
									<li class="page-item first"><a href="#" class="page-link">First</a></li>
									<li class="page-item prev"><a href="#" class="page-link">Previous</a></li>
									<li class="page-item"><a href="#" class="page-link">1</a></li>
									<li class="page-item"><a href="#" class="page-link">2</a></li>
									<li class="page-item active"><a href="#" class="page-link">3</a></li>
									<li class="page-item"><a href="#" class="page-link">4</a></li>
									<li class="page-item"><a href="#" class="page-link">5</a></li>
									<li class="page-item"><a href="#" class="page-link">6</a></li>
									<li class="page-item"><a href="#" class="page-link">7</a></li>
									<li class="page-item next"><a href="#" class="page-link">Next</a></li>
									<li class="page-item last"><a href="#" class="page-link">Last</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="space-80"></div>
	</section>
	<!-- Footer-Area -->
	<footer class="black-bg text-white">
		<div class="space-60"></div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-4">
					<a href="#"><img src="images/logo.png" alt="library"></a>
					<div class="space-20"></div>
					<p>Đến, đọc, tận hưởng.</p>
					<div class="space-10"></div>
					<ul class="list-inline list-unstyled social-list">
						<li><a href="#"><i
								class="icofont icofont-social-facebook"></i></a></li>
						<li><a href="#"><i class="icofont icofont-social-twitter"></i></a></li>
						<li><a href="#"><i class="icofont icofont-social-behance"></i></a></li>
						<li><a href="#"><i class="icofont icofont-brand-linkedin"></i></a></li>
					</ul>
					<div class="space-10"></div>
					<ul class="list-unstyled list-inline tip yellow">
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-3 col-md-offset-1">
					<h4 class="text-white">Liên hệ</h4>
					<div class="space-20"></div>
					<table class="table border-none addr-dt">
						<tr>
							<td><i class="icofont icofont-social-google-map"></i></td>
							<td><address>Số 1, Võ Văn Ngân, Thủ Đức, TP. Hồ
									Chí Minh</address></td>
						</tr>
						<tr>
							<td><i class="icofont icofont-email"></i></td>
							<td>susislibrary@domain.com</td>
						</tr>
						<tr>
							<td><i class="icofont icofont-phone"></i></td>
							<td>+62 582 528 527 21</td>
						</tr>
						<tr>
							<td><i class="icofont icofont-globe-alt"></i></td>
							<td><a href="www.susislibrary.com" target="_blank">www.susislibrary.com</a></td>
						</tr>
					</table>
				</div>
				<!-- <div class="col-xs-12 col-sm-4 col-md-3 col-md-offset-1">
                    <h4 class="text-white">Useful Link</h4>
                    <div class="space-20"></div>
                    <ul class="list-unstyled menu-tip">
                        <li><a href="books.jsp">Costumer Service</a></li>
                        <li><a href="books.jsp">Help Desk</a></li>
                        <li><a href="books.jsp">Forum</a></li>
                        <li><a href="books.jsp">Staff Profile</a></li>
                        <li><a href="books.jsp">Live Chat</a></li>
                    </ul>
                </div> -->
			</div>
		</div>
		<div class="space-60"></div>
	</footer>
	<!-- Footer-Area-End -->

	<!-- Vandor-JS -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<!-- Plugin-JS -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/responsiveslides.min.js"></script>
	<script src="js/jquery.cardslider.min.js"></script>
	<script src="js/pagination.js"></script>
	<script src="js/scrollUp.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/plugins.js"></script>
	<!-- Active-JS -->
	<script src="js/main.js"></script>

</body>

</html>