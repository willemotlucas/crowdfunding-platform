<form data-toggle="validator" method="POST" action="comment/add">
	<div class=row>
		<div class="col-lg-3 col-md-3">
			<div class="form-group">
			  <label class="control-label" for="comment">Ajouter un commentaire :</label>
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