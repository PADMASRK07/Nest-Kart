<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.a1
{
	font-size: 20px;
}
.errinfo
{
	color:#F83605;
}
.alert
{
font-color:green;
background-color:#F5BB08;
font-size:20px;
}
</style>

<div class="container">
	<c:if test="${info}">
		<div class="alert">
			<strong>${message}</strong>
		</div>
	</c:if>
	<form:form action="register" method="post" modelAttribute="customer">
		<div class="form-group">
			<DIV CLASS="ROW">
				<div class="col-5"></DIV>
				<DIV CLASS="COL-4">
					<h2 style="color: green">REGISTER</h2>
				</DIV>
				<div class="col-3"></DIV>
			</DIV>
		</div>
		<br>
		<div class="form-group">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<label><a class="a1">Username</a></label>
				</div>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<LABEL CLASS="input-group-text"><I CLASS="fa fa-user"></I></LABEL>
						</div>
						<form:input type="text" class="form-control" placeholder="padma"
							path="cus_name" />
					</div>
				</div>
				<div class="col-5"></div>
				<div class="col-7">
					<form:errors path="cus_name" cssClass="errinfo"></form:errors>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<label><a class="a1">Emailid</a></label>
				</div>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<LABEL CLASS="input-group-text"><I CLASS="fa fa-envelope"></I></LABEL>
						</div>
						<form:input type="text" class="form-control"
							placeholder="padmasrk07@gmail.com" path="cus_emailid" />
					</div>
				</div>
				<div class="col-5"></div>
				<div class="col-7">
					<form:errors path="cus_emailid" cssClass="errinfo"></form:errors>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<label><a class="a1">Phonenumber</a></label>
				</div>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<LABEL CLASS="input-group-text"><I CLASS="fa fa-phone"></I></LABEL>
						</div>
						<form:input type="text" class="form-control"
							placeholder="+91----------" path="cus_phonenumber" />
					</div>
				</div>
				<div class="col-5"></div>
				<div class="col-7">
					<form:errors path="cus_phonenumber" cssClass="errinfo"></form:errors>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<label><a class="a1">Password</a></label>
				</div>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<LABEL CLASS="input-group-text"><I CLASS="fa fa-lock"></I></LABEL>
						</div>
						<form:input type="password" class="form-control"
							placeholder="@!%$&*a-z" path="cus_password" />
					</div>
				</div>
				<div class="col-5"></div>
				<div class="col-7">
					<form:errors path="cus_password" cssClass="errinfo"></form:errors>
				</div>
				
			</div>
		</div>
		<br>

		<div class="form-group">
			<DIV CLASS="ROW">
				<div class="col-5"></DIV>
				<DIV CLASS="COL-7">
					<input type="submit" class="btn btn-success my-2 my-sm-0" />
				</DIV>
				<div class="col-3"></DIV>
			</DIV>
		</div>
		<br>
		<br>
		
		<div class="form-group">
			<DIV CLASS="ROW">
				<div class="col-4"></DIV>
				<div class="col-8">
					<span style="color: #1C4F73">Like to view products ?<a href="login"> Login</a></span>
				</DIV>
				<div class="col-3"></DIV>
			</div>
		</div>
		</form:form>
</div>

