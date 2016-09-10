<%@ include file="Common-Header.jsp"%>

<!--Login form start from here-->
<div class="container" >
	<div class="row" align="center">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<div class="account-wall">
				<form class="form-signin">
					<input type="text" class="form-control" placeholder="Email"
						required autofocus> <input type="password"
						class="form-control" placeholder="Password" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Sign in</button>
					<label class="checkbox pull-right"> <input type="checkbox"
						value="remember-me"> Remember me
					</label> <a href="#" class="pull-left need-help">Need help? </a><span
						class="clearfix"></span>
				</form>
			</div>
			<a href="Register" class="text-center new-account">Create an
				account </a>
		</div>
	</div>
</div>
<!--Login form ends here-->


<%@ include file="Common-Footer.jsp"%>