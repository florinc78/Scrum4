<div class="starter-template">
	<table id="example" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th style="width:80px"></th>
				<th>Id</th>
				<th>Name</th>
				<th>Last modified</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<div class="btn-group pull-right">
		<a href="/scrum4/user/add.html" role="button" class="btn btn-primary">Add</a>
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
							"mDataProp" : "userId"
						}, {
							"mDataProp" : "userName"
						}, {
							"mDataProp" : "lastmodified"
						} ];
						$("#example")
								.dataTable(
										{
											"sAjaxSource" : "http://localhost:8080/scrum4/rest/user/list.json",
											"serverSide" : true,
											"processing" : true,
											"bFilter" : false,
											"order" : [ 3, "desc" ],
											"bAutoWidth": false,
											"aoColumns" : columns,
											"bLengthChange" : false,
											"columnDefs" : [
													{
														"targets" : 0,
														"orderable": false,
														"render" : function(
																data, type,
																full, meta) {
															return '<a href="/scrum4/user/edit.html?uuid='
																	+ data
																	+ '">Edit</a> <a href="/scrum4/user/del.html?uuid='
																	+ data
																	+ '">Delete</a>';
														}
													},
													{
														"targets" : 3,
														"render" : function(
																data, type,
																full, meta) {
															return new Date(
																	data)
																	.toLocaleString();
														}
													} ]
										});
					});
</script>