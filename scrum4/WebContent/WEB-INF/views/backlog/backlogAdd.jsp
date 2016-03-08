<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<br>
<!-- form role="form" class="form-horizontal" action="/scrum4/useradd.html" method="post" enctype="application/x-www-form-urlencoded"-->
<form:form action="/scrum4/backlog/add.html" commandName="backlog" class="form-horizontal" method="POST">
	<div class="form-group">
		<label for="name" class="control-label col-xs-2">Name:</label>
		<div class="col-xs-4"> 
		<!-- input type="text" class="form-control" id="userid" name="userid"-->
		<form:input path="name" class="form-control"/>
		<form:hidden path="uuid"/>
		<form:hidden path="dataInTr"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="/scrum4/backlog/list.html" role="button" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</div>
</form:form>	
<!-- /form-->
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script>
	
</script>