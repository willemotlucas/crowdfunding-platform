$(document).ready(function(){
	$('#pledge').click(function(e){
		var amount = parseInt($('#amountPledged').val());
		console.log(amount);
		if(amount > 0 && amount <= 5000){
			//Update values
			var newTotalAmount = parseInt($("#totalAmount").html()) + amount;
			$("#totalAmount").html(newTotalAmount);
			$('#pledge').attr("disabled", true);
			$('#formPledgeIdea').remove();
			$('#labelPledge').html('Vous avez soutenu cette idee a hauteur de ' + amount + ' euros, merci :) !');
			
			//Make the post request in ajax
			//Retrieve the idea's id in the url
			var url = window.location.href;
			var urlTab = url.split("=");
			var idIdea = urlTab [1];

			var data = {
				idIdea: idIdea,
				amount: amount
			};
			
			$.ajax({
				type:'POST',
				url: 'fund/add',
				data: data
			});
		}
	})
})