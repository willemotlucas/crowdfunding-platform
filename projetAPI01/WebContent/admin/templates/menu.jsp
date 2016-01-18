<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/projetAPI01/admin/homepage">Launch my idea! - Management</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/projetAPI01/admin/manageUsers"><i class="fa fa-user"></i>&nbsp;&nbsp;Utilisateurs</a></li>
        <li><a href="/projetAPI01/admin/manageIdeas"><i class="fa fa-lightbulb-o"></i>&nbsp;&nbsp;Idees</a></li>
        <li><a href="/projetAPI01/admin/manageComments"><i class="fa fa-commenting"></i>&nbsp;&nbsp;Commentaires</a></li>
        <li><a href="/projetAPI01/admin/manageScores"><i class="fa fa-thumbs-o-up"></i>&nbsp;&nbsp;Scores</a></li>
        <li><a href="/projetAPI01/admin/manageEvals"><i class="fa fa-star-o"></i>&nbsp;&nbsp;Evaluations</a></li>
        <li><a href="/projetAPI01/admin/manageFunds"><i class="fa fa-usd"></i>&nbsp;&nbsp;Financements</a></li>
      </ul>
      <!-- form class="navbar-form navbar-left" role="search" method="POST" action="/projetAPI01/search">
        <div class="form-group">
          <input type="text" id="search" name="search" class="form-control" placeholder="Rechercher une idée">
        </div>
        <button type="submit" class="btn btn-default">Rechercher</button>
      </form -->
      <form class="navbar-form navbar-right" method="GET" action="/projetAPI01/admin/idea/addIdea.jsp">
	      <div class="form-group">
	      	<button type="submit" class="btn btn-success">Proposer mon idée</button>
	      </div>
	      <div class="form-group">
	      	<a href="/projetAPI01/logout" class="btn btn-primary" role="button">Déconnexion</a>
	      </div>
      </form>
    </div>
  </div>
</nav>