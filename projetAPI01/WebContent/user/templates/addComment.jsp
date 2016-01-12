<form data-toggle="validator" method="POST" action="comment/add">
	<div class=row>
		<div class="col-lg-1 col-md-1">
			<img class="img-circle" src="http://placehold.it/80x80">
		</div>
		<div class="col-lg-5 col-md-5">
			<div class="form-group">
			  <h3 class="control-label" for="comment" style="margin-top:0px;">Ajouter un commentaire</h3>
			  <textarea class="form-control" rows="3" id="comment" name="comment" data-minlength="2" maxLength="255"></textarea>					  
			  <div class="help-block with-errors"></div>
			</div>
			<input type="hidden" name="idIdea" id="idIdea" value="${idIdea}"/>
			<div class="form-group">
				<button type="submit" class="btn btn-success">Ajouter</button>
			</div>
		</div>
	</div>
</form>