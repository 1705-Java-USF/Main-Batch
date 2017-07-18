app.controller('nameTableController', function($scope){
	/*
	 * $scope: This is an example of an angular service.
	 *As mentioned before, all services are singletons and
	 *instantiated only once.
	 *
	 *We must inject these services in any component that needs to
	 *use it. In this case, we have injected $scope into our
	 *controller: 'nameTableController' for use.
	 *IE. Dependency Injection.
	 *
	 *$scope is used to reference any models created on the html page.
	 *Consider is like calling page.varname in servlets. 
	 *so page.varname = $scope.varname
	 */
	$scope.nameTable = function(){
		var person = {
			fname: $scope.fname,
			lname: $scope.lname
		};
		$scope.names.push(person);
		$scope.fname = "";
		$scope.lname = "";
		$scope.disabled = true;
	}
	
	$scope.nullCheckFirst = function(){
		if(!($scope.fname && $scope.lname)){
			$scope.disabled = true;
		}else{
			$scope.disabled = false;
		}
		
		if(!$scope.fname){
			$scope.fnamecheck = true;
		}else{
			$scope.fnamecheck = false;
		}
	}
	
	$scope.nullCheckLast = function(){
		if(!($scope.fname && $scope.lname)){
			$scope.disabled = true;
		}else{
			$scope.disabled = false;
		}
		
		if(!$scope.lname){
			$scope.lnamecheck = true;
		}else{
			$scope.lnamecheck = false;
		}
	}
	
})