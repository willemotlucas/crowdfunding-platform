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
      <a class="navbar-brand" href="homeAdmin.jsp">Launch my idea! - Management</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/projetAPI01/admin/manageUsers">Users</a></li>
        <li><a href="/projetAPI01/admin/manageIdeas">Ideas</a></li>
        <li><a href="">Discussions</a></li>
        <li><a href="">Redactions</a></li>
        <li><a href="">Evaluations</a></li>
        <li><a href="">Fundings</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search" method="POST" action="/projetAPI01/search">
        <div class="form-group">
          <input type="text" id="search" name="search" class="form-control" placeholder="Rechercher une idée">
        </div>
        <button type="submit" class="btn btn-default">Rechercher</button>
      </form>
      <form class="navbar-form navbar-right" method="GET" action="/user/addIdea">
      <div class="form-group">
      	<button type="submit" class="btn btn-success">Proposer mon idée</button>
      </div>
      <div class="form-group">
      	<a href="/projetAPI01/logout" class="btn btn-primary" role="button">Déconnexion</a>
      </div>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>