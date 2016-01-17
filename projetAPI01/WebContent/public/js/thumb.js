$(document).ready(function(){
	$('#thumbs-up').click(function(){
		if(!$('#thumbs-down').hasClass('btn-danger') && !$('#thumbs-up').hasClass('btn-success')){
			$('#thumbs-up').addClass('btn-success');
			var positiveScore = parseInt($('#positiveScore').html()) + 1;
			$('#positiveScore').text(" " + positiveScore);
			var newScore = parseInt($('#score').html()) + 1;
			$('#score').html(newScore);
			var newNbVotants = parseInt($('#nbVotants').html()) + 1;
			$('#nbVotants').html(newNbVotants);
			
			//Make the post request in ajax
			//Retrieve the idea's id in the url
			var url = window.location.href;
			var urlTab = url.split("=");
			var idIdea = urlTab [1];

			var data = {
				idIdea: idIdea,
				score: 1
			};
			
			$.ajax({
				type:'POST',
				url: 'thumbs/add',
				data: data
			});
		}
	});
	
	$('#thumbs-down').click(function(){
		if(!$('#thumbs-down').hasClass('btn-danger') && !$('#thumbs-up').hasClass('btn-success')){
			$('#thumbs-down').addClass('btn-danger');
			var positiveScore = parseInt($('#negativeScore').html()) + 1;
			$('#negativeScore').text(" " + positiveScore);
			var newScore = parseInt($('#score').html()) - 1;
			$('#score').html(newScore);
			var newNbVotants = parseInt($('#nbVotants').html()) + 1;
			$('#nbVotants').html(newNbVotants);
			
			//Make the post request in ajax
			//Retrieve the idea's id in the url
			var url = window.location.href;
			var urlTab = url.split("=");
			var idIdea = urlTab[1];

			var data = {
				idIdea: idIdea,
				score: -1
			};
			
			$.ajax({
				type:'POST',
				url: 'thumbs/add',
				data: data
			});
		}
		
	});	
})