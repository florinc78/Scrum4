<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<br>
<!-- form role="form" class="form-horizontal" action="/scrum4/userstories/edit.html" method="post" enctype="application/x-www-form-urlencoded"-->
<form:form action="/scrum4/userstories/add.html" commandName="storycat" class="form-horizontal" method="POST">
	<div class="form-group row">
		<label for="code" class="control-label col-xs-2">Cod:</label>
		<div class="col-xs-4"> 
		<form:input path="code" class="form-control"/>
		</div>
	</div>	
	<div class="form-group row">
		<label for="actor" class="control-label col-xs-2">Actor:</label>
		<div class="col-xs-4">
		<form:input path="actor" class="form-control"/>
		</div>
	</div>	
	<div class="form-group row">	
		<label for="action" class="control-label col-xs-2">Action:</label>
		<div class="col-xs-4">
		<form:input path="action" class="form-control"/>
		</div>
	</div>	
	<div class="form-group row">	
		<label for="target" class="control-label col-xs-2">Target:</label>
		<div class="col-xs-4">
		<form:input path="target" class="form-control"/>
		</div>
		</div>	
	<div class="form-group row">
		<label for="comments" class="control-label col-xs-2">Comments:</label>
		<div class="col-xs-4">
		<form:input path="comments" class="form-control"/>
		</div>
		</div>	
	<div class="form-group row">
		<label for="points" class="control-label col-xs-2">Points:</label>
		<div class="col-xs-4">
		<form:input path="points" class="form-control"/>
		</div>
	</div>	
	<form:hidden path="uuid"/>
	<form:hidden path="dataInTr"/>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<a href="/scrum4/story/list.html" role="button" class="btn btn-default">Cancel</a>
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</div>
</form:form>	
<!-- /form-->
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script>
	
</script>