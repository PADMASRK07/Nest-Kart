<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div style="margin: 1%; min-height: 300px;">
		<c:if test="${sliderpage}">
			<jsp:include page="homepage.jsp" />
		</c:if>
		<c:if test="${homepage}">
			<jsp:include page="homepage.jsp" />
		</c:if>
		<c:if test="${aboutuspage}">
			<jsp:include page="aboutus.jsp" />
		</c:if>
		<c:if test="${contactuspage}">
			<jsp:include page="contactus.jsp" />
		</c:if>
		<c:if test="${loginpage}">
			<jsp:include page="login.jsp" />
		</c:if>
		<c:if test="${registerpage}">
			<jsp:include page="register.jsp" />
		</c:if>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
