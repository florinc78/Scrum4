<div class="starter-template">
	<table id="example" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th style="width:80px"></th>
				<th>Cod</th>
				<th>Actor</th>
				<th>Action</th>
				<th>Target</th>
				<th>Comments</th>
				<th>Points</th>
				<th>Last modified</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="btn-group pull-right">
		<a href="/scrum4/userstories/add.html" role="button" class="btn btn-primary">Add</a>
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
							"mDataProp" : "code"
						}, {
							"mDataProp" : "actor"
						}, {
							"mDataProp" : "action"
						}, {
							"mDataProp" : "target"
						}, {
							"mDataProp" : "comments"
						}, {
							"mDataProp" : "points"							
						}, {
							"mDataProp" : "lastModified"
						} ];
						$("#example")
								.dataTable(
										{
											"sAjaxSource" : "http://localhost:8080/scrum4/userstories/rest/list.json",
											"serverSide" : true,
											"processing" : true,
											"bFilter" : false,
											"bAutoWidth": false,
											"order" : [ 2, "desc" ],
											"aoColumns" : columns,
											"bLengthChange" : false,
											"columnDefs" : [
													{
														"targets" : 0,
														"orderable": false,
														"render" : function(
																data, type,
																full, meta) {
															return '<a href="/scrum4/userstories/edit.html?uuid='
																	+ data
																	+'">View</a> <a href="/scrum4/userstories/edit.html?uuid='
																	+ data
																	+ '">Edit</a> <a href="/scrum4/userstories/del.html?uuid='
																	+ data
																	+ '">Delete</a>';
														}
													},
													{
														"targets" : 7,
														"render" : function(
																data, type,
																full, meta) {
															return new Date(data).toLocaleString();
														}
													} ]
										});
					});
</script>