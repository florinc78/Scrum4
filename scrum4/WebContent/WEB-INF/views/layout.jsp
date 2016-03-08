<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title><tiles:insertAttribute name="title"/></title>

<!-- Bootstrap core CSS -->
<link href="/scrum4/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/scrum4/css/jquery.dataTables.min.css">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<!-- link href="../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet"-->

<!-- Custom styles for this template -->
<link href="/scrum4/css/starter-template.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- script src="../../assets/js/ie-emulation-modes-warning.js"></script-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<c:set var="currentPage" scope="request"><tiles:getAsString name="currentPage"/></c:set>
<script src="/scrum4/js/jquery-2.2.0.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="/scrum4/js/bootstrap.min.js"></script>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script-->
	
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<!-- script src="../../assets/js/ie10-viewport-bug-workaround.js"></script-->
</body>

</html>