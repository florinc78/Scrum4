<h3>List</h3>
<div class="container-fluid" id="storycatlist">
	<div class="row">
		
	</div>
</div>
<script>
	$(document)
			.ready(
					function() {
						$.getJSON('http://localhost:8080/scrum4/storycat/rest/list.json', function(json) {
							$.each(json, function(i, storycat) {
								var $row = $("<div>", {id: "row"+i, class: "row", style: "height:30px;", onmouseover:"bigImg(this)", onmouseout:"normalImg(this)"});
								var $div = $("<div>", {id: "cell"+i, class: "col-md-4", text: storycat.name});
								var $remove = $("<a>", {id: "a"+i, href:"#", style: "visibility:hidden"});
								var $icon = $("<span>", {class:"glyphicon glyphicon-remove", style:"color:red;"});
								
								$remove.append($icon);
								$div.append($remove);
								$row.append($div);
								
								if (storycat.userStories.length>0){
									var $tableStories = $("<table cellpadding=\"5\" cellspacing=\"0\" border=\"0\" style=\"padding-left:50px;\">");
									
									
									for (var j=0;j<storycat.userStories.length;j++){
										//var $divStory = $("<div>", {id: "cell"+j, class: "col-md-4", text: storycat.userStories[j].code+ "aa"+j });
										//$row.append($divStory);
										//var $storyTr = 
										
										
									}
									
								}
								
								
								
								$("#storycatlist").append($row);
							});
						});
					});
	
	function format ( d ) {
	    // `d` is the original data object for the row
	    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
	        '<tr>'+	            
	            '<td>'+d.name+'</td>'+
	        '</tr>'+
	        '<tr>'+
	            '<td>Extension number:</td>'+
	            '<td>'+d.extn+'</td>'+
	        '</tr>'+
	    '</table>';
	}
	
	function bigImg(x) {
		//$(x.id+"> div > a").css("visibility: hidden");
		var cell = x.firstChild;
		cell.querySelector('a').style.visibility = "visible";
	}

	function normalImg(x) {
		var cell = x.firstChild;
		cell.childNodes[1].style.visibility = "hidden";
	}
</script>