<div class="starter-template">
	<table id="example" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th style="width:150px"></th>
				<th>Name</th>
				<th>Last modified</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="btn-group pull-right">
		<a href="/scrum4/backlog/add.html" role="button" class="btn btn-primary">Add</a>
	</div>
</div>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						var columns = [ {
							"mDataProp" : "uuid"
						}, {
							"mDataProp" : "name"
						}, {
							"mDataProp" : "lastmodified"
						} ];
						$("#example")
								.dataTable(
										{
											"sAjaxSource" : "http://localhost:8080/scrum4/backlog/rest/list.json",
											"serverSide" : true,
											"processing" : true,
											"bFilter" : false,
											"order" : [ 2, "desc" ],
											"aoColumns" : columns,
											"bAutoWidth": false,
											"bLengthChange" : false,
											"columnDefs" : [
													{
														"targets" : 0,
														"orderable": false,
														"render" : function(
																data, type,
																full, meta) {
															return '<a href="/scrum4/backlog/list.html?uuid='
																	+ data
																	+'">View</a> <a href="/scrum4/backlog/edit.html?uuid='
																	+ data
																	+ '">Edit</a> <a href="/scrum4/backlog/del.html?uuid='
																	+ data
																	+ '">Delete</a>';
														}
													},
													{
														"targets" : 2,
														"render" : function(
																data, type,
																full, meta) {
															return new Date(data).toLocaleString();
														}
													} ]
										});
					});
</script>