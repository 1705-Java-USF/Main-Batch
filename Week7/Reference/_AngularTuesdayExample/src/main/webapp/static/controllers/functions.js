	nullCheck = function(){
		if(!($scope.fname && $scope.lname)){
			$scope.disabled = true;
		}else{
			$scope.namesError = "";
			$scope.disabled = false;
		}
	}