(function ($) {
	$(function () {
		$(".table tbody tr").hover(
			function () {
				$(this).addClass("hover");
			}, 
			function () {
				$(this).removeClass("hover");
			}
		);
	});
})(jQuery);