app.controller('loginController','authService', function($scope, authService) {

   $scope.credentials = {
      username: 'jono',
      password: '123'
   };

   $scope.submit= function () {
      authService.login(credentials).then(function (user) {
         alert(user);
      });

   };

});