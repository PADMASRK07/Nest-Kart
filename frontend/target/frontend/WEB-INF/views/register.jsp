<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.a1 
sss{
	font-size: 20px;
}
</style>

<div class="container1">
	<c:if test="${info}">
		<div class="alert alert-info">
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
					<label><a class="a">USERNAME</a></label>
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
					<form:errors path="cusname" cssClass="errinfo"></form:errors>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<label><a class="a">EMAILID</a></label>
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
					<form:errors path="cusemailid" cssClass="errinfo"></form:errors>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<label><a class="a">PHONENUMBER</a></label>
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
					<form:errors path="phonenumber" cssClass="errinfo"></form:errors>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<label><a class="a">PASSWORD</a></label>
				</div>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<LABEL CLASS="input-group-text"><I CLASS="fa fa-lock"></I></LABEL>
						</div>
						<form:input type="password" class="form-control"
							placeholder="@!%$&*a-z" path="password" />
					</div>
				</div>
				<div class="col-5"></div>
				<div class="col-7">
					<form:errors path="password" cssClass="errinfo"></form:errors>
				</div>
			</div>
		</div>
		<br>

		<div class="form-group">
			<DIV CLASS="ROW">
				<div class="col-5"></DIV>
				<DIV CLASS="COL-4">
					<form:input type="submit" class="btn btn-success my-2 my-sm-0" />
				</DIV>
				<div class="col-3"></DIV>
			</DIV>
		</div>
		<br>
		<br>
		<div class="form-group">
			<DIV CLASS="ROW">
				<div class="col-5"></DIV>
				<div class="col-4">
					<span style="color: #1C4F73">view products ?<a> Login</a></span>
				</DIV>
				<div class="col-3"></DIV>
			</div>
		</div>
		</form:form>
</div>

