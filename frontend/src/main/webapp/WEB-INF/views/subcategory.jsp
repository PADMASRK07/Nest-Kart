<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">
<style>
h4 {
	font-family: "Roboto";
	font-weight: 500;
	font-size: 14px;
	color: #aeaeae;
	text-transform: uppercase;
	margin: 0;
}

hr {
	margin-bottom: 16px;
	border: 1px solid #eaeaea;
}

.border-card {
	background: #fff;
	margin-bottom: 30px;
	display: flex;
	align-items: center;
	font-family: "Roboto";
	font-size: 14px;
	padding: 12px 16px;
	cursor: pointer;
	border-radius: 4px;
	border: 1px solid #eaeaea;
	box-shadow: 0px 2px 1px 0px rgba(0, 0, 0, 0.1);
	transition: all 0.25s ease;
}

.border-card:hover {
	-webkit-transform: translateY(-1px);
	transform: translateY(-1px);
	box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0.1), 0 5px 10px 0
		rgba(0, 0, 0, 0.1);
}

.border-card.over {
	background: rgba(70, 222, 151, 0.15);
	padding-top: 24px;
	padding-bottom: 24px;
	border: 2px solid #47DE97;
	box-shadow: 0 5px 10px 0 rgba(0, 0, 0, 0), 0 5px 10px 0 rgba(0, 0, 0, 0);
}
   
.border-card.over .card-type-icon {
	color: #47DE97 !important;
}

.border-card.over p {
	color: #47DE97 !important;
}

.content-wrapper {
	display: flex;
	justify-content: flex-start;
	width: 100%;
	white-space: nowrap;
	overflow: hidden;
	transition: all 0.25s ease;
}

.min-gap {
	flex: 0 0 300px;
}

.card-type-icon {
	flex-grow: 0;
	flex-shrink: 0;
	margin-right: 16px;
	font-weight: 400;
	color: #323232;
	border-radius: 50%;
	width: 40px;
	height: 40px;
	text-align: center;
	line-height: 40px;
	font-size: 14px;
	transition: all 0.25s ease;
}

.card-type-icon.with-border {
	color: #aeaeae;
	border: 1px solid #eaeaea;
}

.card-type-icon i {
	line-height: 40px;
}

.label-group {
	white-space: nowrap;
	overflow: hidden;
}

.label-group.fixed {
	flex-shrink: 0;
}

.label-group p {
	margin: 0px;
	line-height: 21px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.label-group p.title {
	color: #323232;
	font-weight: 500;
	text-transform: uppercase;
}

.end-icon {
	margin-left: 16px;
}

.a1 {
	font-size: 20px;
}

.errinfo {
	color: #F83605;
}

.alert {
	font-color: green;
	background-color: #A9BFC3;
	font-size: 20px;
}
</style>
<div class="container">
	<c:if test="${info}">
		<div class="alert">
			<strong>${message}</strong>
		</div>
	</c:if>
	<div class="row">
		<div class="col-12">
			<c:if test="${editmode}">
				<c:url var="myurl" value="updatesubcategory"></c:url>
			</c:if>
			<c:if test="${! editmode}">
				<c:url var="myurl" value="subcategory"></c:url>
			</c:if>
			<form:form action="${myurl}" method="post"
				modelAttribute="subcategory">
				<c:if test="${editmode}">
					<div class="form-group">
						<div class="row">
							<div class="col-5">
								<label style="font-size: 20px">SubCategory Id</label>
							</div>
							<div class="col-7">
								<div class="input-group">
									<div class="input-group-prepend">
										<LABEL CLASS="input-group-text"><i
											class="fa fa-list-alt" aria-hidden="true"></i></LABEL>
									</div>
									<form:input type="text" class="form-control"
										placeholder="Enter the Category" path="sub_cat_id"
										readonly="true" />
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<div class="form-group">
					<div class="row">
						<div class="col-5">
							<label style="font-size: 20px">SubCategory Name</label>
						</div>
						<div class="col-7">
							<div class="input-group">
								<div class="input-group-prepend">
									<LABEL CLASS="input-group-text"><i
										class="fa fa-list-alt" aria-hidden="true"></i></LABEL>
								</div>
								<form:input type="text" class="form-control"
									placeholder="Enter Subcategory Name" path="sub_cat_name" />
							</div>
						</div>
						<div class="col-5"></div>
						<div class="col-7">
							<form:errors path="sub_cat_name" cssClass="errinfo"></form:errors>
						</div>
					</div>
				</div>
				<br>
				<div class="form-group">

					<div class="row">
						<div class="col-5">
							<label style="font-size: 20px">Category Name</label>
						</div>
						<div class="col-7">
						<div class="input-group">
								<div class="input-group-prepend">
									<LABEL CLASS="input-group-text"><i
										class="fa fa-list-alt" aria-hidden="true"></i></LABEL>
								</div>
							<form:select path="cat.cat_id" class="form-control">
								<c:forEach var="c" items="${catlist}">
									<form:option value="${c.cat_id}">${c.cat_name}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
				</div>
				</div>
				<br>

				<div class="form-group">
					<DIV CLASS="ROW">
						<div class="col-5"></DIV>
						<DIV CLASS="COL-3">
							<input class="btn btn-success my-2 my-sm-0" type="submit">
						</DIV>
						<div class="col-4"></DIV>
					</DIV>
				</div>

			</form:form>

		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-12">
			<h4>SubCategory Available</h4>
			<c:if test="${empty subcatlist}">
				<div class="jumbotron">
					<strong>No SubCategory Available Add SubCategory Now</strong>
				</div>
			</c:if>
			<br>
			<c:if test="${not empty subcatlist}">
				<c:forEach items="${subcatlist}" var="s">
					<div class="border-card">
						<div class="card-type-icon with-border">${s.sub_cat_id}</div>
						<div class="content-wrapper">
							<div class="label-group fixed col-3">
								<p class="title">${s.sub_cat_name}</p>
							</div>
							<div class="col-1"></div>
							<div class="label-group fixed col-3">
								<p class="title">${s.cat.cat_name}</p>
							</div>
							<div class="col-1"></div>
							
							<div class="label-group col-2">
								<p class="title">
									<a href="editsubcategory?subcatid=${s.sub_cat_id}"
										class="btn btn-success"><i class="fa fa-edit">Edit</i></a>
								</p>
							</div>
							<div class="label-group col-2">
								<p class="title">
									<a class="btn btn-danger"
										href="deletesubcategory?subcatid=${s.sub_cat_id}"><i
										class="fa fa-trash">Delete</i></a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
</div>