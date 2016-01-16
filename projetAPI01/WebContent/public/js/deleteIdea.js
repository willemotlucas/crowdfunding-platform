$(document).ready(function(){
	$('.deleteIdea').click(function(event){		
		var choice = confirm("Etes-vous sur de vouloir supprimer cette idee ?")
		if(choice == true){ //Press OK
			//Make the post request in ajax
			var idIdea = event.target.id;

			var data = {
				idIdea: idIdea,
			};
			
			$('tr#' + idIdea).remove();
			
			$.ajax({
				type:'POST',
				url: '/projetAPI01/user/idea/delete',
				data: data
			});
		}	
	})	
})
