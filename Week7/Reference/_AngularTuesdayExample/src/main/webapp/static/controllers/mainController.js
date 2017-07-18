app.controller('nameTableController', function($scope){
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
			$scope.fnamecheck=true;
		}else{
			$scope.fnamecheck=false;
		}
	}
	
	$scope.nullCheckLast = function(){
		if(!($scope.fname && $scope.lname)){
			$scope.disabled = true;
		}else{
			$scope.disabled = false;
		}
		if(!$scope.lname){
			$scope.lnamecheck=true;
		}else{
			$scope.lnamecheck=false;
		}
	}
});