<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<br>
<!-- form role="form" class="form-horizontal" action="/scrum4/useradd.html" method="post" enctype="application/x-www-form-urlencoded"-->
<form:form action="/scrum4/user/add.html" commandName="user" class="form-horizontal" method="POST">
	<div class="form-group">
		<label for="userId" class="control-label col-xs-2">Userid:</label>
		<div class="col-xs-4"> 
		<!-- input type="text" class="form-control" id="userid" name="userid"-->
		<form:input path="userId" class="form-control"/>
		<form:hidden path="uuid"/>
		<form:hidden path="dataInTr"/>
		</div>
	</div>
	<div class="form-group">
		<label for="userName" class="control-label col-xs-2">Username:</label>
		<div class="col-xs-4"> 
		<!-- input type="text" class="form-control" id="username" name="username"-->
		<form:input path="userName" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="/scrum4/user/list.html" role="button" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</div>
</form:form>	
<!-- /form-->
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script>
	
</script>