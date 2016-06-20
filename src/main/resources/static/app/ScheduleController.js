(function(angular) {	
	var ScheduleController = function($scope, $http, $routeParams, ScheduleFactory) {
		
		ScheduleFactory.query(function(response) {
			$scope.schedules = response ? response : [];
		});
		
		$scope.addSchedule = function(name){
			newSchedule = new ScheduleFactory({
		    	name: name
			});
			newSchedule.$save();
			$scope.newScheduleName = "";
			$scope.message = "Planejamento adicionado com sucesso!";
			$scope.schedules.push(newSchedule);
		};
		
		$scope.deleteSchedule = function(schedule) {
			schedule.$remove(function() {
	    		$scope.schedules.splice($scope.schedules.indexOf(schedule), 1);
	    		$scope.message = "Planejamento removido com sucesso!";
	    	});
	    };
	    
	    $scope.getSchedule = function(){
	    	$scope.selectedSchedule = ScheduleFactory.get({id: $routeParams.scheduleID});
	    }
	};
	
	ScheduleController.$inject = ['$scope', '$http', '$routeParams', 'ScheduleFactory'];
	angular.module("myApp.controllers").controller("ScheduleController", ScheduleController);
}(angular));