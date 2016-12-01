$jq(function() {

    $jq('#login-form-link').click(function(e) {
		$jq("#login-form").delay(100).fadeIn(100);
 		$jq("#register-form").fadeOut(100);
		$jq('#register-form-link').removeClass('active');
		$jq(this).addClass('active');
		e.preventDefault();
	});
	$jq('#register-form-link').click(function(e) {
		$jq("#register-form").delay(100).fadeIn(100);
 		$jq("#login-form").fadeOut(100);
		$jq('#login-form-link').removeClass('active');
		$jq(this).addClass('active');
		e.preventDefault();
	});

});