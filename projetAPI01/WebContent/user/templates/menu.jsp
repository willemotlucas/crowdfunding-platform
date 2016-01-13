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
      <a class="navbar-brand" href="#">Launch my idea!</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/projetAPI01/user/homepage">Accueil <span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Gestion des idées<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/projetAPI01/user/ideas/proposed">Mes idées proposées</a></li>
            <li><a href="/projetAPI01/user/ideas/evaluated">Les idées évaluées</a></li>
            <li><a href="/projetAPI01/user/ideas/pledged">Les idées financées</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/projetAPI01/user/comments/posted">Mes commentaires</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search" method="POST" action="/projetAPI01/search">
        <div class="form-group">
          <input type="text" id="search" name="search" class="form-control" placeholder="Rechercher une idée">
        </div>
        <button type="submit" class="btn btn-default">Rechercher</button>
      </form>
      <form class="navbar-form navbar-right">
	      <div class="form-group">
	      	<a href="/projetAPI01/user/addIdea.jsp" class="btn btn-success" role="button">Proposer mon idée</a>
	      </div>
	      <div class="form-group">
	      	<a href="/projetAPI01/logout" class="btn btn-primary" role="button">Déconnexion</a>
	      </div>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>