$(document).ready(function() {

	$(".mark-complete").click(function() {
		var itemId = $(this).data('id');
		$.ajax({
			url: '/todo/markComplete',
			method: 'POST',
			data: {
				itemId: itemId
			},
			success: function(response) {
				$('#status-' + itemId).text('Complete');
				$('button[data-id="' + itemId + '"]').remove();
				$('a[data-id="' + itemId + '"]').remove();
			},
			error: function(xhr, status, error) {
				alert("Error: " + error);
			}
		});
	});
});