<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- CSS -->
	<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico" />"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.fancybox.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/account.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
	<!-- JS -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.fancybox.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/user.js" />"></script>
    
	<title>Campus : par des étudiants, pour des étudiants</title>
</head>
<body>
	<div id="header-wrapper">
		<div id="header-center">
			<div id="header-logo">
				<img src="<c:url value="/resources/img/logo_beta.png" />" />
			</div>
			<div id="header-menu">
				<ul>
					<li><a href="#" class="shadow-text">Mon Profil</a></li>
					<li><a href="#" class="shadow-text">Trombinoscope</a></li>
					<li><a href="UserServlet?action=closeSessionUser"
						class="shadow-text">Déconnexion</a></li>
				</ul>
			</div>
			<div id="header-campus-and-name">
				<span>${ userSession.surname } <b>${ userSession.name }</b></span><br />
				Campus de ${ userSession.campus.name }
			</div>
		</div>
	</div>
	<div id="blackbar-wrapper">
		<div id="blackbar-center">
			<a href="#fancy_uploadPhoto" class="fancybox">
				<span id="blackbar-photo" class="profile-photo">
					<img src="${ userSession.photo }" width="225" height="315" />
				</span>
			</a>
			<div id="blackbar-profile">
				<div id="blackbar-title">Profil</div>
				<div id="blackbar-name">
					<b>Nom :</b> ${ fn:toUpperCase(userSession.name) }
				</div>
				<div id="blackbar-surname">
					<b>Prénom :</b> ${ userSession.surname }
				</div>
				<div id="blackbar-birth">
					<b>Date de naissance :</b>
					<fmt:formatDate value="${ userSession.birth }"
						pattern="MM/dd/yyyy" />
				</div>
			</div>
		</div>
	</div>
	<div id="pagecontent-wrapper">
		<div id="pagecontent-center">
			
		</div>
	</div>

	<!-- UPLOAD PROFILE PHOTO FANCYBOX -->
	<div class="invisible">
		<div id="fancy_uploadPhoto">
			<form action="" method="POST" enctype="multipart/form-data">
				<input type="file" name="profilePhoto" id="uploadPhoto"/>
				<input type="submit" name="uploadPhoto" id="uploadPhoto"/>
			</form>
		</div>
	</div>

	<div id="footer"></div>
	email : ${userSession.email}
	<c:set var="birth">
		<fmt:formatDate pattern="dd/MM/yyyy"
			value="${userSession.birth}" />
	</c:set>
	birth : ${birth} nom : ${userSession.name} prenom :
	${userSession.surname}
	<img src="${ userSession.photo }" />

	<form action="UserServlet?action=showCampusTrombi" method="post">
		<input type="submit" value="trombi" name="trombi" />
	</form>

	<form action="UserServlet?action=updatePhoto"
		enctype="multipart/form-data" method="post">
		<input type="file" name="photo" id="photo" /> <input type="submit"
			name="sendPhoto" id="sendPhoto" value="Envoyer" />
	</form>
	<img src="${ userSession.photo }" />
</body>
</html>