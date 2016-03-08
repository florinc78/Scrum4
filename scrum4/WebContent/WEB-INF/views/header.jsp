<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="${currentPage eq 'home' ? 'active': 'inactive'}"><a href="/scrum4/page1.html">Home</a></li>
				<li class="${currentPage eq 'backlog' ? 'active': 'inactive'}"><a href="/scrum4/backlog/list.html">Backlog</a></li>
				<li class="${currentPage eq 'storycat' ? 'active': 'inactive'}"><a href="/scrum4/storycat/list.html">User stories cat</a></li>
				<li class="${currentPage eq 'userstories' ? 'active': 'inactive'}"><a href="/scrum4/userstories/list.html">User stories</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>