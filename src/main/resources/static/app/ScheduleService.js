(function(angular) {
  var ScheduleFactory = function($resource) {
    return $resource('/api/schedules/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  ScheduleFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("ScheduleFactory", ScheduleFactory);
}(angular));