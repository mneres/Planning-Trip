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
		
		$scope.updateSchedule = function(schedule, name){
			schedule.name = name;
			schedule.$update();
			$scope.message = "Planejamento editado com sucesso!";
		}
		
		$scope.deleteSchedule = function(schedule) {
			schedule.$remove(function() {
	    		$scope.schedules.splice($scope.schedules.indexOf(schedule), 1);
	    		$scope.message = "Planejamento removido com sucesso!";
	    	});
	    };
	    
	    $scope.getSchedule = function(){
	    	$scope.selectedSchedule = ScheduleFactory.get({id: $routeParams.scheduleID});
	    };
	    
	    $scope.addTripOnSchedule = function(placeOfDeparture, arrivalEmplacement, 
				transportCompany, transportPrice, accommodationName, accommodationPrice, 
				startsAt, endsOn){
	    	
	    	var trip = {
	    			"placeOfDeparture": placeOfDeparture,
	    			"arrivalEmplacement": arrivalEmplacement,
	    			"transportCompany": transportCompany,
	    			"transportPrice": transportPrice,
	    			"accommodationName": accommodationName,
	    			"accommodationPrice": accommodationPrice,
	    			"startsAt": startsAt,
	    			"endsOn": endsOn
	    	};

	    	$http.post('/api/schedules/' + $routeParams.scheduleID + '/addTrip', trip)
			.success(function(data){
	    		$scope.message = "Trip inserida com sucesso";
	    		console.log(data);
			});
	   };
	   
	   $scope.removeTripFromSchedule = function(scheduleID, trip){
		   $http.delete('/api/schedules/' + scheduleID + '/removeTrip/' + trip.id)
			.success(function(data){
	    		$scope.message = "Trip removida com sucesso";
	    		var i = $scope.selectedSchedule.trips.indexOf(trip);
	    		$scope.selectedSchedule.trips.splice(i,1);
			});
	   };
	   
	   $scope.openEditScheduleModal = function(schedule){
		   $scope.selectedSchedule = schedule;
		   $scope.editScheduleName = $scope.selectedSchedule.name;
		   $("#editSchedule").modal();
	   }
	};
	
	ScheduleController.$inject = ['$scope', '$http', '$routeParams', 'ScheduleFactory'];
	angular.module("myApp.controllers").controller("ScheduleController", ScheduleController);
}(angular));