$(document).ready(function(){
	$('#vote').click(function(){
		if($('#feasibility').val() == parseInt($('#feasibility').val(), 10) && $('#marketInterest').val() == parseInt($('#marketInterest').val(),10) && $('#impact').val() == parseInt($('#impact').val(),10)){
			var feasibility = parseInt($('#feasibility').val());
			var marketInterest = parseInt($('#marketInterest').val());
			var impact = parseInt($('#impact').val());
			
			if(feasibility >= 0 && feasibility <= 10 && $.isNumeric(feasibility)
			&& marketInterest >= 0 && marketInterest <= 10 && $.isNumeric(marketInterest)
			&& impact >= 0 && impact <=10 && $.isNumeric(impact)){
				var test = $('#meanFeasibility').html();
				console.log(test);
				
				if(test != undefined){
					var newFeasibility = (parseFloat($('#meanFeasibility').html().replace(',', '.')) + feasibility)/2;
					newFeasibility = parseFloat(newFeasibility).toFixed(2);
					var newMarketInterest = (parseFloat($('#meanMarketInterest').html().replace(',', '.')) + marketInterest)/2;
					newMarketInterest = parseFloat(newMarketInterest).toFixed(2);
					var newImpact = (parseFloat($('#meanImpact').html().replace(',', '.')) + impact)/2;
					newImpact = parseFloat(newImpact).toFixed(2);
					var newMean = (parseFloat(newFeasibility) + parseFloat(newMarketInterest) + parseFloat(newImpact))/3;
					newMean = parseFloat(newMean).toFixed(2);

					$('#meanFeasibility').html(newFeasibility);
					$('#meanMarketInterest').html(newMarketInterest);
					$('#meanImpact').html(newImpact);
					$('#mean').html(newMean);					
				}

				$('#feasibility').attr("disabled", true);
				$('#marketInterest').attr("disabled", true);
				$('#impact').attr("disabled", true);
				$('#vote').attr("disabled", true);

				//Make the post request in ajax
				//Retrieve the idea's id in the url
				var url = window.location.href;
				var urlTab = url.split("=");
				var idIdea = urlTab [1];

				var data = {
					idIdea: idIdea,
					feasibility: feasibility,
					marketInterest: marketInterest,
					impact: impact
				};
				
				$.ajax({
					type:'POST',
					url: 'evaluation/add',
					data: data
				}).done(function(){
					if(test == undefined){
						location.reload(true);
					}
				});
		
			}		
		}

	})
})
